package net.undef.hsr_craft.player;

import net.minecraft.core.UUIDUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.entity.player.Player;
import net.undef.hsr_craft.Paths.*;
import net.undef.hsr_craft.Paths.Base.None;
import net.undef.hsr_craft.Paths.Base.Path;

import java.util.ArrayList;
import java.util.UUID;

public class PathStrider {

//Path----------------------------------------------------------------------------------------------------------

    //Used for setPath command. Might move to different capability
    public static final String[] VALID_PATHS = {"none", "destruction", "hunt", "erudition", "harmony",
            "nihility", "preservation", "abundance", "remembrance", "trailblaze",
            "elation", "voracity", "beauty", "permanence", "propagation",
            "enigmata", "equilibrium", "finality"};

    //Player data
    private Path pathObject; //Can't be saved in nbts
    private String path = "none";
    private int pathLevel = 0;

    public void setPathObject() {
        switch (this.getPath()) {
            case "none":
                this.pathObject = new None();
                break;
            case "destruction":
                this.pathObject = new Destruction();
                break;

            case "hunt":
                this.pathObject = new Hunt();
                break;

            case "erudition":
                this.pathObject = new Erudition();
                break;

            case "harmony":
                this.pathObject = new Harmony();
                break;

            case "nihility":
                this.pathObject = new Nihility();
                break;

            case "preservation":
                this.pathObject = new Preservation();
                break;

            case "abundance":
                this.pathObject = new Abundance();
                break;

            case "remembrance":
                this.pathObject = new Remembrance();
                break;

            case "trailblaze":
                this.pathObject = new Trailblaze();
                break;

            case "elation":
                this.pathObject = new Elation();
                break;

            case "voracity":
                this.pathObject = new Voracity();
                break;

            case "beauty":
                this.pathObject = new Beauty();
                break;

            case "permanence":
                this.pathObject = new Permanence();
                break;

            case "propagation":
                this.pathObject = new Propagation();
                break;

            case "enigmata":
                this.pathObject = new Enigmata();
                break;

            case "equilibrium":
                this.pathObject = new Equilibrium();
                break;

            case "finality":
                this.pathObject = new Finality();
                break;
        }
    }

    public void setPath(String path) {
        this.path = path;
        this.setPathObject();
    }

    public void setPathLevel(int pathLevel) {
        this.pathLevel = pathLevel;
    }

    public Path getPathObject() {
        return this.pathObject;
    }

    public String getPath() {
        return this.path;
    }

    public int getPathLevel() {
        return this.pathLevel;
    }

    public void changePath(String newPath) {
        this.deactivatePathPassive();
        this.setPath(newPath);
        this.activatePathPassive();
    }

    public void changePathLevel(int newLevel) {
        this.deactivatePathPassive();
        this.setPathLevel(newLevel);
        this.activatePathPassive();
    }

    public void reloadPathPassive() {
        this.deactivatePathPassive();
        this.activatePathPassive();
    }

    public void activatePathPassive() {
        this.getPathObject().activateStaticBuffs(this);
    }

    public void deactivatePathPassive() {
        this.getPathObject().deactivateStaticBuffs(this);
    }

//Character-----------------------------------------------------------------------------------------------------

    //Used for setCharacter command. Might move to different capability
    public static final String[] VALID_CHARACTERS = {"none"};

    //Player Data
    private String character = "none";

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getCharacter() {
        return this.character;
    }

//Data Logistics------------------------------------------------------------------------------------------------

    private Player player; //Can't be saved in nbts

    //Locations of the modifiers put on the player
    private ListTag modifier_UUIDs = new ListTag();
    //private ArrayList<UUID> player_modifiers = new ArrayList<UUID>(); //Can't be saved in nbts
    //private String UUID_list_as_string = "";

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setModifier_UUIDs(ListTag modifier_UUIDs){
        this.modifier_UUIDs = modifier_UUIDs;
    }

    public ListTag getModifier_UUIDs(){
        return this.modifier_UUIDs;
    }

    public void copyFrom(PathStrider pathStrider) {
        this.setPath(pathStrider.getPath());
        this.setPathLevel(pathStrider.getPathLevel());
        this.setCharacter(pathStrider.getCharacter());
        this.setModifier_UUIDs(pathStrider.getModifier_UUIDs());
        //this.setStringUUID(pathStrider.getStringUUID());
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putString("path", this.getPath());
        nbt.putInt("path_level", this.getPathLevel());
        nbt.putString("character", this.getCharacter());
        nbt.put("modifiers", this.getModifier_UUIDs());
        //nbt.putString("uuids", this.getStringUUID());
    }

    public void loadNBTData(CompoundTag nbt) {
        this.setPath(nbt.getString("path"));
        this.setPathLevel(nbt.getInt("path_level"));
        this.setCharacter(nbt.getString("character"));
        this.setModifier_UUIDs((ListTag) nbt.get("modifiers"));
        //this.setStringUUID(nbt.getString("uuids"));
    }

    public void addModifier(UUID uuid){
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putUUID("uuid", uuid);
        this.modifier_UUIDs.add(compoundTag);
    }

    public void removeModifier(int uuid){
        this.modifier_UUIDs.remove(uuid);
    }

    public void removeAllModifiers(){
        this.modifier_UUIDs.removeAll(this.modifier_UUIDs);
    }

    /*public ArrayList<UUID> getListUUID() {
        return player_modifiers;
    }

    public String getStringUUID() {
        return this.UUID_list_as_string;
    }

    public void addUUID(UUID uuid) {
        this.player_modifiers.add(uuid);
        this.UUID_list_as_string = this.UUID_list_as_string + " " + uuid.toString();
        this.UUID_list_as_string = this.UUID_list_as_string.strip();
    }

    public void removeUUID(UUID uuid) {
        boolean contained = false;

        while (this.player_modifiers.remove(uuid)) { //Remove() removes the UUID from the list and returns true if successful
            contained = true;
        }

        if (contained) {
            String[] temp = this.UUID_list_as_string.split(" ");
            this.UUID_list_as_string = "";
            for (int i = 0; i < temp.length; i++) {
                if (!temp[i].equals(uuid.toString())) {
                    this.UUID_list_as_string = this.UUID_list_as_string + " " + temp[i];
                }
            }
        }
        this.UUID_list_as_string = this.UUID_list_as_string.strip();
    }

    //Used for copying the UUID list (in string form) when a player is cloned
    private void setStringUUID(String uuid) {
        this.UUID_list_as_string = uuid;
        this.generateListWithString();
    }

    private void setListUUID(ArrayList<UUID> uuidList) {
        this.player_modifiers = uuidList;
        this.generateStringWithList();
    }

    public void generateListWithString() {
        this.player_modifiers = new ArrayList<UUID>();
        String[] temp = this.UUID_list_as_string.split(" ");
        for (int i = 1; i < temp.length; i++) {
            this.player_modifiers.add(UUID.fromString(temp[i]));
        }

    }

    public void generateStringWithList() {
        this.UUID_list_as_string = "";
        for (int i = 1; i < this.player_modifiers.size(); i++) {
            this.UUID_list_as_string = this.UUID_list_as_string + " " + this.player_modifiers.get(i).toString();
        }
        this.UUID_list_as_string = this.UUID_list_as_string.strip();
    }*/
}
