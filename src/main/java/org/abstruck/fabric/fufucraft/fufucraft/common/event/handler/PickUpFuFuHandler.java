package org.abstruck.fabric.fufucraft.fufucraft.common.event.handler;

import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.abstruck.fabric.fufucraft.fufucraft.common.entity.fufu.BaseFuFuEntity;
import org.jetbrains.annotations.Nullable;

/**
 * @author Astrack
 * @date 2023/7/10
 */
@Deprecated
public class PickUpFuFuHandler implements UseEntityCallback {
    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, Entity entity, @Nullable EntityHitResult hitResult) {
        if (player.isSpectator()){
            return ActionResult.PASS;
        }
        if (!(entity instanceof BaseFuFuEntity fufu)){
            return ActionResult.PASS;
        }
        if (!player.isSneaking()){
            return ActionResult.PASS;
        }
        if (player.getStackInHand(hand).getItem() != Items.AIR){
            return ActionResult.PASS;
        }
        return pickup(player,fufu);
    }

    private ActionResult pickup(PlayerEntity player, BaseFuFuEntity fufu) {
        if (fufu.startRiding(player,true)) {
            return ActionResult.SUCCESS;
        } else {
            return ActionResult.FAIL;
        }
    }

}
