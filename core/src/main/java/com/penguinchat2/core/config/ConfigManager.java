package com.penguinchat2.core.config;

import com.penguinchat2.core.PenguinChat2;
import com.penguinchat2.core.config.loader.ConfigEntry;
import org.spongepowered.configurate.ConfigurateException;

import java.util.HashMap;
import java.util.Map;

public abstract class ConfigManager {
    protected Map<String, ConfigEntry<?>> configs = new HashMap<>();

    public ConfigManager(PenguinChat2 penguinChat2) {
    }

    public void loadConfigs() {
        try {
            for (ConfigEntry<?> config : this.configs.values()) {
                config.loadConfig();
            }
        } catch (ConfigurateException e) {
            throw new IllegalStateException("Failed to load config", e);
        }
    }

    public <T> T getConfig(String name, Class<T> type) {
        ConfigEntry<?> entry = this.configs.get(name);
        if (entry == null) {
            throw new IllegalArgumentException("No config registered with name: " + name);
        }
        if (!type.isAssignableFrom(entry.getType())) {
            throw new IllegalArgumentException("The config with name " + name + " is not of type " + type.getName());
        }
        return type.cast(entry.getConfig());
    }
}