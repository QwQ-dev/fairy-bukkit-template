package me.qwqdev.template.service.file;

import de.leonhard.storage.Yaml;
import io.fairyproject.container.DependsOn;
import io.fairyproject.container.InjectableComponent;
import lombok.Getter;
import me.qwqdev.template.BukkitTemplatePlugin;

/**
 * A service for managing the main configuration of the plugin.
 *
 * <p>This class depends on {@link YamlFileService} for handling YAML file operations.
 *
 * @author qwq-dev
 * @see YamlFileService
 * @see FileServiceInterface
 * @since 2024-12-06 20:41
 */
@InjectableComponent
@DependsOn(YamlFileService.class)
public class ConfigurationService {
    @Getter
    private final Yaml config;

    @SuppressWarnings("unused")
    private final FileServiceInterface<Yaml> yamlFileService;

    /**
     * Instantiates a new Configuration service.
     *
     * @param yamlFileService the yaml file service
     */
    @SuppressWarnings("unused")
    public ConfigurationService(YamlFileService yamlFileService) {
        this.yamlFileService = yamlFileService;
        this.config = yamlFileService.get("config", BukkitTemplatePlugin.PLUGIN_DIR, true);
    }
}
