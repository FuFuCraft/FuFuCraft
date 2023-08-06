package org.abstruck.fabric.fufucraft.fufucraft.common.entity.model;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import org.abstruck.fabric.fufucraft.fufucraft.common.entity.fufu.BaseFuFuEntity;

/**
 * @author Astrack
 * @date 2023/7/13
 */
public abstract class BaseFuFuEntityModel<E extends BaseFuFuEntity> extends BipedEntityModel<E> {
    public BaseFuFuEntityModel(ModelPart root) {
        super(root);
    }
}
