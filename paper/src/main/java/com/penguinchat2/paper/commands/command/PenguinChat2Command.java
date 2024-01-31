package com.penguinchat2.paper.commands.command;

import cloud.commandframework.arguments.standard.StringArgument;
import cloud.commandframework.context.CommandContext;
import cloud.commandframework.meta.CommandMeta;
import net.kyori.adventure.text.minimessage.MiniMessage;
import com.penguinchat2.core.locale.Messages;
import com.penguinchat2.paper.PenguinChat2Paper;
import com.penguinchat2.paper.commands.AbstractPaperCommand;
import org.bukkit.command.CommandSender;

public final class PenguinChat2Command extends AbstractPaperCommand {
    public PenguinChat2Command(PenguinChat2Paper penguinChat2) {
        super(penguinChat2);
    }

    @Override
    public void register() {
        var builder = this.commandManager.commandBuilder("pc2")
            .meta(CommandMeta.DESCRIPTION, penguinChat2.messagesConfig().commands().penguinChat2().helpMsg()
            );

        this.commandManager.command(builder.literal("help")
        .argument(StringArgument.optional("query", StringArgument.StringMode.GREEDY))
        .handler(context -> {
            this.helpManager.getMinecraftHelp().queryCommands(context.getOrDefault("query", ""), context.getSender());
        }));

        this.commandManager.command(builder.literal("about")
            .permission("pc2.about")
            .meta(CommandMeta.DESCRIPTION, penguinChat2.messagesConfig().commands().penguinChat2().about().helpMsg())
            .handler(this::aboutCommand)
        );

        this.commandManager.command(builder.literal("reload")
            .permission("pc2.reload")
            .meta(CommandMeta.DESCRIPTION, penguinChat2.messagesConfig().commands().penguinChat2().reload().helpMsg())
            .handler(this::reloadCommand)
        );
    }

    /**
     * Handeler for the /pc2 about command
     * @param context the data specified on registration of the command
     */
    private void aboutCommand(CommandContext<CommandSender> context) {
        context.getSender().sendMessage(Messages.prefixed(
            MiniMessage.miniMessage().deserialize(
                penguinChat2.messagesConfig().commands().penguinChat2().about().output().get(0)
            )
        ));
    }

    /**
     * Handeler for the /pc2 reload command
     * @param context the data specified on registration of the command
     */
    private void reloadCommand(CommandContext<CommandSender> context) {
        penguinChat2.reload();
        context.getSender().sendMessage(Messages.prefixed(
                MiniMessage.miniMessage().deserialize(penguinChat2.messagesConfig().commands().penguinChat2().reload().output().get(0))
        ));
    }
}