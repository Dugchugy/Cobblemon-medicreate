package com.dug.cobblemonmedicreate.Fluids;


import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.fluid.*;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

public abstract class MedicinalBrewFluid extends MediFluidBase{

    /**
     * A static refernce to the still version for this fluid
     */
    public static FlowableFluid STILL;
    /**
     * A static reference to the flowing version for this fluid
     */
    public static FlowableFluid FLOW;
    /**
     * A static reference to the bucket for this fluid
     */
    public static Item BUCKET;

    /**
     * A static refernece to the block form of this fluid
     */
    public static Block BLOCK;

    /**
     * @return the still reference for this fluid
     */
    @Override
	public Fluid getStill() {
		return STILL;
	}
 
    /**
     * @return the flowing reference for this fluid
     */
	@Override
	public Fluid getFlowing() {
		return FLOW;
	}
 
    /**
     * @return the bucekt of this fluid
     */
	@Override
	public Item getBucketItem() {
		return BUCKET;
	}
 
	@Override
	protected BlockState toBlockState(FluidState fluidState) {
		return BLOCK.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(fluidState));
	}

    public static class Flowing extends MedicinalBrewFluid {
		@Override
		protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
			super.appendProperties(builder);
			builder.add(LEVEL);
		}
 
		@Override
		public int getLevel(FluidState fluidState) {
			return fluidState.get(LEVEL);
		}
 
		@Override
		public boolean isStill(FluidState fluidState) {
			return false;
		}
	}

    public static class Still extends MedicinalBrewFluid {
        @Override
        public int getLevel(FluidState fluidState) {
            return 8;
        }
 
        @Override
        public boolean isStill(FluidState fluidState) {
            return true;
        }
    }

    /**
     * A function that calls the required registy functions to register the fluid
     */
    public static void Register(RegistryKey<ItemGroup> group){
        STILL = Registry.register(Registries.FLUID, new Identifier("cobblemon-medicreate", "medicinal-brew"), 
        new MedicinalBrewFluid.Still());
        FLOW = Registry.register(Registries.FLUID, new Identifier("cobblemon-medicreate", "medicinal-brew-flow"), 
        new MedicinalBrewFluid.Flowing());
        BUCKET = Registry.register(Registries.ITEM, new Identifier("cobblemon-medicreate", "medicinal-brew-bucket"), 
        new BucketItem(STILL, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));

        BLOCK = Registry.register(Registries.BLOCK, new Identifier("cobblemon-medicreate", "medicinal-brew-block"), 
        new FluidBlock(STILL, FabricBlockSettings.copy(Blocks.WATER)){});

        ItemGroupEvents.modifyEntriesEvent(group).register(content -> {
            content.add(BUCKET);
        });
    }

    public static void registerRenderer(){
        FluidRenderHandlerRegistry.INSTANCE.register(STILL, FLOW, new SimpleFluidRenderHandler(
            new Identifier("minecraft:block/water_still"),
			new Identifier("minecraft:block/water_flow"),
			0x4CC248
        ));
    }


}