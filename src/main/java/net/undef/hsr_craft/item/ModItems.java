package net.undef.hsr_craft.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.undef.hsr_craft.HSRcraft;

public class ModItems {

    //Creates the registry which contains all items added by the mod
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HSRcraft.MOD_ID);

    //Trailblazer's Bat
    public static final RegistryObject<Item> TRAILBLAZERBAT = ITEMS.register("trailblazer_bat", () -> new Item(new Item.Properties()));

    //Sparkle's Hammer
    public static final RegistryObject<Item> SPARKLEHAMMER = ITEMS.register("sparkle_hammer", () -> new Item(new Item.Properties()));


    //Function to register a new item to mc. This does not add it to the creative menu
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
