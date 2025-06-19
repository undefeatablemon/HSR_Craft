package net.undef.hsr_craft.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.undef.hsr_craft.player.PathStrider;
import net.undef.hsr_craft.player.PathStriderProvider;

import java.util.Arrays;
import java.util.Objects;

public class SetPathCommand{

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher){

        dispatcher.register(Commands.literal("setPath")
                .requires(commandSourceStack -> commandSourceStack.hasPermission(3))
                .then(Commands.argument("Path", StringArgumentType.string())
                .then(Commands.argument("Level", IntegerArgumentType.integer(0, 14))
                .then(Commands.argument("Target", EntityArgument.player())
                .executes(SetPathCommand::setPath)

        ))));
    }

    private static int setPath(CommandContext<CommandSourceStack> commandSourceStackCommandContext) throws CommandSyntaxException{

        Player player = EntityArgument.getPlayer(commandSourceStackCommandContext, "Target");

        player.getCapability(PathStriderProvider.PATH_STRIDER).ifPresent(pathStrider -> {
            if(Arrays.asList(PathStrider.validPaths).contains(StringArgumentType.getString(commandSourceStackCommandContext, "Path"))) {

                pathStrider.removePathPassive(player);
                pathStrider.setPath(StringArgumentType.getString(commandSourceStackCommandContext, "Path"));

                if(!StringArgumentType.getString(commandSourceStackCommandContext, "Path").equals("none")) {
                    pathStrider.setPathLevel(IntegerArgumentType.getInteger(commandSourceStackCommandContext, "Level"));
                }

                pathStrider.pathPassive(player);
            }
            else{
                player.sendSystemMessage(Component.literal("Invalid Path"));
            }
        });
        return 1;
    }
}
