package net.undef.hsr_craft.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.undef.hsr_craft.HSRcraft;
import net.undef.hsr_craft.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    //Creates the registry which contains all blocks added by the mod
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, HSRcraft.MOD_ID);

    //Example block registration. Creates a block with the same behavior as an iron block
    //public static final RegistryObject<Block> EXAMPLE_BLOCK = registerBlock("example_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    //Registers a block in both the block and item deferred registry
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> output = BLOCKS.register(name, block);
        registerBlockItem(name, output);
        return output;
    }

    //Converts a block into an item to be registered in the item deferred registry
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    //Function to register a new block to mc. This does not add it to the creative menu
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
