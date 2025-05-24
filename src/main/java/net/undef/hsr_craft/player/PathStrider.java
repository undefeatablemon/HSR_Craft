package net.undef.hsr_craft.player;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;

public class PathStrider{

    String path = "None";
    int pathLevel = 0;
    String character = "None";

    public PathStrider() {
        //this.player.sendSystemMessage(Component.literal("Succesfully became the path strider of abundance"));
        //this.player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(30); //temp
    }

    public void setPath(String path){
        this.path = path;
    }

    public void setPathLevel(int pathLevel){
        this.pathLevel = pathLevel;
    }

    public void setCharacter(String character){
        this.character = character;
    }

    public String getPath(){
        return this.path;
    }

    public int getPathLevel() {
        return this.pathLevel;
    }

    public String getCharacter(){
        return this.character;
    }

    public String getData(){
        return this.path + " " + Integer.toString(this.pathLevel) + " " + this.character;
    }

    public void copyFrom(PathStrider pathStrider){
        setPath(pathStrider.getPath());
        setPathLevel(pathStrider.getPathLevel());
        setCharacter(pathStrider.getCharacter());
    }

    public void saveNBTData(CompoundTag nbt){
        nbt.putString("path", getPath());
        nbt.putInt("path_level", getPathLevel());
        nbt.putString("character", getCharacter());
    }

    public void loadNBTData(CompoundTag nbt){
        setPath(nbt.getString("path"));
        setPathLevel(nbt.getInt("path_level"));
        setCharacter(nbt.getString("character"));
    }

    public void testMethod(Player player){
        if(getPath().equals("abundance")) {
            player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(30); //temp
        }
    }
}
