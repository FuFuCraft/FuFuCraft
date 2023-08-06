package org.abstruck.fabric.fufucraft.fufucraft.util;

import net.minecraft.util.Identifier;
import org.abstruck.fabric.fufucraft.fufucraft.registry.IdentifierRequired;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * @author Astrack
 * @date 2023/7/10
 */
public class RegistryUtils {
    @Contract("_ -> new")
    public static @NotNull Identifier getFullIdentifier(@NotNull IdentifierRequired object) {
        return new Identifier(ModUtils.MOD_ID, object.getIdentifier());
    }

    public static @NotNull Identifier getFullIdentifier(@NotNull String id) {
        return new Identifier(ModUtils.MOD_ID, id);
    }
}