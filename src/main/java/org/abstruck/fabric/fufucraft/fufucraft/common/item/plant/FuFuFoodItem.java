package org.abstruck.fabric.fufucraft.fufucraft.common.item.plant;

import net.minecraft.item.Item;

/**
 * @author Astrack
 * @date 2023/7/12
 */
public abstract class FuFuFoodItem extends Item {
    public FuFuFoodItem(Settings settings) {
        super(settings);
    }

    abstract public double tameRate();
}
