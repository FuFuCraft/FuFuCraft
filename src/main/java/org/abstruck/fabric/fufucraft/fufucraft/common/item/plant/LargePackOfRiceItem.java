package org.abstruck.fabric.fufucraft.fufucraft.common.item.plant;

import org.abstruck.fabric.fufucraft.fufucraft.annotation.AItem;
import org.springframework.stereotype.Component;

/**
 * @author Astrack
 * @date 2023/7/12
 */
@Component
@AItem("large_pack_of_rice_item")
public class LargePackOfRiceItem extends FuFuFoodItem{
    public LargePackOfRiceItem(Settings commonFabricItemSettings) {
        super(commonFabricItemSettings);
    }
    @Override
    public double tameRate() {
        return 0;
    }
}
