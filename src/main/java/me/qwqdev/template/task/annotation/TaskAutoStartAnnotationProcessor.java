package me.qwqdev.template.task.annotation;

import io.fairyproject.container.Containers;
import io.fairyproject.log.Log;
import me.qwqdev.template.service.annotation.AnnotationProcessor;
import me.qwqdev.template.service.annotation.CustomAnnotationProcessor;
import me.qwqdev.template.task.TaskInterface;
import me.qwqdev.template.utils.PluginUtils;

/**
 * The type Task auto start annotation processor.
 *
 * @author qwq-dev
 * @since 2024-12-14 13:47
 */
@AnnotationProcessor(TaskAutoStartAnnotation.class)
public class TaskAutoStartAnnotationProcessor implements CustomAnnotationProcessor {
    /**
     * {@inheritDoc}
     *
     * @param clazz {@inheritDoc}
     */
    @Override
    public void process(Class<?> clazz) {
        ((TaskInterface) Containers.get(clazz)).start();
        Log.info("[AnnotationProcessor] {} task started.", clazz.getName());
    }

    /**
     * {@inheritDoc}
     *
     * @param clazz     {@inheritDoc}
     * @param exception {@inheritDoc}
     */
    @Override
    public void exception(Class<?> clazz, Exception exception) {
        Log.error("Error starting task", exception);
        PluginUtils.disablePlugin();
    }
}
