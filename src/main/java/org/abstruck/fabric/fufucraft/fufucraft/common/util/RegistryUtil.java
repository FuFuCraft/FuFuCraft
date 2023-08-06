package org.abstruck.fabric.fufucraft.fufucraft.common.util;

import org.springframework.stereotype.Component;

/**
 * @author Astrack
 * @date 2023/7/18
 */
@Component
public class RegistryUtil {
    public String camel2Snake(String camel){
        String result;
        result = camel.replaceAll("[A-Z]","_$0");
        result = result.toLowerCase();
        if (result.charAt(0) == '_'){
            result = result.substring(1);
        }
        return result;
    }
}
