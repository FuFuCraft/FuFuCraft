package org.abstruck.fabric.fufucraft.fufucraft.common.event.handler;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import org.abstruck.fabric.fufucraft.fufucraft.annotation.EventHandler;
import org.abstruck.fabric.fufucraft.fufucraft.registry.ItemRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Astrack
 * @date 2023/7/13
 */
@Component
public class ItemGroupModifierHandler implements ItemGroupEvents.ModifyEntries{
    @Autowired
    Item riceSeedItem;
    @Autowired
    Item smallPackOfRiceItem;
    @Autowired
    Item largePackOfRiceItem;

    public ItemGroupModifierHandler(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(this);
    }

    @Override
    public void modifyEntries(FabricItemGroupEntries entries) {
        entries.add(riceSeedItem);
        entries.add(smallPackOfRiceItem);
        entries.add(largePackOfRiceItem);
    }

//    static {
//       ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(new ItemGroupModifierHandler());
//    }
}
