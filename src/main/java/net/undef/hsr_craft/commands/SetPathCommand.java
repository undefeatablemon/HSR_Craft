package net.undef.hsr_craft.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.undef.hsr_craft.player.PathStrider;
import net.undef.hsr_craft.player.PathStriderProvider;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class SetPathCommand{

    private static final SimpleCommandExceptionType ERROR_INVALID_PATH = new SimpleCommandExceptionType(Component.literal("Invalid Path"));

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher){

        dispatcher.register(Commands.literal("setPath")
                .requires(commandSourceStack -> commandSourceStack.hasPermission(3))
                .then(Commands.argument("Path", StringArgumentType.string())
                .then(Commands.argument("Level", IntegerArgumentType.integer(0, 10))
                .then(Commands.argument("Target", EntityArgument.player())
                .executes(SetPathCommand::setPath)

        ))));
    }

    private static int setPath(CommandContext<CommandSourceStack> commandSourceStackCommandContext) throws CommandSyntaxException{

        Player player = EntityArgument.getPlayer(commandSourceStackCommandContext, "Target");
        AtomicReference<PathStrider> pathstrider = new AtomicReference<>();
        player.getCapability(PathStriderProvider.PATH_STRIDER).ifPresent(pathstrider::set);

        if(Arrays.asList(PathStrider.VALID_PATHS).contains(StringArgumentType.getString(commandSourceStackCommandContext, "Path"))) {

            pathstrider.get().changePath(StringArgumentType.getString(commandSourceStackCommandContext, "Path"));

            if(!StringArgumentType.getString(commandSourceStackCommandContext, "Path").equals("none")) {
                pathstrider.get().changePathLevel(IntegerArgumentType.getInteger(commandSourceStackCommandContext, "Level"));
            }

            return 1;
        }
        else{
            throw ERROR_INVALID_PATH.create();
        }
    }
}
