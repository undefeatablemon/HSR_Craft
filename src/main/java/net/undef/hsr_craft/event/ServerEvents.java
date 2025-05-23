package net.undef.hsr_craft.event;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.undef.hsr_craft.HSRcraft;
import net.undef.hsr_craft.player.PathStrider;
import net.undef.hsr_craft.player.PathStriderProvider;

@Mod.EventBusSubscriber(modid = HSRcraft.MOD_ID)
public class ServerEvents{

    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event){
        if(event.getObject() instanceof Player){
            if(!event.getObject().getCapability(PathStriderProvider.PATH_STRIDER).isPresent()){
                event.addCapability(new ResourceLocation(HSRcraft.MOD_ID, "properties"), new PathStriderProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event){
        if(event.isWasDeath()){
            event.getOriginal().getCapability(PathStriderProvider.PATH_STRIDER).ifPresent(oldStore -> {
                event.getOriginal().getCapability(PathStriderProvider.PATH_STRIDER).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event){
        event.register(PathStrider.class);
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event){
        if(event.side == LogicalSide.SERVER){
            event.player.getCapability(PathStriderProvider.PATH_STRIDER).ifPresent(pathStrider -> {
                if(event.player.getRandom().nextFloat() < 0.005f){   //On average every 10s
                    //event.player.sendSystemMessage(Component.literal("Success?"));
                    pathStrider.setPath("abundance");
                    pathStrider.testMethod(event.player);
                }
            });
        }
    }
}
