package net.undef.hsr_craft.client;

public class ClientPathData{

    private static String playerPath;
    private static String playerCharacter;

    public static void setPlayerPath(String path){
        ClientPathData.playerPath = path;
    }

    public static void setPlayerCharacter(String character){
        ClientPathData.playerCharacter = character;
    }

    public static String getPlayerPath(){
        return playerPath;
    }

    public static String getPlayerCharacter(){
        return playerCharacter;
    }
}
