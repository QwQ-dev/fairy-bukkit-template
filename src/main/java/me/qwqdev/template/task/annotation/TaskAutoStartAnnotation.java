package me.qwqdev.template.task.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The interface Task auto start annotation.
 *
 * @author qwq-dev
 * @since 2024-12-14 13:47
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TaskAutoStartAnnotation {
}
