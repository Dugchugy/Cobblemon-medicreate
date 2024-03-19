package com.dug.cobblemonmedicreate;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.util.*;
import net.minecraft.text.*;

import com.dug.cobblemonmedicreate.Fluids.*;

public class CobblemonMedicreate implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("cobblemon-medicreate");

	//creates a new empty spray bottle item
	public static final Item EMPTY_SPRAY_BOTTLE = new Item(new FabricItemSettings());

	//creates an item group for all the medicreate items
	public static final ItemGroup CREOMEDGROUP = FabricItemGroup.builder()
		.icon(() -> new ItemStack(EMPTY_SPRAY_BOTTLE))
		.displayName(Text.translatable("itemGroup.cobblemon-medicreate.main-group"))
		.entries((context, entries) ->{
			entries.add(EMPTY_SPRAY_BOTTLE);
		})
		.build();

	@Override
	public void onInitialize() {
		//registers the item
		Registry.register(Registries.ITEM, new Identifier("cobblemon-medicreate", "empty-spray-bottle"), EMPTY_SPRAY_BOTTLE);

		//registers the item group
		Registry.register(Registries.ITEM_GROUP, new Identifier("cobblemon-medicreate", "main-group"), CREOMEDGROUP);

		RegistryKey<ItemGroup> GroupKey = RegistryKey.of(Registries.ITEM_GROUP.getKey(), new Identifier("cobblemon-medicreate", "main-group"));

		//initalizes the fluids
		MedicinalBrewFluid.Register(GroupKey);
		PotionFluid.Register(GroupKey);
		SuperPotionFluid.Register(GroupKey);
		HyperPotionFluid.Register(GroupKey);
		MaxPotionFluid.Register(GroupKey);
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
	}
}