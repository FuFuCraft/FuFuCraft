package org.abstruck.fabric.fufucraft.fufucraft.client.render.entity;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import org.abstruck.fabric.fufucraft.fufucraft.common.entity.fufu.SakuraFuFuEntity;
import org.abstruck.fabric.fufucraft.fufucraft.common.entity.model.SakuraFuFuEntityModel;

/**
 * @author Astrack
 * @date 2023/7/13
 */
public class SakuraFuFuEntityRender extends BaseFuFuEntityRender<SakuraFuFuEntity, SakuraFuFuEntityModel> {
    public SakuraFuFuEntityRender(EntityRendererFactory.Context ctx) {
        super(ctx, new SakuraFuFuEntityModel(ctx.getPart(new EntityModelLayer(new Identifier("fufucraft","sakura_fufu_entity_model_layer"),"main"))),1.0F);
    }
}
