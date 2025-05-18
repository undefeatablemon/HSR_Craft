package net.undef.hsr_craft.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.undef.hsr_craft.HSRcraft;
import net.undef.hsr_craft.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, HSRcraft.MOD_ID, exFileHelper);
    }

    //Creates json files for blockstates
    @Override
    protected void registerStatesAndModels() {

        //simpleBlockWithItem(ModBlocks.PATHEMERGENCE_BLOCK.get(), modLoc("block/path_emergence_block"));
    }

    //Method to make json files for a simple blockstate
    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
