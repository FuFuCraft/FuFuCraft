package org.abstruck.fabric.fufucraft.fufucraft.common.item.plant;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import org.abstruck.fabric.fufucraft.fufucraft.annotation.AItem;
import org.abstruck.fabric.fufucraft.fufucraft.registry.IdentifierRequired;
import org.springframework.stereotype.Component;

/**
 * @author Astrack
 * @date 2023/7/14
 */
@Component
@AItem("sauced_spring_onion")
public class SaucedSpringOnion extends Item {
    public static final Settings SETTINGS = new FabricItemSettings().food(new FoodComponent.Builder().snack().hunger(1).build());
    public SaucedSpringOnion() {
        super(SETTINGS);
    }
}
