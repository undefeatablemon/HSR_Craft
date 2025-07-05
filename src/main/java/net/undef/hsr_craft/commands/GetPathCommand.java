package net.undef.hsr_craft.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.undef.hsr_craft.player.PathStriderProvider;

public class GetPathCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher){

        dispatcher.register(Commands.literal("getPathData")
                .requires(commandSourceStack -> commandSourceStack.hasPermission(0))
                        .executes(GetPathCommand::printClientData)
        );
    }

    private static int printClientData(CommandContext<CommandSourceStack> commandSourceStackCommandContext){

        Player player = (Player)commandSourceStackCommandContext.getSource().getPlayer();
        player.getCapability(PathStriderProvider.PATH_STRIDER).ifPresent(pathStrider -> {
            player.sendSystemMessage(Component.literal("Path: " + pathStrider.getPath() + "\nLevel: " + pathStrider.getPathLevel()));
        });
        return 1;
    }
}
