package net.undef.hsr_craft.networking;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import net.undef.hsr_craft.HSRcraft;
import net.undef.hsr_craft.networking.packet.S2CPathDataSynchronization;

public class ClientServerCommunications{

    private static final SimpleChannel INSTANCE = NetworkRegistry.ChannelBuilder.named(new ResourceLocation(HSRcraft.MOD_ID, "hsrcraft_main"))
            .networkProtocolVersion(() -> "1.0")
            .clientAcceptedVersions(s -> true)
            .serverAcceptedVersions(s -> true)
            .simpleChannel();

    private static int packetID = 0;

    //Creates the channel that communicates between server and client
    public static void register(){

        INSTANCE.messageBuilder(S2CPathDataSynchronization.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .encoder(S2CPathDataSynchronization::encode)
                .decoder(S2CPathDataSynchronization::new)
                .consumerMainThread(S2CPathDataSynchronization::handle)
                .add();
    }

    //Sends a message/data to the server
    public static <MSG> void sendToServer(MSG msg){
        INSTANCE.sendToServer(msg);
    }

    //Sends a message/data to the player
    public static <MSG> void sendToClient(MSG msg, ServerPlayer player){
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), msg);
    }

    //Sends a message/data to all players
    public static <MSG> void sendToAllClients(MSG msg){
        INSTANCE.send(PacketDistributor.ALL.noArg(), msg);
    }

    //gets the next packet ID
    private static int id(){
        return packetID++;
    }


}
