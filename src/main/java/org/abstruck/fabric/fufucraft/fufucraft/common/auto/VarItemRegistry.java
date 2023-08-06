package org.abstruck.fabric.fufucraft.fufucraft.common.auto;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.abstruck.fabric.fufucraft.fufucraft.annotation.CompostingChance;
import org.abstruck.fabric.fufucraft.fufucraft.annotation.VarItem;
import org.abstruck.fabric.fufucraft.fufucraft.util.ModUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author Astrack
 * @date 2023/7/19
 */
@Component
public class VarItemRegistry {
    @Autowired
    private Logger logger;

    @EventListener(VarRegistryEvent.class)
    public void onRegistryItem(VarRegistryEvent event){
        event.getFields().stream()
                .filter(f -> f.isAnnotationPresent(VarItem.class))
                .forEach(f -> {
                    VarItem annotation = f.getAnnotation(VarItem.class);
                    String identifier = annotation.value();
                    if (identifier.isEmpty()) {
                        identifier = f.getName().toLowerCase();
                    }
                    try {
                        Registry.register(
                                Registries.ITEM,
                                new Identifier(ModUtils.MOD_ID, identifier),
                                (Item) f.get(event.getBean())
                        );
                    } catch (Exception e) {
                        logger.error(e.getLocalizedMessage());
                    }
                });
    }

    @EventListener(VarRegistryEvent.class)
    public void onRegistryCompostingChance(VarRegistryEvent event){
        event.getFields().stream()
                .filter(f -> f.isAnnotationPresent(CompostingChance.class))
                .forEach(f -> {
                    CompostingChance annotation = f.getAnnotation(CompostingChance.class);
                    float chance = annotation.value();
                    try {
                        CompostingChanceRegistry.INSTANCE.add((ItemConvertible) f.get(event.getBean()),chance);
                    } catch (Exception e) {
                        logger.error(e.getLocalizedMessage());
                    }
                });
    }
}
