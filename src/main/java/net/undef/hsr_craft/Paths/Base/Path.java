package net.undef.hsr_craft.Paths.Base;

import net.minecraftforge.eventbus.api.Event;
import net.undef.hsr_craft.player.PathStrider;

public abstract class Path {

    public abstract void activateStaticBuffs(PathStrider pathStrider);

    public abstract void deactivateStaticBuffs(PathStrider pathStrider);

    public abstract void onEvent(PathStrider pathStrider, Event event);
}
