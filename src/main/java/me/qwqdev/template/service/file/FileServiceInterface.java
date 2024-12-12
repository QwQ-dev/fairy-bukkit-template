package me.qwqdev.template.service.file;

import java.io.File;

/**
 * This interface defines methods for managing and retrieving specific file types.
 *
 * @param <T> The file type (e.g., {@link de.leonhard.storage.Yaml}, {@link de.leonhard.storage.Json}, etc.)
 * @author NaerQAQ / 2000000
 * @version 1.0
 * @since 2023/7/29
 */
public interface FileServiceInterface<T> {
    /**
     * Retrieves a specific file type object using a {@link java.io.File} object.
     *
     * @param file                    {@link java.io.File}
     * @param inputStreamFromResource Whether the input stream is obtained from resources
     * @return The specific file type object
     */
    T get(File file, boolean inputStreamFromResource);

    /**
     * Retrieves a specific file type object using a file name and path.
     *
     * @param name                    The file name
     * @param path                    The file path
     * @param inputStreamFromResource Whether the input stream is obtained from resources
     * @return The specific file type object
     */
    T get(String name, String path, boolean inputStreamFromResource);
}
