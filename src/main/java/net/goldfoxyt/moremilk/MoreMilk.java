package net.goldfoxyt.moremilk;

import net.goldfoxyt.moremilk.block.ModBlocks;
import net.goldfoxyt.moremilk.creativetab.ModCreativeModeTabs;
import net.goldfoxyt.moremilk.event.ForgeMilkEvent;
import net.goldfoxyt.moremilk.item.ModItems;
import net.goldfoxyt.moremilk.loot.ModLootModifiers;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(MoreMilk.MOD_ID)
public class MoreMilk {

    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "moremilk";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MoreMilk(IEventBus modEventBus, ModContainer modContainer) {

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
        ModLootModifiers.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }
    private void loadComplete(final FMLLoadCompleteEvent event) {
        NeoForge.EVENT_BUS.register(new ForgeMilkEvent());
    }

    private void commonSetup(final FMLCommonSetupEvent event){

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS){
            event.accept(ModItems.MILK_BOTTLE.get());
            event.accept(ModItems.CHOCOLATE_MILK_BOTTLE.get());
            event.accept(ModItems.BANANA_MILK_BOTTLE.get());
            event.accept(ModItems.MILK_CARTON.get());
            event.accept(ModItems.EMPTY_MILK_CARTON.get());
            event.accept(ModItems.BANANA.get());
            event.accept(ModItems.BANANA_SEEDS.get());
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
