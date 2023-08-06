package org.abstruck.fabric.fufucraft.fufucraft.common.item.plant;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import org.abstruck.fabric.fufucraft.fufucraft.annotation.AItem;
import org.springframework.stereotype.Component;

/**
 * @author Astrack
 * @date 2023/7/14
 */
@Component
@AItem("spring_onion")
public class SpringOnion extends SwordItem {
    public SpringOnion() {
        super(new ToolMaterial() {
            @Override
            public int getDurability() {
                return 500;
            }

            @Override
            public float getMiningSpeedMultiplier() {
                return 0;
            }

            @Override
            public float getAttackDamage() {
                return 3.0F;
            }

            @Override
            public int getMiningLevel() {
                return 0;
            }

            @Override
            public int getEnchantability() {
                return 0;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.EMPTY;
            }
        }, 3, 6.0F, new FabricItemSettings());
    }
}
