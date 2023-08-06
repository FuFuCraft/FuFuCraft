package org.abstruck.fabric.fufucraft.fufucraft.common.auto;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.abstruck.fabric.fufucraft.fufucraft.annotation.CompostingChance;
import org.abstruck.fabric.fufucraft.fufucraft.annotation.RegistryEntry;
import org.abstruck.fabric.fufucraft.fufucraft.annotation.VarItem;
import org.abstruck.fabric.fufucraft.fufucraft.util.ModUtils;
import org.slf4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Astrack
 * @date 2023/7/19
 */
@Component
public class AutoVarRegistry implements BeanPostProcessor, BeanFactoryAware , ApplicationEventPublisherAware {
    @Autowired
    private Logger logger;
    private BeanFactory beanFactory;
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        if (!clazz.isAnnotationPresent(RegistryEntry.class)){
            return bean;
        }

        Set<Field> fields = Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toSet());
        VarRegistryEvent event = beanFactory.getBean(VarRegistryEvent.class,this, bean, fields);
        applicationEventPublisher.publishEvent(event);

        return bean;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
