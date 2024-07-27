package net.goldfoxyt.moremilk.item;

import net.goldfoxyt.moremilk.MoreMilk;
import net.goldfoxyt.moremilk.block.ModBlocks;
import net.goldfoxyt.moremilk.item.custom.BottleMilkItem;
import net.goldfoxyt.moremilk.item.custom.CartonMilkItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegistryBuilder;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM, MoreMilk.MOD_ID);

    public static final DeferredHolder<Item, BottleMilkItem> MILK_BOTTLE = ITEMS.register("milk_bottle",
            () -> new BottleMilkItem(new Item.Properties().stacksTo(1), entity -> {}));

    public static final DeferredHolder<Item, BottleMilkItem> CHOCOLATE_MILK_BOTTLE = ITEMS.register("chocolate_milk_bottle",
            () -> new BottleMilkItem(new Item.Properties().stacksTo(1),
                    entity -> entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 900, 1))));

    public static final DeferredHolder<Item, BottleMilkItem> BANANA_MILK_BOTTLE = ITEMS.register("banana_milk_bottle",
            () -> new BottleMilkItem(new Item.Properties().stacksTo(1),
                    entity -> entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 900, 1))));

    public static final DeferredHolder<Item, CartonMilkItem> MILK_CARTON = ITEMS.register("milk_carton",
            () -> new CartonMilkItem(new Item.Properties().stacksTo(1)));

    public static final DeferredHolder<Item, Item> EMPTY_MILK_CARTON = ITEMS.register("empty_milk_carton",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> BANANA = ITEMS.register("banana",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BANANA)));

    public static final DeferredHolder<Item, ItemNameBlockItem> BANANA_SEEDS = ITEMS.register("banana_seeds",
            () -> new ItemNameBlockItem(ModBlocks.BANANA_CROP.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
