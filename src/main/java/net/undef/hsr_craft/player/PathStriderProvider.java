package net.undef.hsr_craft.player;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PathStriderProvider implements ICapabilityProvider, INBTSerializable<CompoundTag>{

    public static Capability<PathStrider> PATH_STRIDER = CapabilityManager.get(new CapabilityToken<PathStrider>() {});
    private PathStrider Path_Strider = null;
    private final LazyOptional<PathStrider> optional = LazyOptional.of(this::createPathStrider);

    private @NotNull PathStrider createPathStrider(){
        if(this.Path_Strider == null){
            this.Path_Strider = new PathStrider();
        }
        return this.Path_Strider;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == PATH_STRIDER){
            return optional.cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPathStrider().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPathStrider().loadNBTData(nbt);
    }
}
