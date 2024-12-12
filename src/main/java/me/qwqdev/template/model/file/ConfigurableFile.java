package me.qwqdev.template.model.file;

import de.leonhard.storage.SimplixBuilder;
import de.leonhard.storage.internal.settings.ConfigSettings;
import de.leonhard.storage.internal.settings.DataType;
import de.leonhard.storage.internal.settings.ReloadSettings;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.File;

/**
 * Configuration class for handling a configurable file with Simplix Storage.
 *
 * <p>This class provides methods to create a {@link SimplixBuilder}
 * instance based on the configured file, input stream source, and other settings.
 *
 * <p>From Spring-Bukkit-Plugin (deleted)
 *
 * @author NaerQAQ
 * @version 1.0
 * @since 2024/1/7
 */
@Getter
@Setter
@Accessors(chain = true)
@Builder(setterPrefix = "set")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ConfigurableFile {
    /**
     * The underlying file associated with this configuration.
     */
    private final File file;

    /**
     * Indicates whether the input stream should be obtained from a resource if the file does not exist.
     */
    private final boolean inputStreamFromResource;

    /**
     * Checks if the input stream should be obtained from a resource, considering file existence.
     *
     * @return {@code true} if the input stream should be obtained from a resource, otherwise {@code false}.
     */
    public boolean isInputStreamFromResource() {
        return !file.exists() && inputStreamFromResource;
    }

    /**
     * Retrieves a {@link SimplixBuilder} instance configured based on the settings of this object.
     *
     * @return A {@link SimplixBuilder} instance with appropriate settings
     */
    public SimplixBuilder getSimplixBuilder() {
        SimplixBuilder simplixBuilder = SimplixBuilder.fromFile(file)
                .setDataType(DataType.SORTED)
                .setConfigSettings(ConfigSettings.PRESERVE_COMMENTS)
                .setReloadSettings(ReloadSettings.AUTOMATICALLY);

        return isInputStreamFromResource() ? simplixBuilder.addInputStreamFromResource(file.getName()) : simplixBuilder;
    }
}