package org.abstruck.fabric.fufucraft.fufucraft.client.render.entity;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import org.abstruck.fabric.fufucraft.fufucraft.common.entity.fufu.FuFuEntity;
import org.abstruck.fabric.fufucraft.fufucraft.common.entity.model.FuFuEntityModel;

/**
 * @author Astrack
 * @date 2023/7/13
 */
public class FuFuEntityRender extends BaseFuFuEntityRender<FuFuEntity, FuFuEntityModel>{
    public FuFuEntityRender(EntityRendererFactory.Context ctx) {
        super(ctx, new FuFuEntityModel(ctx.getPart(new EntityModelLayer(new Identifier("fufucraft","fufu_entity_model_layer"),"main"))),1.0F);
    }
}
