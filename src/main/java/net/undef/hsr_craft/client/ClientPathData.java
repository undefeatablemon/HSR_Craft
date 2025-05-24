package net.undef.hsr_craft.client;

public class ClientPathData{

    private static String playerPath;
    private static int playerPathLevel;
    private static String playerCharacter;

    public static void setPlayerPath(String path){
        ClientPathData.playerPath = path;
    }

    public static void setPlayerPathLevel(int pathLevel){
        ClientPathData.playerPathLevel = pathLevel;
    }

    public static void setPlayerCharacter(String character){
        ClientPathData.playerCharacter = character;
    }

    public static String getPlayerPath(){
        return playerPath;
    }

    public static int getPlayerPathLevel(){
        return playerPathLevel;
    }

    public static String getPlayerCharacter(){
        return playerCharacter;
    }
}
