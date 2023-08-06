package org.abstruck.fabric.fufucraft.fufucraft.common.event.handler;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableSource;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.loot.LootManager;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.condition.SurvivesExplosionLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import org.abstruck.fabric.fufucraft.fufucraft.registry.ItemRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author Astrack
 * @date 2023/7/13
 */
@Component
public class LootTableAdderHandler implements LootTableEvents.Modify{
    @Autowired
    Item riceSeedItem;
    @Autowired
    Item springOnionSeed;
    public LootTableAdderHandler(){
        LootTableEvents.MODIFY.register(this);
    }

    @Override
    public void modifyLootTable(ResourceManager resourceManager, LootManager lootManager, Identifier id, LootTable.Builder tableBuilder, LootTableSource source) {
        if (!Blocks.GRASS.getLootTableId().equals(id)) {
            return;
        }
        LootPool.Builder riceSeed = new LootPool.Builder()
                .with(ItemEntry.builder(riceSeedItem))
                .conditionally(RandomChanceLootCondition.builder(0.03F))
                .conditionally(SurvivesExplosionLootCondition.builder());
        LootPool.Builder springOnionSeedLootPool = new LootPool.Builder()
                .with(ItemEntry.builder(springOnionSeed))
                .conditionally(RandomChanceLootCondition.builder(0.01F))
                .conditionally(SurvivesExplosionLootCondition.builder());
        tableBuilder.pool(riceSeed);
        tableBuilder.pool(springOnionSeedLootPool);
    }

//    static {
//        LootTableEvents.MODIFY.register(new LootTableAdderHandler());
//    }
}
