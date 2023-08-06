package org.abstruck.fabric.fufucraft.fufucraft.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import org.abstruck.fabric.fufucraft.fufucraft.client.render.entity.FlowerFuFuEntityRender;
import org.abstruck.fabric.fufucraft.fufucraft.client.render.entity.FuFuEntityRender;
import org.abstruck.fabric.fufucraft.fufucraft.client.render.entity.SakuraFuFuEntityRender;
import org.abstruck.fabric.fufucraft.fufucraft.client.render.entity.SnowFuFuEntityRender;
import org.abstruck.fabric.fufucraft.fufucraft.registry.BlockRegistry;
import org.abstruck.fabric.fufucraft.fufucraft.registry.EntityRegistry;

/**
 * @author Astrack
 * @date 2023/7/10
 */
@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class FuFuCraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
//        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), BlockRegistry.RICE_CROP_BLOCK);
//        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), BlockRegistry.SPRING_ONION_CROP);
//        EntityRendererRegistry.register(EntityRegistry.FU_FU_ENTITY_ENTITY_TYPE, FuFuEntityRender::new);
//        EntityRendererRegistry.register(EntityRegistry.SNOW_FU_FU_ENTITY_ENTITY_TYPE, SnowFuFuEntityRender::new);
//        EntityRendererRegistry.register(EntityRegistry.SAKURA_FU_FU_ENTITY_ENTITY_TYPE, SakuraFuFuEntityRender::new);
//        EntityRendererRegistry.register(EntityRegistry.FLOWER_FU_FU_ENTITY_ENTITY_TYPE, FlowerFuFuEntityRender::new);
    }
}
