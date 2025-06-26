package net.undef.hsr_craft.event;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
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

                event.getObject().getCapability(PathStriderProvider.PATH_STRIDER).ifPresent(pathStrider -> {
                    pathStrider.setPlayer((Player)event.getObject());
                });
            }
        }
    }

    //Runs when a player is cloned (respawn or entering new dimension)
    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event){
        event.getOriginal().reviveCaps();
        event.getOriginal().getCapability(PathStriderProvider.PATH_STRIDER).ifPresent(oldStore -> {
            event.getEntity().getCapability(PathStriderProvider.PATH_STRIDER).ifPresent(newStore -> {

                //Restores previous capability and passive stat buffs
                newStore.copyFrom(oldStore, event.getEntity());
                newStore.activatePathPassive();
            });
        });
        event.getOriginal().invalidateCaps();
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event){
        event.register(PathStrider.class);
    }

    //Runs on the player every tick
    /*@SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event){
        if(event.side == LogicalSide.SERVER){
            event.player.getCapability(PathStriderProvider.PATH_STRIDER).ifPresent(pathStrider -> {
                if(event.player.getRandom().nextFloat() < 0.005f){   //On average every 10s
                    //enter code here
                }
            });
        }
    }*/

    //Runs when a player joins the world. Unsure if needed
    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinLevelEvent event){
        if(!event.getLevel().isClientSide){
            if(event.getEntity() instanceof ServerPlayer player){
                player.getCapability(PathStriderProvider.PATH_STRIDER).ifPresent(pathStrider -> {
                    pathStrider.setPlayer((Player) event.getEntity());
                });
            }
        }
    }
}
