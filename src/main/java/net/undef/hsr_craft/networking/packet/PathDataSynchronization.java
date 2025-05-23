package net.undef.hsr_craft.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import net.undef.hsr_craft.client.ClientPathData;

import java.util.function.Supplier;

public class PathDataSynchronization{

    private final String path;
    private final String character;

    public PathDataSynchronization(String path, String character){
        this.path = path;
        this.character = character;
    }

    public PathDataSynchronization(FriendlyByteBuf path, FriendlyByteBuf character){
        this.path = path.readUtf();
        this.character = character.readUtf();
    }

    public void toBytes(FriendlyByteBuf path, FriendlyByteBuf character){
        path.writeUtf(this.path);
        character.writeUtf(this.character);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() ->{
            //To client
            ClientPathData.setPlayerPath(this.path);
            ClientPathData.setPlayerCharacter(this.character);
        });
        return true;
    }
}
