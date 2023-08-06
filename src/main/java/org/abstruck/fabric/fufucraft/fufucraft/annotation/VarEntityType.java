package org.abstruck.fabric.fufucraft.fufucraft.annotation;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SpawnGroup;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Astrack
 * @date 2023/7/19
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface VarEntityType {
    @NotNull String value() default "";
    @NotNull SpawnGroup spawnGroup();
}
