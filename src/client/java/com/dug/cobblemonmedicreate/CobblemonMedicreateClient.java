package com.dug.cobblemonmedicreate;

import com.dug.cobblemonmedicreate.Fluids.*;

import net.fabricmc.api.ClientModInitializer;

public class CobblemonMedicreateClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.

		MedicinalBrewFluid.registerRenderer();
	}
}