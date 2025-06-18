package net.undef.hsr_craft.screens;

import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.undef.hsr_craft.HSRcraft;

public class ModMenuTypes {

    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, HSRcraft.MOD_ID);
    public static final RegistryObject<MenuType<HSRPhoneMenu>> HSR_PHONE_MENU = MENUS.register("hsr_phone_menu", () -> IForgeMenuType.create(HSRPhoneMenu::new));
    //public static final RegistryObject<MenuType<HSRPhoneMenu>> HSR_PHONE_MENU = registerMenuTypes("hsr_phone_menu", HSRPhoneMenu::new);

    /*private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuTypes(String name, IContainerFactory<T> factory){
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }*/

    //Used in HSRcraft class
    public static void register(IEventBus eventBus){
        MENUS.register(eventBus);
    }
}
