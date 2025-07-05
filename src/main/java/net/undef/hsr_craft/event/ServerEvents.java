package net.undef.hsr_craft.event;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.undef.hsr_craft.HSRcraft;
import net.undef.hsr_craft.player.PathStrider;
import net.undef.hsr_craft.player.PathStriderProvider;

@Mod.EventBusSubscriber(modid = HSRcraft.MOD_ID)
public class ServerEvents{

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event){
        event.register(PathStrider.class);
    }

    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event){
        if(event.getObject() instanceof Player){
            if(!event.getObject().getCapability(PathStriderProvider.PATH_STRIDER).isPresent()){
                event.addCapability(new ResourceLocation(HSRcraft.MOD_ID, "properties"), new PathStriderProvider());

                event.getObject().getCapability(PathStriderProvider.PATH_STRIDER).ifPresent(pathStrider -> {
                    pathStrider.setPlayer((Player)event.getObject());
                    pathStrider.setPathObject();
                });
            }
        }
    }

    //Runs when a player joins the world. Unsure if needed
    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinLevelEvent event){
        if(!event.getLevel().isClientSide){
            if(event.getEntity() instanceof ServerPlayer player){
                player.getCapability(PathStriderProvider.PATH_STRIDER).ifPresent(pathStrider -> {
                    pathStrider.setPlayer((Player) event.getEntity());
                    pathStrider.setPathObject();

                    //reloads path passive to reset buffs
                    pathStrider.reloadPathPassive();
                });
            }
        }
    }

    //Runs on the player every tick
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event){
        /*if(event.side == LogicalSide.SERVER){
            event.player.getCapability(PathStriderProvider.PATH_STRIDER).ifPresent(pathStrider -> {
                if(event.player.getRandom().nextFloat() < 0.005f){   //On average every 10s
                    //enter code here
                }
            });
        }*/
    }

    //Runs when a player is cloned (respawn or entering new dimension)
    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event){
        event.getOriginal().reviveCaps();
        event.getOriginal().getCapability(PathStriderProvider.PATH_STRIDER).ifPresent(oldStore -> {
            event.getEntity().getCapability(PathStriderProvider.PATH_STRIDER).ifPresent(newStore -> {
                //Restores previous capability
                newStore.copyFrom(oldStore);
            });
        });
        event.getOriginal().invalidateCaps();

        event.getEntity().getCapability(PathStriderProvider.PATH_STRIDER).ifPresent(pathStrider -> {
            //Activates path passive
            pathStrider.setPlayer(event.getEntity()); //See if these can be put inside copyFrom()
            pathStrider.setPathObject();
            pathStrider.activatePathPassive();
        });
    }

    //Called whenever an entity dies. Can be cancelled to prevent death
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onEntityKilled(LivingDeathEvent event) throws InterruptedException {

    }

    //Called whenever a entity is damaged
    @SubscribeEvent
    public static void onDamaged(LivingHurtEvent event){
        event.getEntity().getCapability(PathStriderProvider.PATH_STRIDER).ifPresent(pathStrider -> {
            pathStrider.getPathObject().onEvent(pathStrider, event);
        });
    }
}
