package org.abstruck.fabric.fufucraft.fufucraft.client.render.entity;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import org.abstruck.fabric.fufucraft.fufucraft.common.entity.fufu.SnowFuFuEntity;
import org.abstruck.fabric.fufucraft.fufucraft.common.entity.model.SnowFuFuEntityModel;

/**
 * @author Astrack
 * @date 2023/7/13
 */
public class SnowFuFuEntityRender extends BaseFuFuEntityRender<SnowFuFuEntity, SnowFuFuEntityModel> {
    public SnowFuFuEntityRender(EntityRendererFactory.Context ctx) {
        super(ctx, new SnowFuFuEntityModel(ctx.getPart(new EntityModelLayer(new Identifier("fufucraft","snow_fufu_entity_model_layer"),"main"))),1.0F);
    }
}
