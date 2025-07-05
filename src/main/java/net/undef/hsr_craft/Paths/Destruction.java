package net.undef.hsr_craft.Paths;

import net.minecraft.core.UUIDUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.Event;
import net.undef.hsr_craft.Paths.Base.Path;
import net.undef.hsr_craft.player.PathStrider;

import java.util.Objects;
import java.util.UUID;

public class Destruction extends Path {

    @Override
    public void activateStaticBuffs(PathStrider pathStrider) {

        Player player = pathStrider.getPlayer();
        int pathLevel = pathStrider.getPathLevel();

        int add = 0;
        float mult = 0;

        //NOTE: no breaks present. all code past a case will run. (ex. if level is 8, every case at and below 8 will run)
        switch (pathLevel){
            case 10:
                mult = mult + 0.15f;
            case 9:
                mult = mult + 0.10f;
            case 8:
                mult = mult + 0.10f;
            case 7:
                mult = mult + 0.05f;
            case 6:
                mult = mult + 0.05f;
            case 5:
                //Code
            case 4:
                add = add + 2;
            case 3:
                add = add + 2;
            case 2:
                add = add + 1;
            case 1:
                add = add + 1;
        }

        AttributeModifier addition = new AttributeModifier("Destruction lvl1-4", add, AttributeModifier.Operation.ADDITION);
        pathStrider.addModifier(addition.getId());
        Objects.requireNonNull(player.getAttribute(Attributes.ATTACK_DAMAGE)).addPermanentModifier(addition);

        AttributeModifier multiplication = new AttributeModifier("Destruction lv6-10", mult, AttributeModifier.Operation.MULTIPLY_TOTAL);
        pathStrider.addModifier(multiplication.getId());
        player.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(multiplication);
    }

    @Override
    public void deactivateStaticBuffs(PathStrider pathStrider) {

        Player player = pathStrider.getPlayer();
        int pathLevel = pathStrider.getPathLevel();

        Objects.requireNonNull(player.getAttribute(Attributes.ATTACK_DAMAGE)).removePermanentModifier(((CompoundTag) pathStrider.getModifier_UUIDs().get(0)).getUUID("uuid"));
        Objects.requireNonNull(player.getAttribute(Attributes.ATTACK_DAMAGE)).removePermanentModifier(((CompoundTag) pathStrider.getModifier_UUIDs().get(1)).getUUID("uuid"));

        pathStrider.removeModifier(0);
        pathStrider.removeModifier(0);
    }

    @Override
    public void onEvent(PathStrider pathStrider, Event event) {

        Player player = pathStrider.getPlayer();
        int pathLevel = pathStrider.getPathLevel();

        if(event instanceof LivingHurtEvent){
            LivingHurtEvent livingHurtEvent = (LivingHurtEvent) event;

            float currentHpRatio = player.getHealth()/player.getMaxHealth();
            float damageReduction = ((1 - currentHpRatio) * 0.75f) + 0.05f;

            //Only here for testing reasons
            String msg = "Current Hp Ratio: " + currentHpRatio + "\nDamage Reduction: " + damageReduction;
            player.sendSystemMessage(Component.literal(msg));

            livingHurtEvent.setAmount(livingHurtEvent.getAmount() * (1 - damageReduction));
        }
    }
}
