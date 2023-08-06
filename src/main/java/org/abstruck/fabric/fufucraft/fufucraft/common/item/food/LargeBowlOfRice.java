package org.abstruck.fabric.fufucraft.fufucraft.common.item.food;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import org.abstruck.fabric.fufucraft.fufucraft.annotation.AItem;
import org.springframework.stereotype.Component;

/**
 * @author Astrack
 * @date 2023/7/13
 */
@Component
@AItem("large_bowl_of_rice")
public class LargeBowlOfRice extends Item {
    public final static Settings ITEM_SETTINGS = new FabricItemSettings()
            .food(new FoodComponent.Builder()
                    .snack()
                    .hunger(9)
                    .build());
    public LargeBowlOfRice() {
        super(ITEM_SETTINGS);
    }
}
