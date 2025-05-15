package net.undef.hsr_craft.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.undef.hsr_craft.block.ModBlocks;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider{

    protected ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        //Makes the path emergence block drop itself when mined
        this.dropSelf(ModBlocks.PATHEMERGENCE_BLOCK.get());
    }

    //Takes every block in the deferrred registry and adds it to the loot table json
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
