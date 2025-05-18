package net.undef.hsr_craft.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
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

    //Method to make json files for blocks based on existing blocks (ex. stairs, slabs, pressure plates, fence gates, etc.)
    public void derivedBlock(RegistryObject<Block> block){
        this.withExistingParent(HSRcraft.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    //Method to make json files for multi-block models (ex. doors)
    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item){
        return withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated")).texture("layer0", new ResourceLocation(HSRcraft.MOD_ID, "item/" + item.getId().getPath()));
    }

    //Method to make json files for fence models using an existing regular block (ex. planks)
    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory")).texture("texture", new ResourceLocation(HSRcraft.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get())).getPath());
        }

    //Method to make json files for button models using an existing regular block (ex. planks)
    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory")).texture("texture", new ResourceLocation(HSRcraft.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get())).getPath());
    }

    //Method to make json files for wall models using an existing regular block (ex. cobblestone)
    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory")).texture("wall", new ResourceLocation(HSRcraft.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get())).getPath());
    }
}
