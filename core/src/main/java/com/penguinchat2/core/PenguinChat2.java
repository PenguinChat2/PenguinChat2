package com.penguinchat2.core;

import cloud.commandframework.CommandManager;
import com.penguinchat2.core.config.ConfigManager;
import com.penguinchat2.core.locale.TranslationManager;
import com.penguinchat2.core.utils.PenguinChat2Logger;

import java.nio.file.Path;


public interface PenguinChat2 {
    public PenguinChat2Logger logger();
    public Path dataDirectory();
    public CommandManager<?> commandManager();
    public ConfigManager configManager();
    public TranslationManager translationManager();
    public void reload();
}