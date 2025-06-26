package net.undef.hsr_craft.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class C2SPlayerBasicAttack {

    public C2SPlayerBasicAttack(){

    }

    public C2SPlayerBasicAttack(FriendlyByteBuf buf){

    }

    public void encode(FriendlyByteBuf buf){

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context = supplier.get();
        ServerPlayer player = context.getSender();
        context.enqueueWork(() -> {
            //This code runs in the server
            player.sendSystemMessage(Component.literal("Basic Attack is WIP"));
        });
        return true;
    }
}
