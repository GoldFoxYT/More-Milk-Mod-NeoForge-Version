package net.goldfoxyt.moremilk.datagen;

import net.goldfoxyt.moremilk.MoreMilk;
import net.goldfoxyt.moremilk.item.ModItems;
import net.goldfoxyt.moremilk.loot.AddItemModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, MoreMilk.MOD_ID);
    }

    @Override
    protected void start() {
        add("banana_seeds_from_short_grass", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SHORT_GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.45f).build()
        }, ModItems.BANANA_SEEDS.get()));
        add("banana_seeds_from_tall_grass", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.TALL_GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.45f).build()
        }, ModItems.BANANA_SEEDS.get()));
        add("banana_seeds_from_villages", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/village/village_desert_house")).build(),
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/village/village_plains_house")).build(),
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/village/village_savanna_house")).build(),
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/village/village_snowy_house")).build(),
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/village/village_taiga_house")).build(),
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/village/village_desert_house")).build(),
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/village/village_armorer")).invert().build(),
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/village/village_butcher")).invert().build(),
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/village/village_cartographer")).invert().build(),
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/village/village_fisher")).invert().build(),
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/village/village_fletcher")).invert().build(),
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/village/village_mason")).invert().build(),
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/village/village_shepherd")).invert().build(),
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/village/village_tannery")).invert().build(),
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/village/village_toolsmith")).invert().build(),
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/village/village_weaponsmith")).invert().build(),
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/village/village_temple")).invert().build()
        }, ModItems.BANANA_SEEDS.get()));
    }
}
