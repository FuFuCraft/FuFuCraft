package org.abstruck.fabric.fufucraft.fufucraft.common.item.plant;

import net.minecraft.block.CropBlock;
import net.minecraft.item.AliasedBlockItem;
import org.abstruck.fabric.fufucraft.fufucraft.annotation.AItem;
import org.abstruck.fabric.fufucraft.fufucraft.registry.BlockRegistry;
import org.abstruck.fabric.fufucraft.fufucraft.registry.IdentifierRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author Astrack
 * @date 2023/7/10
 */
@Component
@AItem("rice_seed_item")
public class RiceSeedItem extends AliasedBlockItem {

    public RiceSeedItem(CropBlock riceCropBlock,Settings commonFabricItemSettings) {
        super(riceCropBlock, commonFabricItemSettings);
    }
}
