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
				0x05E3B3
		));

		FluidRenderHandlerRegistry.INSTANCE.register(PotionFluid.STILL, PotionFluid.FLOW, 
		new SimpleFluidRenderHandler(
				new Identifier("minecraft:block/water_still"),
				new Identifier("minecraft:block/water_flow"),
				0x9435F2
		));

		FluidRenderHandlerRegistry.INSTANCE.register(SuperPotionFluid.STILL, SuperPotionFluid.FLOW, 
		new SimpleFluidRenderHandler(
				new Identifier("minecraft:block/water_still"),
				new Identifier("minecraft:block/water_flow"),
				0xD15D43
		));

		FluidRenderHandlerRegistry.INSTANCE.register(HyperPotionFluid.STILL, HyperPotionFluid.FLOW, 
		new SimpleFluidRenderHandler(
				new Identifier("minecraft:block/water_still"),
				new Identifier("minecraft:block/water_flow"),
				0xDB4B87
		));

		FluidRenderHandlerRegistry.INSTANCE.register(MaxPotionFluid.STILL, MaxPotionFluid.FLOW, 
		new SimpleFluidRenderHandler(
				new Identifier("minecraft:block/water_still"),
				new Identifier("minecraft:block/water_flow"),
				0x4BC5DE
		));

		FluidRenderHandlerRegistry.INSTANCE.register(AntidoteFluid.STILL, AntidoteFluid.FLOW, 
		new SimpleFluidRenderHandler(
				new Identifier("minecraft:block/water_still"),
				new Identifier("minecraft:block/water_flow"),
				0xFFFF00
		));

		FluidRenderHandlerRegistry.INSTANCE.register(AwakeningFluid.STILL, AwakeningFluid.FLOW, 
		new SimpleFluidRenderHandler(
				new Identifier("minecraft:block/water_still"),
				new Identifier("minecraft:block/water_flow"),
				0x00FBFF
		));

		FluidRenderHandlerRegistry.INSTANCE.register(BurnHealFluid.STILL, BurnHealFluid.FLOW, 
		new SimpleFluidRenderHandler(
				new Identifier("minecraft:block/water_still"),
				new Identifier("minecraft:block/water_flow"),
				0x3DEB7D
		));

		FluidRenderHandlerRegistry.INSTANCE.register(FullHealFluid.STILL, FullHealFluid.FLOW, 
		new SimpleFluidRenderHandler(
				new Identifier("minecraft:block/water_still"),
				new Identifier("minecraft:block/water_flow"),
				0xF7DE39
		));

		FluidRenderHandlerRegistry.INSTANCE.register(FullRestoreFluid.STILL, FullRestoreFluid.FLOW, 
		new SimpleFluidRenderHandler(
				new Identifier("minecraft:block/water_still"),
				new Identifier("minecraft:block/water_flow"),
				0x91DB4B
		));

		FluidRenderHandlerRegistry.INSTANCE.register(IceHealFluid.STILL, IceHealFluid.FLOW, 
		new SimpleFluidRenderHandler(
				new Identifier("minecraft:block/water_still"),
				new Identifier("minecraft:block/water_flow"),
				0xC973B4
		));

		FluidRenderHandlerRegistry.INSTANCE.register(ParalyzeHealFluid.STILL, ParalyzeHealFluid.FLOW, 
		new SimpleFluidRenderHandler(
				new Identifier("minecraft:block/water_still"),
				new Identifier("minecraft:block/water_flow"),
				0xEBE013
		));

		FluidRenderHandlerRegistry.INSTANCE.register(EtherFluid.STILL, EtherFluid.FLOW, 
		new SimpleFluidRenderHandler(
				new Identifier("minecraft:block/water_still"),
				new Identifier("minecraft:block/water_flow"),
				0xF174EF
		));
	}
}