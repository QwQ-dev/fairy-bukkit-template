package me.qwqdev.template.service.file;

import de.leonhard.storage.Json;
import io.fairyproject.container.InjectableComponent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import me.qwqdev.template.model.file.ConfigurableFile;
import me.qwqdev.template.utils.IOUtils;

import java.io.File;

/**
 * This class implements {@link FileServiceInterface} for managing Json files using a singleton pattern.
 * It provides functionality to retrieve Json configurations from files.
 *
 * @author NaerQAQ
 * @version 1.0
 * @see FileServiceInterface
 * @since 2023/7/29
 */
@InjectableComponent
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonFileService implements FileServiceInterface<Json> {
    /**
     * {@inheritDoc}
     *
     * @param file                    {@inheritDoc}
     * @param inputStreamFromResource {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Json get(File file, boolean inputStreamFromResource) {
        return ConfigurableFile.builder()
                .setFile(file)
                .setInputStreamFromResource(inputStreamFromResource)
                .build()
                .getSimplixBuilder()
                .createJson();
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
    public Json get(String name, String path, boolean inputStreamFromResource) {
        return get(new File(path, IOUtils.getFinalFileName(name, ".json")), inputStreamFromResource);
    }
}