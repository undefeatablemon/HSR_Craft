package net.undef.hsr_craft.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {

    //HSR Combat
    public static final KeyMapping BASIC_ATTACK_KEY = new KeyMapping("key.hsr_craft.basic_attack", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_Q, "key.category.hsr_craft.hsr_combat");
    public static final KeyMapping PATH_SKILL_KEY = new KeyMapping("key.hsr_craft.path_skill", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_R, "key.category.hsr_craft.hsr_combat");
    public static final KeyMapping SKILL_KEY = new KeyMapping("key.hsr_craft.skill", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_E, "key.category.hsr_craft.hsr_combat");
    public static final KeyMapping TECHNIQUE_KEY = new KeyMapping("key.hsr_craft.technique", KeyConflictContext.IN_GAME, KeyModifier.ALT,InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_E, "key.category.hsr_craft.hsr_combat");
    public static final KeyMapping ULTIMATE_KEY = new KeyMapping("key.hsr_craft.ultimate", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_1, "key.category.hsr_craft.hsr_combat");
}