package org.abstruck.fabric.fufucraft.fufucraft.config;

import com.mojang.logging.LogUtils;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Astrack
 * @date 2023/7/18
 */
@Configuration
@ComponentScan("org.abstruck.fabric.fufucraft.fufucraft.common")
public class CommonSpringConfig {
    @Bean
    public Item.Settings commonFabricItemSettings(){
        return new FabricItemSettings();
    }
    @Bean
    public AbstractBlock.Settings commonBlockSettings(){
        return null;
    }
    @Bean
    public AbstractBlock.Settings commonCropSettings(){
        return FabricBlockSettings.copy(Blocks.WHEAT);
    }
    @Bean
    public Logger logger(){
        return LogUtils.getLogger();
    }
}
