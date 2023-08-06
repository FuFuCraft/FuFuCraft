package org.abstruck.fabric.fufucraft.fufucraft.common.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.abstruck.fabric.fufucraft.fufucraft.annotation.RegistryEntry;
import org.abstruck.fabric.fufucraft.fufucraft.annotation.VarEntityType;
import org.abstruck.fabric.fufucraft.fufucraft.common.entity.fufu.FlowerFuFuEntity;
import org.abstruck.fabric.fufucraft.fufucraft.common.entity.fufu.FuFuEntity;
import org.abstruck.fabric.fufucraft.fufucraft.common.entity.fufu.SakuraFuFuEntity;
import org.abstruck.fabric.fufucraft.fufucraft.common.entity.fufu.SnowFuFuEntity;
import org.abstruck.fabric.fufucraft.fufucraft.util.ModUtils;
import org.springframework.stereotype.Component;

/**
 * @author Astrack
 * @date 2023/7/19
 */
@Component
@RegistryEntry
public class EntityTypeRegistry {
    @VarEntityType(spawnGroup = SpawnGroup.CREATURE)
    public EntityType<SakuraFuFuEntity> SAKURA_FU_FU_ENTITY;
    @VarEntityType(spawnGroup = SpawnGroup.CREATURE)
    public EntityType<FuFuEntity> FU_FU_ENTITY;
    @VarEntityType(spawnGroup = SpawnGroup.CREATURE)
    public EntityType<SnowFuFuEntity> SNOW_FU_FU_ENTITY;
    @VarEntityType(spawnGroup = SpawnGroup.CREATURE)
    public EntityType<FlowerFuFuEntity> FLOWER_FU_FU_ENTITY;
}
