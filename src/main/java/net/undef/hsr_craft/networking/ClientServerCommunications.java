package net.undef.hsr_craft.networking;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import net.undef.hsr_craft.HSRcraft;
import net.undef.hsr_craft.networking.packet.*;

public class ClientServerCommunications{

    private static final SimpleChannel INSTANCE = NetworkRegistry.ChannelBuilder.named(new ResourceLocation(HSRcraft.MOD_ID, "hsrcraft_main"))
            .networkProtocolVersion(() -> "1.0")
            .clientAcceptedVersions(s -> true)
            .serverAcceptedVersions(s -> true)
            .simpleChannel();

    private static int packetID = 0;

    //Creates the channel that communicates between server and client
    public static void register(){

        INSTANCE.messageBuilder(C2SPlayerBasicAttack.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .encoder(C2SPlayerBasicAttack::encode)
                .decoder(C2SPlayerBasicAttack::new)
                .consumerMainThread(C2SPlayerBasicAttack::handle)
                .add();

        INSTANCE.messageBuilder(C2SPlayerPathSkill.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .encoder(C2SPlayerPathSkill::encode)
                .decoder(C2SPlayerPathSkill::new)
                .consumerMainThread(C2SPlayerPathSkill::handle)
                .add();

        INSTANCE.messageBuilder(C2SPlayerSkill.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .encoder(C2SPlayerSkill::encode)
                .decoder(C2SPlayerSkill::new)
                .consumerMainThread(C2SPlayerSkill::handle)
                .add();

        INSTANCE.messageBuilder(C2SPlayerTechnique.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .encoder(C2SPlayerTechnique::encode)
                .decoder(C2SPlayerTechnique::new)
                .consumerMainThread(C2SPlayerTechnique::handle)
                .add();

        INSTANCE.messageBuilder(C2SPlayerUltimate.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .encoder(C2SPlayerUltimate::encode)
                .decoder(C2SPlayerUltimate::new)
                .consumerMainThread(C2SPlayerUltimate::handle)
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
