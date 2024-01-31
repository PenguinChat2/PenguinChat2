package com.penguinchat2.paper.commands;

import cloud.commandframework.CommandManager;
import cloud.commandframework.minecraft.extras.MinecraftHelp;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import com.penguinchat2.core.commands.AbstractCommand;
import com.penguinchat2.core.commands.HelpManager;
import com.penguinchat2.paper.PenguinChat2Paper;
import org.bukkit.command.CommandSender;

public abstract class AbstractPaperCommand implements AbstractCommand {
    protected final PenguinChat2Paper penguinChat2;
    protected final CommandManager<CommandSender> commandManager;
    protected final HelpManager<CommandSender> helpManager;
    protected final BukkitAudiences audiences;

    public AbstractPaperCommand(PenguinChat2Paper penguinChat2) {
        this.audiences = BukkitAudiences.create(penguinChat2);
        this.penguinChat2 = penguinChat2;
        this.commandManager = penguinChat2.commandManager();
        this.helpManager = new HelpManager<>(new MinecraftHelp<>("/pc2 help", audiences::sender, this.commandManager));
    }

    @Override
    public abstract void register();
}