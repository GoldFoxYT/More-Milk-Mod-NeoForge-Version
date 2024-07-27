package net.goldfoxyt.moremilk.datagen;

import net.goldfoxyt.moremilk.MoreMilk;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

import static net.goldfoxyt.moremilk.item.ModItems.*;


public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output, String locale) {
        super(output, MoreMilk.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        addItem(MILK_BOTTLE, "Milk Bottle");
        addItem(CHOCOLATE_MILK_BOTTLE, "Chocolate Milk Bottle");
        addItem(BANANA_MILK_BOTTLE, "Banana Milk Bottle");
        addItem(MILK_CARTON, "Milk Carton");
        addItem(EMPTY_MILK_CARTON, "Empty Milk Carton");
        addItem(BANANA, "Banana");
        addItem(BANANA_SEEDS, "Banana Seeds");
    }
}
