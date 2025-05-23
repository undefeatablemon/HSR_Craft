package net.undef.hsr_craft.block.customBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.undef.hsr_craft.player.PathStrider;

public class PathEmergenceBlock extends Block {

    PathStrider pathstrider;

    public PathEmergenceBlock(Properties blockProperties){
        super(blockProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        if(pLevel.isClientSide && pHand.toString() == "MAIN_HAND"){
            pPlayer.sendSystemMessage(Component.literal("Finality is the best path\n No jokes, just pure facts"));
            //pathstrider = new PathStrider(pPlayer); //Need to register somehow
        }

        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

}
