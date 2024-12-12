package me.qwqdev.template.service.annotation;

import io.fairyproject.container.InjectableComponent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import me.qwqdev.template.utils.AnnotationScanner;

import java.lang.annotation.Annotation;

/**
 * Service implementation for processing annotations using custom annotation processors.
 *
 * @author NaerQAQ
 * @version 1.0
 * @since 2024/1/7
 */
@InjectableComponent
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AnnotationProcessingServiceImpl implements AnnotationProcessingService {
    /**
     * {@inheritDoc}
     *
     * @param basePackage  {@inheritDoc}
     */
    @Override
    public void processAnnotations(String basePackage) {
        AnnotationScanner.findAnnotatedClasses(basePackage, AnnotationProcessor.class)
                .stream()
                .filter(CustomAnnotationProcessor.class::isAssignableFrom)
                .forEach(handlerClass -> processAnnotations(basePackage, handlerClass.asSubclass(CustomAnnotationProcessor.class)));
    }

    /**
     * {@inheritDoc}
     *
     * @param basePackage  {@inheritDoc}
     * @param handlerClass {@inheritDoc}
     */
    @Override
    @SneakyThrows
    public void processAnnotations(String basePackage, Class<? extends CustomAnnotationProcessor> handlerClass) {
        CustomAnnotationProcessor customAnnotationProcessor = handlerClass.getDeclaredConstructor().newInstance();

        AnnotationProcessor annotationProcessingService =
                handlerClass.getAnnotation(AnnotationProcessor.class);

        Class<? extends Annotation> annotationClazz = annotationProcessingService.value();

        AnnotationScanner.findAnnotatedClasses(basePackage, annotationClazz).forEach(aClass -> {
            try {
                customAnnotationProcessor.after(annotationClazz);
                customAnnotationProcessor.process(aClass);
                customAnnotationProcessor.before(annotationClazz);
            } catch (Exception exception) {
                customAnnotationProcessor.exception(aClass, exception);
            } finally {
                customAnnotationProcessor.finallyAfter(annotationClazz);
            }
        });
    }
}