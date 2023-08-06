package org.abstruck.fabric.fufucraft.fufucraft.common.auto;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.abstruck.fabric.fufucraft.fufucraft.annotation.ABlock;
import org.abstruck.fabric.fufucraft.fufucraft.annotation.AItem;
import org.abstruck.fabric.fufucraft.fufucraft.common.util.RegistryUtil;
import org.abstruck.fabric.fufucraft.fufucraft.util.ModUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author Astrack
 * @date 2023/7/18
 */
@Component
public class AutoBlockRegistry implements BeanPostProcessor {
    @Autowired
    RegistryUtil registryUtil;
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (!(bean instanceof Block)){
            return bean;
        }

        Class<?> clazz = bean.getClass();

        if (clazz.isAnnotationPresent(ABlock.class)){
            ABlock annotation = clazz.getAnnotation(ABlock.class);
            String identifier = annotation.value();

            if (identifier.isEmpty()){
                identifier = registryUtil.camel2Snake(clazz.getSimpleName());
            }

            System.out.println(identifier);

            Registry.register(
                    Registries.BLOCK,
                    new Identifier(ModUtils.MOD_ID,identifier),
                    (Block) bean
            );
        }

        return bean;
    }
}
