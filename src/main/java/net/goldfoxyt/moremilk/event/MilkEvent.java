package net.goldfoxyt.moremilk.event;

import net.goldfoxyt.moremilk.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

import static net.goldfoxyt.moremilk.EntityFunctions.isMilkable;

public class MilkEvent {
    public static InteractionResult onEntityInteract(Player player, Level world, InteractionHand hand, Entity entity, EntityHitResult hitResult) {
        if (world.isClientSide) {
            return InteractionResult.PASS;
        }


        ItemStack itemstack = player.getItemInHand(hand);
        if (itemstack.getItem().equals(Items.GLASS_BOTTLE)) {
            if (isMilkable(entity)) {
                world.playSound(null, player.getOnPos(), SoundEvents.COW_MILK, SoundSource.PLAYERS, 1f, 1f);
                itemstack.shrink(1);

                if (itemstack.isEmpty()) {
                    player.setItemInHand(hand, new ItemStack(ModItems.MILK_BOTTLE.get()));
                }
                else if (!player.getInventory().add(new ItemStack(ModItems.MILK_BOTTLE.get()))) {
                    player.drop(new ItemStack(ModItems.MILK_BOTTLE.get()), false);
                }

                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.PASS;
    }
}