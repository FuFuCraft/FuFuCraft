package org.abstruck.fabric.fufucraft.fufucraft.common.item.plant;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.abstruck.fabric.fufucraft.fufucraft.annotation.AItem;
import org.springframework.stereotype.Component;

/**
 * @author Astrack
 * @date 2023/7/10
 */
@Component
@AItem("small_pack_of_rice_item")
public class SmallPackOfRiceItem extends FuFuFoodItem {
    public SmallPackOfRiceItem(Settings commonFabricItemSettings) {
        super(commonFabricItemSettings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {

        return ActionResult.PASS;
    }

    @Override
    public double tameRate() {
        return 0;
    }
}
