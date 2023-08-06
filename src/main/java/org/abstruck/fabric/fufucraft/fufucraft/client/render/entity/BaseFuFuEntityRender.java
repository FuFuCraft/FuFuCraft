package org.abstruck.fabric.fufucraft.fufucraft.client.render.entity;

import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import org.abstruck.fabric.fufucraft.fufucraft.common.entity.fufu.BaseFuFuEntity;
import org.abstruck.fabric.fufucraft.fufucraft.common.entity.model.BaseFuFuEntityModel;

/**
 * @author Astrack
 * @date 2023/7/13
 */
public abstract class BaseFuFuEntityRender<E extends BaseFuFuEntity,M extends BaseFuFuEntityModel<E>> extends BipedEntityRenderer<E,M> {
    public BaseFuFuEntityRender(EntityRendererFactory.Context ctx, M model, float shadowRadius) {
        super(ctx, model, shadowRadius);
    }

    @Override
    public Identifier getTexture(E entity) {
        return new Identifier("fufucraft","noexist.png");
    }
}
