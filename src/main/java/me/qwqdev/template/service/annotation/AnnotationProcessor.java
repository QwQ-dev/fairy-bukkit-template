package me.qwqdev.template.service.annotation;

import java.lang.annotation.*;

/**
 * Meta-annotation used to mark custom annotation processors.
 *
 * <p>This annotation specifies the type of annotation that the processor handles.
 *
 * @author NaerQAQ
 * @version 1.0
 * @since 2024/1/7
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationProcessor {
    /**
     * The type of annotation that the processor handles.
     *
     * @return The class of the handled annotation
     */
    Class<? extends Annotation> value();
}