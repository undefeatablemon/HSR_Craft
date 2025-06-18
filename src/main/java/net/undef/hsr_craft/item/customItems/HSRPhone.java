package net.undef.hsr_craft.item.customItems;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ComplexItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MapItem;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;
import net.undef.hsr_craft.item.ModItems;
import net.undef.hsr_craft.player.PathStriderProvider;
import net.undef.hsr_craft.screens.HSRPhoneMenu;
import org.jetbrains.annotations.Nullable;

public class HSRPhone extends Item implements MenuProvider{

    public HSRPhone(Properties pProperties){
        super(pProperties);
    }

    //Added for menu provider, might need to be moved
    @Override
    public Component getDisplayName(){
        return Component.translatable("item.hsr_craft.hsr_phone");
    }

    //Added for menu provider, might need to be moved
    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer){
        return new HSRPhoneMenu(pContainerId, pPlayerInventory);
    }

    //Opens a gui when right-clicked  17:28
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack phone = pPlayer.getItemInHand(pUsedHand);
        if(!pLevel.isClientSide()){
            NetworkHooks.openScreen((ServerPlayer) pPlayer, this);
        }
        /*else{  //Might be important
            throw new IllegalStateException("Container Provider Missing");
        }*/
        return InteractionResultHolder.sidedSuccess(phone,pLevel.isClientSide());
    }
}
