package com.qu0i.copperfood.items;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.item.consume.RemoveEffectsConsumeEffect;

import java.util.List;

public class ModConsumableComponents {
    public static ConsumableComponent COPPER_APPLE_CONSUM_COMP = net.minecraft.component.type.ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HASTE, 90 * 20, 0), 1.0f)).build();
    public static ConsumableComponent COPPER_CARROT_CONSUM_COMP = net.minecraft.component.type.ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 60 * 20, 0), 1.0f)).build();
    public static ConsumableComponent COPPER_GINGERBREAD_CONSUM_COMP = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(List.of(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE,   1, 0), new StatusEffectInstance(StatusEffects.STRENGTH, 60 * 20, 1)))).build();
    public static ConsumableComponent SCULK_PIE_CONSUM_COMP = ConsumableComponents.food()
            .consumeEffect(new RemoveEffectsConsumeEffect(StatusEffects.DARKNESS)).build();
}