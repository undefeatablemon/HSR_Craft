package net.undef.hsr_craft.tags;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.undef.hsr_craft.HSRcraft;

public class ModTags {

    public static class Blocks{

        //Example block tag
        //public static final TagKey<Block> EXAMPLE_TAG = tag("example");

        //Creates a custom tag for blocks. The parameter "name" refers to the json file associated with the tag.
        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(HSRcraft.MOD_ID, name));
        }
    }

    public static class Items{

        //Creates a custom tag for items. The parameter "name" refers to the json file associated with the tag.
        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(HSRcraft.MOD_ID, name));
        }
    }
}
