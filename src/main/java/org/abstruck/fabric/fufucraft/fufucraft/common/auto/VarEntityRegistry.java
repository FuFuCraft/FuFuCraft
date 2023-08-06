package org.abstruck.fabric.fufucraft.fufucraft.common.auto;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.abstruck.fabric.fufucraft.fufucraft.annotation.VarEntityType;
import org.abstruck.fabric.fufucraft.fufucraft.util.ModUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Astrack
 * @date 2023/7/19
 */
@Component
public class VarEntityRegistry {
    @Autowired
    Logger logger;

    @EventListener(VarRegistryEvent.class)
    public void onEntityTypeRegistry(VarRegistryEvent event){
        event.getFields().stream()
                .filter(f -> f.isAnnotationPresent(VarEntityType.class))
                .forEach(f -> {
                    VarEntityType annotation = f.getAnnotation(VarEntityType.class);
                    SpawnGroup spawnGroup = annotation.spawnGroup();

                    String identifier = annotation.value();

                    if (identifier.isEmpty()) {
                        identifier = f.getName().toLowerCase();
                    }

                    EntityType<Entity> entityType = Registry.register(
                            Registries.ENTITY_TYPE,
                            new Identifier(ModUtils.MOD_ID, identifier),
                            FabricEntityTypeBuilder.create(spawnGroup, (type, world) -> {
                                try {
                                    return (Entity) f.get(event.getBean()).getClass().getDeclaredConstructor(EntityType.class, World.class).newInstance(type, world);
                                } catch (Exception e) {
                                    logger.error(e.getLocalizedMessage());
                                }
                                return null;
                            }).build()
                    );

                    try {
                        f.set(event.getBean(),entityType);
                    } catch (Exception e) {
                        logger.error(e.getLocalizedMessage());
                    }
                });
    }
}
