package org.abstruck.fabric.fufucraft.fufucraft.common.item.plant;

import net.minecraft.block.Block;
import net.minecraft.item.AliasedBlockItem;
import org.abstruck.fabric.fufucraft.fufucraft.annotation.AItem;
import org.abstruck.fabric.fufucraft.fufucraft.registry.BlockRegistry;
import org.springframework.stereotype.Component;

/**
 * @author Astrack
 * @date 2023/7/14
 */
@Component
@AItem( "spring_onion_seed")
public class SpringOnionSeed extends AliasedBlockItem {
    public SpringOnionSeed(Block springOnionCrop, Settings commonFabricItemSettings) {
        super(springOnionCrop,commonFabricItemSettings);
    }
}
