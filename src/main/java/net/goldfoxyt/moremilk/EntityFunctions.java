package net.goldfoxyt.moremilk;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Cow;

public class EntityFunctions {
    public static boolean isMilkable(Entity entity) {
        if (entity instanceof Cow) {
            if (!(entity instanceof Animal)) {
                return false;
            }

            Animal animal = (Animal) entity;
            return !animal.isBaby();
        }
        return false;
    }
}