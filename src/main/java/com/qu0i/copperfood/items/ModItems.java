package com.qu0i.copperfood.items;

import com.qu0i.copperfood.Copperfood;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    public static ConsumableComponent COPPER_APPLE_CONSUM_COMP = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HASTE, 90 * 20, 0), 1.0f)).build();
    public static ConsumableComponent COPPER_CARROT_CONSUM_COMP = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 60 * 20, 0), 1.0f)).build();

    public static FoodComponent COPPER_APPLE_COMP = new FoodComponent.Builder()
            .nutrition(3)
            .alwaysEdible()
            .build();
    public static FoodComponent COPPER_CARROT_COMP = new FoodComponent.Builder()
            .nutrition(5)
            .alwaysEdible()
            .build();

    public static final Item COPPER_CARROT = register(
            "copper_carrot",
            Item::new,
            new Item.Settings().food(COPPER_CARROT_COMP, COPPER_CARROT_CONSUM_COMP)
    );

    public static final Item COPPER_APPLE = register(
            "copper_apple",
            Item::new,
            new Item.Settings().food(COPPER_APPLE_COMP, COPPER_APPLE_CONSUM_COMP)
    );


    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.addAfter(Items.CARROT, ModItems.COPPER_CARROT);
            entries.addAfter(Items.APPLE, ModItems.COPPER_APPLE);
        });
    }

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Copperfood.MOD_ID, name));

        Item item = itemFactory.apply(settings.registryKey(itemKey));

        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }
}
