package org.abstruck.fabric.fufucraft.fufucraft.common.event.handler;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.abstruck.fabric.fufucraft.fufucraft.common.entity.fufu.BaseFuFuEntity;
import org.springframework.stereotype.Component;

/**
 * @author Astrack
 * @date 2023/7/12
 */
@Component
public class PutDownFuFuHandler implements UseItemCallback {
    public PutDownFuFuHandler(){
        UseItemCallback.EVENT.register(this);
    }


    @Override
    public TypedActionResult<ItemStack> interact(PlayerEntity player, World world, Hand hand) {
        ItemStack inHand = player.getStackInHand(hand);
        final TypedActionResult<ItemStack> PASS_RESULT = TypedActionResult.pass(inHand);

        if (player.isSpectator()){
            return PASS_RESULT;
        }
        if (!player.isSneaking() || inHand.getItem() != Items.AIR){
            return PASS_RESULT;
        }
        if (player.getControllingPassenger() instanceof BaseFuFuEntity fufu){
            fufu.stopRiding();
            return TypedActionResult.success(inHand);
        }
        return PASS_RESULT;
    }

//    static {
//        UseItemCallback.EVENT.register(new PutDownFuFuHandler());
//    }
}
