package net.goldfoxyt.moremilk.datagen;

import net.goldfoxyt.moremilk.MoreMilk;
import net.goldfoxyt.moremilk.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MoreMilk.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.MILK_BOTTLE.get());
        basicItem(ModItems.CHOCOLATE_MILK_BOTTLE.get());
        basicItem(ModItems.BANANA_MILK_BOTTLE.get());
        basicItem(ModItems.MILK_CARTON.get());
        basicItem(ModItems.EMPTY_MILK_CARTON.get());
        basicItem(ModItems.BANANA.get());
        basicItem(ModItems.BANANA_SEEDS.get());
    }
}
