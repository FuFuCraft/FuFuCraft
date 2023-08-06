package org.abstruck.fabric.fufucraft.fufucraft.common.entity.fufu;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

/**
 * @author Astrack
 * @date 2023/7/12
 */
public class FuFuEntity extends BaseFuFuEntity {
    public FuFuEntity(EntityType<? extends BaseFuFuEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public int tameRateDenominator() {
        return 22;
    }

    @Override
    protected void effect() {
        if (tickCount%(5*20)==0){
            if (isTamed()){
                if (isBaby()){
                    if (getOwner() != null){
                        if (squaredDistanceTo(getOwner()) <= 16*16) {
                            getOwner().addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,8,1,true,false,false),this);
                        }
                    }
                } else {
                    getWorld().getPlayers().stream()
                            .filter(p -> squaredDistanceTo(p) <= 32*32)
                            .forEach(p -> p.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,8,2,true,false,false),this));
                }
            }
        }
    }

    public static String getIdentifier() {
        return "fufu_entity";
    }

    public static boolean isValidNaturalSpawn(EntityType<? extends AnimalEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        boolean canAnimalSpawn = AnimalEntity.isValidNaturalSpawn(type,world,spawnReason,pos,random);
        if (spawnReason == SpawnReason.NATURAL && canAnimalSpawn) {
            RegistryEntry<Biome> biomeRegistryEntry = world.getBiome(pos);
            if (biomeRegistryEntry.matchesKey(BiomeKeys.PLAINS) || biomeRegistryEntry.matchesKey(BiomeKeys.SUNFLOWER_PLAINS)) {
                return random.nextInt(1000) == 0;
            }else {
                return false;
            }
        }
        return canAnimalSpawn;
    }
}
