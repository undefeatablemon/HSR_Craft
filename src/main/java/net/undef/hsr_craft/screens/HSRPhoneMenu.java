package net.undef.hsr_craft.screens;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.undef.hsr_craft.item.customItems.HSRPhone;
import org.jetbrains.annotations.Nullable;

import static net.undef.hsr_craft.screens.ModMenuTypes.HSR_PHONE_MENU;

public class HSRPhoneMenu extends AbstractContainerMenu {

    public final Player player;

    // Client menu constructor
    public HSRPhoneMenu(int containerId, Inventory playerInventory, FriendlyByteBuf extraData) {
        this(containerId, playerInventory);
}

    //Constructor for server
    public HSRPhoneMenu(int pContainerId, Inventory playerInv){
        super(HSR_PHONE_MENU.get(), pContainerId);
        this.player = playerInv.player;
    }

    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        return null;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return true;
    }

    public void pathButtonClicked(){
        player.sendSystemMessage(Component.literal("Path Button is currently WIP"));
    }

    public void characterButtonClicked(){
        player.sendSystemMessage(Component.literal("Character Button is currently WIP"));
    }

    public void inventoryButtonClicked(){
        player.sendSystemMessage(Component.literal("Inventory Button is currently WIP"));
    }

    public void partyButtonClicked(){
        player.sendSystemMessage(Component.literal("Party Button is currently WIP"));
    }
}
