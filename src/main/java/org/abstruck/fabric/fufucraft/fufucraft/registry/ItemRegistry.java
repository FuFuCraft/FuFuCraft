package org.abstruck.fabric.fufucraft.fufucraft.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.abstruck.fabric.fufucraft.fufucraft.common.item.food.LargeBowlOfRice;
import org.abstruck.fabric.fufucraft.fufucraft.common.item.food.SmallBowlOfRice;
import org.abstruck.fabric.fufucraft.fufucraft.common.item.plant.*;
import org.abstruck.fabric.fufucraft.fufucraft.util.RegistryUtils;

/**
 * @author Astrack
 * @date 2023/7/10
 */
public class ItemRegistry {
    private static final FuelRegistry FUEL_REGISTRY = FuelRegistry.INSTANCE;
    private static final CompostingChanceRegistry  COMPOSTING_CHANCE_REGISTRY = CompostingChanceRegistry.INSTANCE;

//    public static final Item RICE_SEED_ITEM = new RiceSeedItem(new FabricItemSettings());
//    public static final Item SPRING_ONION_SEED = new SpringOnionSeed(new FabricItemSettings());
    public static final Item SMALL_PACK_OF_RICE = new SmallPackOfRiceItem(new FabricItemSettings());
    public static final Item LARGE_PACK_OF_RICE = new LargePackOfRiceItem(new FabricItemSettings());
    public static final Item SMALL_BOWL_OF_RICE = new SmallBowlOfRice();
    public static final Item LARGE_BOWL_OF_RICE = new LargeBowlOfRice();
    public static final Item SPRING_ONION = new SpringOnion();
    public static final Item SAUCED_SPRING_ONION = new SaucedSpringOnion();

    private static void fuelRegister(){
    }
    private static void compostingRegister(){
//        COMPOSTING_CHANCE_REGISTRY.add(RICE_SEED_ITEM,1.0F);
        COMPOSTING_CHANCE_REGISTRY.add(SMALL_PACK_OF_RICE,2.0F);
        COMPOSTING_CHANCE_REGISTRY.add(LARGE_PACK_OF_RICE,18.0F);
    }
    private static void itemRegister(){
//        registerSingleItem(RICE_SEED_ITEM);
        registerSingleItem(SMALL_PACK_OF_RICE);
        registerSingleItem(LARGE_PACK_OF_RICE);
        registerSingleItem(SMALL_BOWL_OF_RICE);
        registerSingleItem(LARGE_BOWL_OF_RICE);
//        registerSingleItem(SPRING_ONION_SEED);
        registerSingleItem(SPRING_ONION);
        registerSingleItem(SAUCED_SPRING_ONION);
    }
    private static void registerSingleItem(Item item){
        if (!(item instanceof IdentifierRequired identifierRequired)){
            throw new RuntimeException(item.getTranslationKey()+" 注册失败");
        }
        Registry.register(Registries.ITEM,RegistryUtils.getFullIdentifier(identifierRequired),item);
    }
    public static void register() {
        itemRegister();
        fuelRegister();
    }
}
