package net.undef.hsr_craft.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import net.undef.hsr_craft.client.ClientPathData;

import java.util.function.Supplier;

public class PathDataSynchronization{

    private final String path;
    private final int pathLevel;
    private final String character;

    public PathDataSynchronization(String data){
        String[] array = data.split(" ");


        this.path = array[0];
        this.pathLevel = Integer.parseInt(array[1]);
        this.character = array[2];
    }

    public PathDataSynchronization(FriendlyByteBuf data){
        String[] array = data.readUtf().split(" ");


        this.path = array[0];
        this.pathLevel = Integer.parseInt(array[1]);
        this.character = array[2];
    }

    public void toBytes(FriendlyByteBuf data){
        data.writeUtf(this.path + " " + this.pathLevel + " " + this.character);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() ->{
            //To client
            ClientPathData.setPlayerPath(this.path);
            ClientPathData.setPlayerPathLevel(this.pathLevel);
            ClientPathData.setPlayerCharacter(this.character);
        });
        return true;
    }
}
