package net.undef.hsr_craft.networking;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import net.undef.hsr_craft.HSRcraft;
import net.undef.hsr_craft.networking.packet.PathDataSynchronization;

public class ClientServerCommunications{
    private static SimpleChannel INSTANCE;

    private static int packetID = 0;

    //Creates the channel that communicates between server and client
    public static void register(){
        SimpleChannel simpleChannel = NetworkRegistry.ChannelBuilder.named(new ResourceLocation(HSRcraft.MOD_ID, "communication")).networkProtocolVersion(() -> "1.0").clientAcceptedVersions(s -> true).serverAcceptedVersions(s -> true).simpleChannel();
        INSTANCE = simpleChannel;

        simpleChannel.messageBuilder(PathDataSynchronization.class, id(), NetworkDirection.PLAY_TO_CLIENT).decoder(PathDataSynchronization::new).encoder(PathDataSynchronization::toBytes).consumerMainThread(PathDataSynchronization::handle).add();
    }

    //Sends a message/data to the server
    public static <MSG> void sendToServer(MSG msg){
        INSTANCE.sendToServer(msg);
    }

    //Sends a message/data to the player
    public static <MSG> void sendToClient(MSG msg, ServerPlayer player){
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), msg);
    }

    //gets the next packet ID
    private static int id(){
        return packetID++;
    }


}
