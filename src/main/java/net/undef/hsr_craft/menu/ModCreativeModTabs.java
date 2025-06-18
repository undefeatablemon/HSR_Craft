package net.undef.hsr_craft.menu;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.undef.hsr_craft.HSRcraft;
import net.undef.hsr_craft.block.ModBlocks;
import net.undef.hsr_craft.item.ModItems;

public class ModCreativeModTabs {

    //Creates the registry which contains all creative menu tabs added by the mod
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HSRcraft.MOD_ID);

    //Creates the HSR Combat tab in the creative menu
    public static final RegistryObject<CreativeModeTab> HSRCOMBAT_TAB = CREATIVE_MODE_TABS.register("hsrcombat_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TRAILBLAZERBAT.get())).title(Component.translatable("creativetab.hsrcombat_tab"))
            .displayItems((itemDisplayParameters, output) ->{
                //Add combat items here
                output.accept(ModItems.TRAILBLAZERBAT.get());
                output.accept(ModItems.SPARKLEHAMMER.get());
                output.accept(ModItems.HSRPHONE.get());
            } ).build());

    //(need to replace icon) Creates the HSR Consumables tab in the creative menu
    public static final RegistryObject<CreativeModeTab> HSRCONSUMABLE_TAB = CREATIVE_MODE_TABS.register("hsrconsumable_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TRAILBLAZERBAT.get())).title(Component.translatable("creativetab.hsrconsumable_tab"))
            .displayItems((itemDisplayParameters, output) ->{
                //Add consumables here
                output.accept(ModItems.TRAILBLAZERBAT.get()); //temp
            } ).build());

    //Creates the HSR Blocks tab in the creative menu
    public static final RegistryObject<CreativeModeTab> HSRBLOCK_TAB = CREATIVE_MODE_TABS.register("hsrblock_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TRAILBLAZERBAT.get())).title(Component.translatable("creativetab.hsrblock_tab"))
            .displayItems((itemDisplayParameters, output) ->{
                //Add blocks here
                output.accept(ModItems.TRAILBLAZERBAT.get());
            } ).build());

    //Function to register a new tab in the creative mode menu
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
