package net.undef.hsr_craft.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.undef.hsr_craft.HSRcraft;
import net.undef.hsr_craft.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, HSRcraft.MOD_ID, existingFileHelper);
    }

    //Creates json files for item models
    @Override
    protected void registerModels() {

    }

    //Method to make json files for 2d item models
    private ItemModelBuilder twoDimensionalItem(RegistryObject<Item> item){

        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(HSRcraft.MOD_ID, "item/" + item.getId().getPath()));
    }
}
