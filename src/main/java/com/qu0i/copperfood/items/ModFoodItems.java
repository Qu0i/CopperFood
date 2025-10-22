package com.qu0i.copperfood.items;

import com.qu0i.copperfood.Copperfood;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModFoodItems {

    public static final Item COPPER_CARROT = register(
            "copper_carrot",
            Item::new,
            new Item.Settings().food(ModFoodComponents.COPPER_CARROT_COMP, ModConsumableComponents.COPPER_CARROT_CONSUM_COMP)
    );
    public static final Item COPPER_APPLE = register(
            "copper_apple",
            Item::new,
            new Item.Settings().food(ModFoodComponents.COPPER_APPLE_COMP, ModConsumableComponents.COPPER_APPLE_CONSUM_COMP)
    );
    public static final Item COPPER_GINGERBREAD = register(
            "copper_gingerbread",
            Item::new,
            new Item.Settings().food(ModFoodComponents.COPPER_GINGERBREAD_COMP, ModConsumableComponents.COPPER_GINGERBREAD_CONSUM_COMP)
    );
    public static final Item SCULK_PIE = register(
            "sculk_pie",
            Item::new,
            new Item.Settings().food(ModFoodComponents.SCULK_PIE_COMP, ModConsumableComponents.SCULK_PIE_CONSUM_COMP)
    );

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.addAfter(Items.CARROT, ModFoodItems.COPPER_CARROT);
            entries.addAfter(Items.APPLE, ModFoodItems.COPPER_APPLE);
            entries.addAfter(Items.BREAD, ModFoodItems.COPPER_GINGERBREAD);
            entries.addAfter(Items.PUMPKIN_PIE, ModFoodItems.SCULK_PIE);
        });
    }


    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Copperfood.MOD_ID, name));

        Item item = itemFactory.apply(settings.registryKey(itemKey));

        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }
}
