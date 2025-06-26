package net.undef.hsr_craft.player;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;

public class PathStrider{

    public static final String[] validPaths = {"none", "destruction", "hunt", "erudition", "harmony",
                                        "nihility", "preservation", "abundance", "remembrance", "trailblaze",
                                        "elation", "voracity", "beauty", "permanence", "propagation",
                                        "enigmata", "equilibrium", "finality"};
    public static final String[] validCharacters = {"none"};

    private Player player;
    private String path = "none";
    private int pathLevel = 0;
    private String character = "none";

    public PathStrider(){
        //Empty for now
    }

    public void setPlayer(Player player){
        this.player = player;
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

    public Player getPlayer(){
        return this.player;
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

    public void copyFrom(PathStrider pathStrider, Player newPlayer){
        this.setPath(pathStrider.getPath());
        this.setPathLevel(pathStrider.getPathLevel());
        this.setCharacter(pathStrider.getCharacter());
        this.setPlayer(player);
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

    //Change path
    public void changePath(String newPath){
        this.deactivatePathPassive();
        this.setPath(newPath);
        this.activatePathPassive();
    }

    //Change level
    public void changePathLevel(int newLevel){
        this.deactivatePathPassive();
        this.setPathLevel(newLevel);
        this.activatePathPassive();
    }

    //Reloads passive path buffs
    public void reloadPathPassive(){
        this.deactivatePathPassive();
        this.activatePathPassive();
    }

    //Gives the player any passive stat boosts associated with their path
    public void activatePathPassive(){
        switch (getPath()){
            case "destruction":
                //Destruction code
                break;

            case "hunt":
                //Hunt code
                break;

            case "erudition":
                //Erudition code
                break;

            case "harmony":
                //Harmony code
                break;

            case "nihility":
                //Nihility code
                break;

            case "preservation":
                //Preservation code
                break;

            case "abundance":
                //Abundance code
                this.player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(this.player.getAttribute(Attributes.MAX_HEALTH).getValue() + 10); //temp
                this.player.heal(10); //temp
                break;

            case "remembrance":
                //Remembrance code
                break;

            case "trailblaze":
                //Trailblaze code
                break;

            case "elation":
                //Elation code
                break;

            case "voracity":
                //Voracity code
                break;

            case "beauty":
                //Beauty code
                break;

            case "permanence":
                //Permanence code
                break;

            case "propagation":
                //Propagation code
                break;

            case "enigmata":
                //Enigmata code
                break;

            case "equilibrium":
                //Equilibrium code
                break;

            case "finality":
                //Finality code
                break;
        }
    }

    public void deactivatePathPassive(){
        switch (getPath()){
            case "destruction":
                //Destruction code
                break;

            case "hunt":
                //Hunt code
                break;

            case "erudition":
                //Erudition code
                break;

            case "harmony":
                //Harmony code
                break;

            case "nihility":
                //Nihility code
                break;

            case "preservation":
                //Preservation code
                break;

            case "abundance":
                //Abundance code
                this.player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(this.player.getAttribute(Attributes.MAX_HEALTH).getValue() - 10); //temp
                this.player.setHealth(this.player.getHealth() - 10); //temp
                break;

            case "remembrance":
                //Remembrance code
                break;

            case "trailblaze":
                //Trailblaze code
                break;

            case "elation":
                //Elation code
                break;

            case "voracity":
                //Voracity code
                break;

            case "beauty":
                //Beauty code
                break;

            case "permanence":
                //Permanence code
                break;

            case "propagation":
                //Propagation code
                break;

            case "enigmata":
                //Enigmata code
                break;

            case "equilibrium":
                //Equilibrium code
                break;

            case "finality":
                //Finality code
                break;
        }
    }
}
