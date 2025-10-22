package com.qu0i.copperfood;

import com.qu0i.copperfood.items.ModFoodItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Copperfood implements ModInitializer {
    public static final String MOD_ID = "copperfood";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initialized.");
        ModFoodItems.initialize();

    }
}
