package net.undef.hsr_craft.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.undef.hsr_craft.client.ClientPathData;

public class ClientPathDataTestCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher){

        dispatcher.register(Commands.literal("getClientPathData")
                .requires(commandSourceStack -> commandSourceStack.hasPermission(0))
                        .executes(ClientPathDataTestCommand::printClientData)
        );
    }

    private static int printClientData(CommandContext<CommandSourceStack> commandSourceStackCommandContext){

        Player player = (Player)commandSourceStackCommandContext.getSource().getPlayer();
        player.sendSystemMessage(Component.literal(ClientPathData.getPlayerPath() + " " + ClientPathData.getPlayerPathLevel()));
        return 1;
    }
}
