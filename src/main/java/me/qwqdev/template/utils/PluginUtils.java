package me.qwqdev.template.utils;

import lombok.experimental.UtilityClass;
import me.qwqdev.template.BukkitTemplatePlugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * The type Plugin utils.
 *
 * @author qwq -dev
 * @since 2024 -12-14 13:49
 */
@UtilityClass
public class PluginUtils {
    /**
     * Disable plugin.
     */
    public static void disablePlugin() {
        // disable plugin
        JavaPlugin javaPlugin = BukkitTemplatePlugin.JAVA_PLUGIN;
        javaPlugin.getServer().getPluginManager().disablePlugin(javaPlugin);
    }
}
