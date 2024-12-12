package me.qwqdev.template.service.annotation;

/**
 * Service interface for processing annotations using custom annotation processors.
 *
 * @author NaerQAQ
 * @version 1.0
 * @since 2024/1/7
 */
public interface AnnotationProcessingService {
    /**
     * Processes annotations within the specified base package using default annotation processors.
     *
     * @param basePackage The base package to scan for annotated classes
     */
    void processAnnotations(String basePackage);

    /**
     * Processes annotations within the specified base package using a specific annotation processor.
     *
     * @param basePackage  The base package to scan for annotated classes
     * @param handlerClass The class of the custom annotation processor
     */
    void processAnnotations(String basePackage, Class<? extends CustomAnnotationProcessor> handlerClass);
}
