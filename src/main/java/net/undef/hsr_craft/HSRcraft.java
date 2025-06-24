package net.undef.hsr_craft;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.undef.hsr_craft.block.ModBlocks;
import net.undef.hsr_craft.item.ModItems;
import net.undef.hsr_craft.menu.ModCreativeModTabs;
import net.undef.hsr_craft.networking.ClientServerCommunications;
import net.undef.hsr_craft.screens.HSRPhoneScreen;
import net.undef.hsr_craft.screens.ModMenuTypes;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(HSRcraft.MOD_ID)
public class HSRcraft{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "hsr_craft";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public HSRcraft(FMLJavaModLoadingContext context){
        IEventBus modEventBus = context.getModEventBus();

        //Registers the deferred register for mod creative mode tabs
        ModCreativeModTabs.register(modEventBus);

        //Registers the deferred register for mod items and blocks
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        //Registers the deferred register for mod menu types
        ModMenuTypes.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        //(REMOVED TEMPORARILY) Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event){

        //(MOVED TO CUSTOM TAB)Adds items into the combat tab in the creative menu
        //if(event.getTabKey() == CreativeModeTabs.COMBAT){
        //    event.accept(ModItems.TRAILBLAZERBAT);
        //    event.accept(ModItems.SPARKLEHAMMER);
        //}
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event){

    }

    public void commonSetup(final FMLCommonSetupEvent event){

        //Registers various classes needed during server startup
        event.enqueueWork(() -> {
            ClientServerCommunications.register();
        });
        System.out.println("commonSetup has run");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents{

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event){

            MenuScreens.register(ModMenuTypes.HSR_PHONE_MENU.get(), HSRPhoneScreen::new);
        }
    }
}
