package org.abstruck.fabric.fufucraft.fufucraft.annotation;

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Astrack
 * @date 2023/7/18   
*/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventHandler {
    @NotNull Class<?> clazz();
    @NotNull String fieldName();
}
