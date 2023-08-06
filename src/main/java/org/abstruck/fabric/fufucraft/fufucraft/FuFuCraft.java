package org.abstruck.fabric.fufucraft.fufucraft;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import org.abstruck.fabric.fufucraft.fufucraft.config.CommonSpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Astrack
 * @date 2023/7/10
 */

//TODO fufu models
//TODO fufu renders
public class FuFuCraft implements ModInitializer, DataGeneratorEntrypoint {

    @Override
    public void onInitialize() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CommonSpringConfig.class);
    }

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
    }
}
