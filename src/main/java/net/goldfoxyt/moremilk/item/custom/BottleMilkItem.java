package net.goldfoxyt.moremilk.item.custom;

import net.goldfoxyt.moremilk.item.custom.interfaces.IFluidBucketWrapper;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.fluids.capability.wrappers.FluidBucketWrapper;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class BottleMilkItem extends Item implements IFluidBucketWrapper {
    private static final int DRINK_DURATION = 32;
    private final Consumer<LivingEntity> effect;

    public BottleMilkItem(Properties pProperties, Consumer<LivingEntity> effect) {
        super(pProperties);
        this.effect = effect;
    }

    /**
     * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
     * the Item before the action is complete.
     */
    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        if (pEntityLiving instanceof ServerPlayer $$3) {
            CriteriaTriggers.CONSUME_ITEM.trigger($$3, pStack);
            $$3.awardStat(Stats.ITEM_USED.get(this));
        }

        if (!pLevel.isClientSide) {
            pEntityLiving.removeAllEffects();
            effect.accept(pEntityLiving);
        }

        if (pEntityLiving instanceof Player $$4) {
            return ItemUtils.createFilledResult(pStack, $$4, new ItemStack(Items.GLASS_BOTTLE), false);
        } else {
            pStack.consume(1, pEntityLiving);
            return pStack;
        }
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getUseDuration(ItemStack pStack, LivingEntity livingEntity) {
        return 32;
    }

    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        return ItemUtils.startUsingInstantly(pLevel, pPlayer, pHand);
    }

    @Override
    public FluidBucketWrapper initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return new net.neoforged.neoforge.fluids.capability.wrappers.FluidBucketWrapper(stack);
    }
}