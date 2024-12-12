package me.qwqdev.template;

import io.fairyproject.FairyLaunch;
import io.fairyproject.bootstrap.bukkit.BukkitPlugin;
import io.fairyproject.container.Autowired;
import io.fairyproject.container.InjectableComponent;
import io.fairyproject.plugin.Plugin;
import me.qwqdev.template.service.annotation.AnnotationProcessingService;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * The type Bukkit template plugin.
 *
 * @author QwQ-dev
 * @since 2024-12-12 14:21
 */
@FairyLaunch
@InjectableComponent
public class BukkitTemplatePlugin extends Plugin {
    /**
     * The constant PLUGIN_DIR.
     */
    public static String PLUGIN_DIR;
    /**
     * The constant JAVA_PLUGIN.
     */
    public static JavaPlugin JAVA_PLUGIN;
    @Autowired
    @SuppressWarnings("unused")
    private AnnotationProcessingService annotationProcessingService;

    @Override
    public void onInitial() {
        // Set java plugin instance and dir
        JAVA_PLUGIN = BukkitPlugin.INSTANCE;
        PLUGIN_DIR = JAVA_PLUGIN.getDataFolder().getAbsolutePath();
    }

    @Override
    public void onPluginEnable() {
        // Process annotation
        annotationProcessingService.processAnnotations(getClass().getPackage().getName());
    }

    @Override
    public void onPluginDisable() {
        // ...
    }
}
