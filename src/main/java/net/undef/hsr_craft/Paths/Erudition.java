package net.undef.hsr_craft.Paths;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.Event;
import net.undef.hsr_craft.Paths.Base.Path;
import net.undef.hsr_craft.player.PathStrider;

public class Erudition extends Path {

    @Override
    public void activateStaticBuffs(PathStrider pathStrider) {

        Player player = pathStrider.getPlayer();
        int pathLevel = pathStrider.getPathLevel();

        //NOTE: no breaks present. all code past a case will run. (ex. if level is 8, every case at and below 8 will run)
        switch (pathLevel){
            case 10:
                //Code
            case 9:
                //Code
            case 8:
                //Code
            case 7:
                //Code
            case 6:
                //Code
            case 5:
                //Code
            case 4:
                //Code
            case 3:
                //Code
            case 2:
                //Code
            case 1:
                //Code
        }
    }

    @Override
    public void deactivateStaticBuffs(PathStrider pathStrider) {

        Player player = pathStrider.getPlayer();
        int pathLevel = pathStrider.getPathLevel();

        //NOTE: no breaks present. all code past a case will run. (ex. if level is 8, every case at and below 8 will run)
        switch (pathLevel){
            case 10:
                //Code
            case 9:
                //Code
            case 8:
                //Code
            case 7:
                //Code
            case 6:
                //Code
            case 5:
                //Code
            case 4:
                //Code
            case 3:
                //Code
            case 2:
                //Code
            case 1:
                //Code
        }
    }

    @Override
    public void onEvent(PathStrider pathStrider, Event event) {

        Player player = pathStrider.getPlayer();
        int pathLevel = pathStrider.getPathLevel();

    }
}
