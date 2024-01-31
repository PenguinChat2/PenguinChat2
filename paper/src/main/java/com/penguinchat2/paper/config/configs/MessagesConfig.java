package com.penguinchat2.paper.config.configs;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.objectmapping.meta.Comment;
import org.spongepowered.configurate.objectmapping.meta.Setting;

import java.util.List;

@Accessors(fluent = true)
@Getter
@ConfigSerializable
public final class MessagesConfig {
    @Setting("message-prefix") private String messagePrefix = "<lang:pc2.general.prefix>";

    private Commands commands = new Commands();

    @Getter 
    @ConfigSerializable
    public static final class Commands {
        private PenguinChat2 penguinChat2 = new PenguinChat2();

        @Getter 
        @ConfigSerializable
        public static final class PenguinChat2 {
            private About about = new About();
            private Reload reload = new Reload();
            @Setting("help-msg") private String helpMsg = "<lang:pc2.command.help.pc2>";

            @Getter 
            @ConfigSerializable
            public static final class About {
                @Setting("help-msg") private String helpMsg = "<lang:pc2.command.help.pc2.about>";
                @Setting("output") private List<String> output = List.of(
                    "<lang:pc2.command.output.pc2.about:'<dark_aqua><lang:pc2.general.version>'>");
            }

            @Getter 
            @ConfigSerializable
            public static final class Reload {
                @Setting("help-msg") private String helpMsg = "<lang:pc2.command.help.pc2.reload>";
                @Setting("output") private List<String> output = List.of(
                    "<lang:pc2.command.output.pc2.reload>");
            }
        }
    }
}