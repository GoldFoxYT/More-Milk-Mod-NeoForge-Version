package net.goldfoxyt.moremilk.block;

import net.goldfoxyt.moremilk.MoreMilk;
import net.goldfoxyt.moremilk.block.custom.BananaCropBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(BuiltInRegistries.BLOCK, MoreMilk.MOD_ID);

    public static final DeferredHolder<Block, BananaCropBlock> BANANA_CROP = BLOCKS.register("banana_crop",
            () -> new BananaCropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}