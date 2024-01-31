package com.penguinchat2.paper.commands;

import com.penguinchat2.paper.PenguinChat2Paper;
import com.penguinchat2.paper.commands.command.*;

import java.util.stream.Stream;

public class PaperCommandRegistrar {
    /**
     * Register commands; all must be included here
     *
     * @param penguinChat2 PenguinChat2Paper instance
     */
    public static void registerCommands(PenguinChat2Paper penguinChat2) {
        Stream.of(
            new PenguinChat2Command(penguinChat2)
        ).forEach(AbstractPaperCommand::register);
    }
}