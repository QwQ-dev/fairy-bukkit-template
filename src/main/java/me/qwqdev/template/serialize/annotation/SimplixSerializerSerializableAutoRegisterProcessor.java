package me.qwqdev.template.serialize.annotation;

import de.leonhard.storage.internal.serialize.SimplixSerializable;
import de.leonhard.storage.internal.serialize.SimplixSerializer;
import io.fairyproject.log.Log;
import me.qwqdev.template.service.annotation.AnnotationProcessor;
import me.qwqdev.template.service.annotation.CustomAnnotationProcessor;
import me.qwqdev.template.utils.PluginUtils;

/**
 * The type Simplix serializer serializable auto register processor.
 *
 * @author qwq-dev
 * @since 2024-12-13 12:48
 */
@AnnotationProcessor(SimplixSerializerSerializableAutoRegister.class)
public class SimplixSerializerSerializableAutoRegisterProcessor implements CustomAnnotationProcessor {
    /**
     * {@inheritDoc}
     *
     * @param clazz {@inheritDoc}
     * @throws Exception {@inheritDoc}
     */
    @Override
    public void process(Class<?> clazz) throws Exception {
        // noinspection rawtypes
        SimplixSerializer.registerSerializable((SimplixSerializable) clazz.getDeclaredConstructor().newInstance());
        Log.info("[AnnotationProcessor] %s serializable registered.", clazz.getName());
    }

    /**
     * {@inheritDoc}
     *
     * @param clazz     {@inheritDoc}
     * @param exception {@inheritDoc}
     */
    @Override
    public void exception(Class<?> clazz, Exception exception) {
        Log.error("Error registering serializer", exception);
        PluginUtils.disablePlugin();
    }
}
