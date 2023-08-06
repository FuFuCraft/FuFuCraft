package org.abstruck.fabric.fufucraft.fufucraft.client.render.entity;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import org.abstruck.fabric.fufucraft.fufucraft.common.entity.fufu.FlowerFuFuEntity;
import org.abstruck.fabric.fufucraft.fufucraft.common.entity.model.FlowerFuFuEntityModel;

/**
 * @author Astrack
 * @date 2023/7/13
 */
public class FlowerFuFuEntityRender extends BaseFuFuEntityRender<FlowerFuFuEntity, FlowerFuFuEntityModel> {
    public FlowerFuFuEntityRender(EntityRendererFactory.Context ctx) {
        super(ctx, new FlowerFuFuEntityModel(ctx.getPart(new EntityModelLayer(new Identifier("fufucraft","flower_fufu_entity_model_layer"),"main"))),1.0F);
    }
}
