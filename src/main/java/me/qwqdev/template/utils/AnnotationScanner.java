package me.qwqdev.template.utils;

import lombok.experimental.UtilityClass;
import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.annotation.Annotation;
import java.util.Set;

/**
 * Utility class for scanning and retrieving classes annotated with a specified annotation.
 *
 * @author NaerQAQ
 * @version 1.0
 * @since 2024/1/7
 */
@UtilityClass
public class AnnotationScanner {
    /**
     * Find annotated classes set.
     *
     * @param basePackage     the base package
     * @param annotationClass the annotation class
     * @return the set
     */
    public Set<Class<?>> findAnnotatedClasses(String basePackage, Class<? extends Annotation> annotationClass) {
        return new Reflections(new ConfigurationBuilder().setUrls(ClasspathHelper.forPackage(basePackage))).getTypesAnnotatedWith(annotationClass);
    }
}