package com.dug.cobblemonmedicreate.Fluids;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.property.Properties;

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

}