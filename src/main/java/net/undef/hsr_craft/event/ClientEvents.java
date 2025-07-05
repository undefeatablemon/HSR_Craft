package net.undef.hsr_craft.event;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.undef.hsr_craft.HSRcraft;
import net.undef.hsr_craft.client.KeyBindings;
import net.undef.hsr_craft.networking.ClientServerCommunications;
import net.undef.hsr_craft.networking.packet.*;
import net.undef.hsr_craft.player.PathStriderProvider;

public class ClientEvents {

    @Mod.EventBusSubscriber(modid = HSRcraft.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents{

        //Called when a keybind is pressed
        @SubscribeEvent
        public static void onKeyPressed(InputEvent.Key event){

            if(KeyBindings.BASIC_ATTACK_KEY.consumeClick()) { //consumeClick is tap, there are other methods (ex. holding down key)
                ClientServerCommunications.sendToServer(new C2SPlayerBasicAttack());
            }
            else if(KeyBindings.PATH_SKILL_KEY.consumeClick()) { //consumeClick is tap, there are other methods (ex. holding down key)
                ClientServerCommunications.sendToServer(new C2SPlayerPathSkill());
            }
            else if(KeyBindings.SKILL_KEY.consumeClick()) { //consumeClick is tap, there are other methods (ex. holding down key)
                ClientServerCommunications.sendToServer(new C2SPlayerSkill());
            }
            else if(KeyBindings.TECHNIQUE_KEY.consumeClick()) { //consumeClick is tap, there are other methods (ex. holding down key)
                ClientServerCommunications.sendToServer(new C2SPlayerTechnique());
            }
            else if(KeyBindings.ULTIMATE_KEY.consumeClick()) { //consumeClick is tap, there are other methods (ex. holding down key)
                ClientServerCommunications.sendToServer(new C2SPlayerUltimate());
            }
        }


        @SubscribeEvent
        public static void playerTick(TickEvent.PlayerTickEvent event) {
            if(event.side == LogicalSide.SERVER) {

            }
        }
    }
}
