package net.vismayb.toxtweaks;

import net.fabricmc.api.ModInitializer;

import net.vismayb.toxtweaks.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ToxTweaks implements ModInitializer {
	public static final String MOD_ID = "toxtweaks";
    public static final Logger LOGGER = LoggerFactory.getLogger("toxtweaks");

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing: " + MOD_ID);
		ModItems.registerItems();
	}
}