package net.undef.hsr_craft.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.undef.hsr_craft.HSRcraft;
import net.undef.hsr_craft.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, HSRcraft.MOD_ID, existingFileHelper);
    }

    //Creates json files for block tags
    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        //All blocks needing a diamond tool to be mined are added here.
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(
                        ModBlocks.PATHEMERGENCE_BLOCK.get()
                );

        //All blocks needing a pickaxe to be mined are added here
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        ModBlocks.PATHEMERGENCE_BLOCK.get()
                );
    }
}
