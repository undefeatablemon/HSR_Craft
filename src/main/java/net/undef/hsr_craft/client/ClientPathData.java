package net.undef.hsr_craft.client;

public class ClientPathData{

    //This class is created solely on the client's side
    //Whenever trying to read a client's path data for menus, take it from here

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
