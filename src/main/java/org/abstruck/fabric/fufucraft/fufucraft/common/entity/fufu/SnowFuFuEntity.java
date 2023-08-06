package org.abstruck.fabric.fufucraft.fufucraft.common.entity.fufu;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

/**
 * @author Astrack
 * @date 2023/7/12
 */
public class SnowFuFuEntity extends FuFuEntity{
    public SnowFuFuEntity(EntityType<? extends BaseFuFuEntity> entityType, World world) {
        super(entityType, world);
    }

    public static String getIdentifier() {
        return "snow_fufu_entity";
    }

    @Override
    public void setBaby(boolean baby) {
    }
    public static boolean isValidNaturalSpawn(EntityType<? extends AnimalEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return FuFuEntity.isValidNaturalSpawn(type,world,spawnReason,pos,random);
    }
}
