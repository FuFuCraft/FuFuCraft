package org.abstruck.fabric.fufucraft.fufucraft.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.abstruck.fabric.fufucraft.fufucraft.common.entity.fufu.FlowerFuFuEntity;
import org.abstruck.fabric.fufucraft.fufucraft.common.entity.fufu.FuFuEntity;
import org.abstruck.fabric.fufucraft.fufucraft.common.entity.fufu.SakuraFuFuEntity;
import org.abstruck.fabric.fufucraft.fufucraft.common.entity.fufu.SnowFuFuEntity;
import org.abstruck.fabric.fufucraft.fufucraft.util.ModUtils;

/**
 * @author Astrack
 * @date 2023/7/12
 */
public class EntityRegistry {
    public static final EntityType<SakuraFuFuEntity> SAKURA_FU_FU_ENTITY_ENTITY_TYPE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ModUtils.MOD_ID,SakuraFuFuEntity.getIdentifier()),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE,SakuraFuFuEntity::new).build()
    );
    public static final EntityType<FuFuEntity> FU_FU_ENTITY_ENTITY_TYPE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ModUtils.MOD_ID,FuFuEntity.getIdentifier()),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE,FuFuEntity::new).build()
    );

    public static final EntityType<SnowFuFuEntity> SNOW_FU_FU_ENTITY_ENTITY_TYPE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ModUtils.MOD_ID,SnowFuFuEntity.getIdentifier()),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE,SnowFuFuEntity::new).build()
    );
    public static final EntityType<FlowerFuFuEntity> FLOWER_FU_FU_ENTITY_ENTITY_TYPE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(ModUtils.MOD_ID,FlowerFuFuEntity.getIdentifier()),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE,FlowerFuFuEntity::new).build()
    );

    public static void register(){
        registerAttributes();
    }

    public static void registerAttributes(){
        DefaultAttributeContainer.Builder builder = MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 0);

        FabricDefaultAttributeRegistry.register(FU_FU_ENTITY_ENTITY_TYPE,builder);
        FabricDefaultAttributeRegistry.register(SAKURA_FU_FU_ENTITY_ENTITY_TYPE,builder);
        FabricDefaultAttributeRegistry.register(SNOW_FU_FU_ENTITY_ENTITY_TYPE,builder);
        FabricDefaultAttributeRegistry.register(FLOWER_FU_FU_ENTITY_ENTITY_TYPE,builder);
    }

}
