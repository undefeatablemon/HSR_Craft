package net.undef.hsr_craft.player;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;

public class PathStrider{

    String path = "None";
    String character = "None";

    public PathStrider() {
        //this.player.sendSystemMessage(Component.literal("Succesfully became the path strider of abundance"));
        //this.player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(30); //temp
    }

    public void setPath(String path){
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }

    public void setCharacter(String character){
        this.character = character;
    }

    public String getCharacter(){
        return this.character;
    }

    public void copyFrom(PathStrider pathStrider){
        setPath(pathStrider.getPath());
        setCharacter(pathStrider.getCharacter());
    }

    public void saveNBTData(CompoundTag nbt){
        nbt.putString("path", getPath());
        nbt.putString("character", getCharacter());
    }

    public void loadNBTData(CompoundTag nbt){
        setPath(nbt.getString("path"));
        setCharacter(nbt.getString("character"));
    }

    public void testMethod(Player player){
        if(getPath() == "abundance") {
            player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(30); //temp
        }
    }
}
