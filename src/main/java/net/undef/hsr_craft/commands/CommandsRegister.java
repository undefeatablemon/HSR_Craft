package net.undef.hsr_craft.commands;

import net.minecraftforge.client.event.RegisterClientCommandsEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class CommandsRegister{

    //This class contains the command registry

    //Command Permission levels: 0 = All, 1 = Moderators, 2 = Gamemasters, 3 = Admins, 4 = Owner
    //These permissions are designated inside the command classes

    @SubscribeEvent
    public static void registerServerCommands(RegisterCommandsEvent event){ //Can be called on console

        SetPathCommand.register(event.getDispatcher()); //Registers the setPath command
        GetPathCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void registerClientCommands(RegisterClientCommandsEvent event){ //Cannot be called on console

    }
}
