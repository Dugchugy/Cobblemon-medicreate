package com.dug.cobblemonmedicreate.Fluids;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
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
		return YOUR_FLUID_BLOCK_HERE.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(fluidState));
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
    public static void Register(){
        STILL = Registry.register(Registries.FLUID, new Identifier("cobblemon-medicreate", "medicinal-brew"), 
        new MedicinalBrewFluid.Still());
        FLOW = Registry.register(Registries.FLUID, new Identifier("cobblemon-medicreate", "medicinal-brew-flow"), 
        new MedicinalBrewFluid.Flowing());
        BUCKET = Registry.register(Registries.ITEM, new Identifier("cobblemon-medicreate", "medicinal-brew-bucket"), 
        new BucketItem(STILL, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));
    }


}