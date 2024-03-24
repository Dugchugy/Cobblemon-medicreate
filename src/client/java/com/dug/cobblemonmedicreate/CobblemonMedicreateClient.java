package com.dug.cobblemonmedicreate;

import com.dug.cobblemonmedicreate.Fluids.*;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.util.Identifier;

public class CobblemonMedicreateClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.

		FluidRenderHandlerRegistry.INSTANCE.register(MedicinalBrewFluid.STILL, MedicinalBrewFluid.FLOW, new SimpleFluidRenderHandler(
				new Identifier("minecraft:block/water_still"),
				new Identifier("minecraft:block/water_flow"),
				0x4CC248
		));
	}
}