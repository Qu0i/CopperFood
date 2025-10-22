package com.qu0i.copperfood.items;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static FoodComponent COPPER_APPLE_COMP = new FoodComponent.Builder()
            .nutrition(3)
            .alwaysEdible()
            .build();
    public static FoodComponent COPPER_CARROT_COMP = new FoodComponent.Builder()
            .nutrition(5)
            .alwaysEdible()
            .build();
    public static FoodComponent COPPER_GINGERBREAD_COMP = new FoodComponent.Builder()
            .nutrition(5)
            .saturationModifier(6)
            .build();
    public static FoodComponent SCULK_PIE_COMP = new FoodComponent.Builder()
            .nutrition(8)
            .saturationModifier(4.8f)
            .alwaysEdible()
            .build();
}
