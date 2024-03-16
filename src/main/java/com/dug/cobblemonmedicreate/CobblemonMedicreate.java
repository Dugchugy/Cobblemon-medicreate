package com.dug.cobblemonmedicreate;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.util.*;

public class CobblemonMedicreate implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("cobblemon-medicreate");

	//creates a new empty spray bottle item
	public static final Item EMPTY_SPRAY_BOTTLE = new Item(new FabricItemSettings());

	@Override
	public void onInitialize() {
		
		Registry.register(Registries.ITEM, new Identifier("cobblemon-medicreate", "empty-spray-bottle"), EMPTY_SPRAY_BOTTLE);
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
	}
}