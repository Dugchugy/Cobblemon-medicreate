package com.dug.cobblemonmedicreate.Fluids;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.Item;

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

}