package net.goldfoxyt.moremilk.item.custom.interfaces;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.fluids.capability.wrappers.FluidBucketWrapper;
import org.jetbrains.annotations.Nullable;

public interface IFluidBucketWrapper {
    FluidBucketWrapper initCapabilities(ItemStack stack, @Nullable CompoundTag nbt);
}
