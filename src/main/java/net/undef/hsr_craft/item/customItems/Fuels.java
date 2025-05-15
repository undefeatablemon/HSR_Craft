package net.undef.hsr_craft.item.customItems;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

import javax.annotation.Nullable;
import java.util.Properties;

public class Fuels extends Item {
    private int burnTime = 0;

    public Fuels(Properties pProperties, int burnTime){
        super(pProperties);
        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(ItemStack item, @Nullable RecipeType<?> recipeType){
        return this.burnTime;
    }
}
