package net.undef.hsr_craft.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder{

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    //Creates json files for recipes
    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

    }

    //Need to add methods from RecipeProvider class such as smelting, based on recipes needed
}
