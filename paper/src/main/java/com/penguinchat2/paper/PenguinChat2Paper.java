package com.penguinchat2.paper;

import cloud.commandframework.CommandManager;
import cloud.commandframework.execution.CommandExecutionCoordinator;
import cloud.commandframework.paper.PaperCommandManager;
import com.penguinchat2.core.PenguinChat2;
import com.penguinchat2.core.locale.TranslationManager;
import com.penguinchat2.paper.commands.PaperCommandRegistrar;
import com.penguinchat2.paper.config.PaperConfigManager;
import com.penguinchat2.paper.config.configs.MessagesConfig;
import com.penguinchat2.paper.util.PaperLogger;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.nio.file.Path;
import java.util.function.Function;

public class PenguinChat2Paper extends JavaPlugin implements PenguinChat2 {
    private CommandManager<CommandSender> commandManager;
    private PaperLogger logger;
    private PaperConfigManager configManager;
    private TranslationManager translationManager;

    @Override
    public void onLoad() {
        this.logger = new PaperLogger(getLogger());
    }

    @Override
    public void onEnable() {
        try {
            this.configManager = new PaperConfigManager(this);
            this.configManager.loadConfigs();

            this.translationManager = new TranslationManager(this);
            this.translationManager.reload();

            this.commandManager = new PaperCommandManager<>(this, CommandExecutionCoordinator.simpleCoordinator(), Function.identity(), Function.identity());
            PaperCommandRegistrar.registerCommands(this);

        } catch (Exception e) {
            this.logger.error("Failed to enable PenguinChat2", e);
        }
    }

    @Override
    public CommandManager<CommandSender> commandManager() {
        return commandManager;
    }

    @Override
    public Path dataDirectory() {
        return getDataFolder().toPath();
    }

    @Override
    public TranslationManager translationManager() {
        return translationManager;
    }

    @Override
    public PaperConfigManager configManager() {
        return configManager;
    }

    public MessagesConfig messagesConfig() {
        return configManager.getConfig("messages", MessagesConfig.class);
    }

    @Override
    public PaperLogger logger() {
        return logger;
    }

    @Override
    public void reload() {
        this.configManager.loadConfigs();
        this.translationManager.reload();
        logger().info("Reloaded PenguinChat2");
    }
}