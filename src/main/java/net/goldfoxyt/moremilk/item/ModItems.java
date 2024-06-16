package net.goldfoxyt.moremilk.item;

import net.goldfoxyt.moremilk.MoreMilk;
import net.goldfoxyt.moremilk.item.custom.BottleMilkItem;
import net.goldfoxyt.moremilk.item.custom.CartonMilkItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegistryBuilder;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM, MoreMilk.MOD_ID);

    public static final DeferredHolder<Item, BottleMilkItem> MILK_BOTTLE = ITEMS.register("milk_bottle",
            () -> new BottleMilkItem(new Item.Properties().stacksTo(1)));

    public static final DeferredHolder<Item, CartonMilkItem> MILK_CARTON = ITEMS.register("milk_carton",
            () -> new CartonMilkItem(new Item.Properties().stacksTo(1)));

    public static final DeferredHolder<Item, Item> EMPTY_MILK_CARTON = ITEMS.register("empty_milk_carton",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
