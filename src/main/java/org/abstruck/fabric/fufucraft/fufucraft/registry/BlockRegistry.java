package org.abstruck.fabric.fufucraft.fufucraft.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.abstruck.fabric.fufucraft.fufucraft.common.block.crop.RiceCropBlock;
import org.abstruck.fabric.fufucraft.fufucraft.common.block.crop.SpringOnionCrop;
import org.abstruck.fabric.fufucraft.fufucraft.util.RegistryUtils;

/**
 * @author Astrack
 * @date 2023/7/10
 */
public class BlockRegistry {
    public static final CropBlock RICE_CROP_BLOCK = new RiceCropBlock(FabricBlockSettings.copy(Blocks.WHEAT));
    public static final CropBlock SPRING_ONION_CROP = new SpringOnionCrop(FabricBlockSettings.copy(Blocks.WHEAT));

    public static void register(){
        registerSingleBlock(RICE_CROP_BLOCK);
        registerSingleBlock(SPRING_ONION_CROP);
    }

    public static void registerSingleBlock(Block block){
        if (!(block instanceof IdentifierRequired identifierRequired)){
            throw new RuntimeException(block.getTranslationKey()+" 注册失败");

        }
        Registry.register(Registries.BLOCK, RegistryUtils.getFullIdentifier(identifierRequired),block);
    }
}
