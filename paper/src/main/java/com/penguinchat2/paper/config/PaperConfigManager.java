package com.penguinchat2.paper.config;

import com.penguinchat2.core.config.ConfigManager;
import com.penguinchat2.core.config.loader.ConfigEntry;
import com.penguinchat2.paper.PenguinChat2Paper;
import com.penguinchat2.paper.config.configs.MessagesConfig;

import java.nio.file.Path;

public final class PaperConfigManager extends ConfigManager {
    public PaperConfigManager(PenguinChat2Paper penguinChat2) {
        super(penguinChat2);
        Path dataDirectory = penguinChat2.dataDirectory();
        this.configs.put("messages", new ConfigEntry<>(MessagesConfig.class, dataDirectory.resolve("messages.yml"), "Messages Configuration"));
    }
}