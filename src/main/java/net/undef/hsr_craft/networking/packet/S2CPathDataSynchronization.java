package net.undef.hsr_craft.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import net.undef.hsr_craft.client.ClientPathData;

import java.util.function.Supplier;

public class S2CPathDataSynchronization {

    private final String path;
    private final byte pathLevel;
    private final String character;

    public S2CPathDataSynchronization(String path, byte pathLevel, String character){

        this.path = path;
        this.pathLevel = pathLevel;
        this.character = character;
    }

    public S2CPathDataSynchronization(FriendlyByteBuf data){
        this(data.readUtf(), data.readByte(), data.readUtf());
    }

    public void encode(FriendlyByteBuf data){
        data.writeUtf(this.path);
        data.writeByte(this.pathLevel);
        data.writeUtf(this.character);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() ->{
            //Everything here is client side
            //This allows us to create a ClientPathData class for each client
            ClientPathData.setPlayerPath(this.path);
            ClientPathData.setPlayerPathLevel(this.pathLevel);
            ClientPathData.setPlayerCharacter(this.character);
        });
        return true;
    }
}
