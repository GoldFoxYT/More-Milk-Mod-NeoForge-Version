package net.goldfoxyt.moremilk.creativetab;

import net.goldfoxyt.moremilk.MoreMilk;
import net.goldfoxyt.moremilk.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTabs {
   public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MoreMilk.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MORE_MILK_TAB = CREATIVE_MODE_TABS.register("more_milk_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MILK_BOTTLE.get()))
                    .title(Component.literal("More Milk Tab")).displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.MILK_BOTTLE.get());
                        output.accept(ModItems.MILK_CARTON.get());
                        output.accept(ModItems.EMPTY_MILK_CARTON.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
