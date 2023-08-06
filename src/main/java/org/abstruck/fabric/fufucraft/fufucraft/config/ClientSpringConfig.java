package org.abstruck.fabric.fufucraft.fufucraft.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Astrack
 * @date 2023/7/19
 */
@Configuration
@Import(CommonSpringConfig.class)
@ComponentScan("org.abstruck.fabric.fufucraft.fufucraft.client")
public class ClientSpringConfig {
}
