package me.qwqdev.template.service.file;

import de.leonhard.storage.Yaml;
import io.fairyproject.container.InjectableComponent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import me.qwqdev.template.model.file.ConfigurableFile;
import me.qwqdev.template.utils.IOUtils;

import java.io.File;

/**
 * This class implements {@link FileServiceInterface} for managing Yaml files using a singleton pattern.
 * It provides functionality to retrieve Yaml configurations from files.
 *
 * @see FileServiceInterface
 *
 * @author NaerQAQ
 * @version 1.0
 * @since 2023/7/29
 */
@InjectableComponent
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class YamlFileService implements FileServiceInterface<Yaml> {
    /**
     * {@inheritDoc}
     *
     * @param file                    {@inheritDoc}
     * @param inputStreamFromResource {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Yaml get(File file, boolean inputStreamFromResource) {
        return ConfigurableFile.builder()
                .setFile(file)
                .setInputStreamFromResource(inputStreamFromResource)
                .build()
                .getSimplixBuilder()
                .createYaml();
    }

    /**
     * {@inheritDoc}
     *
     * @param name                    {@inheritDoc}
     * @param path                    {@inheritDoc}
     * @param inputStreamFromResource {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Yaml get(String name, String path, boolean inputStreamFromResource) {
        return get(new File(path, IOUtils.getFinalFileName(name, ".yml")), inputStreamFromResource);
    }
}