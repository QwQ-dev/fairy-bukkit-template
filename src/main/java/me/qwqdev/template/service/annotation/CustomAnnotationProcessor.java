package me.qwqdev.template.service.annotation;

/**
 * Interface for custom annotation processors.
 *
 * <p>Implementations of this interface should handle the processing of classes annotated with a specific annotation.
 *
 * @author NaerQAQ
 * @version 1.0
 * @since 2024 /1/7
 */
public interface CustomAnnotationProcessor {
    /**
     * Invoked before processing a class.
     *
     * @param clazz the class to be processed
     */
    void before(Class<?> clazz);

    /**
     * Handles the processing of a class annotated with a specific annotation.
     *
     * @param clazz The class to be processed
     * @throws Exception If an error occurs during processing
     */
    void process(Class<?> clazz) throws Exception;

    /**
     * Handles an exception that occurred during the processing of a class.
     *
     * @param clazz     The class that encountered an exception during processing
     * @param exception The exception that occurred
     */
    void exception(Class<?> clazz, Exception exception);

    /**
     * Invoked after processing a class.
     *
     * @param clazz the class that was processed
     */
    void after(Class<?> clazz);

    /**
     * Invoked in the "finally" block after processing a class, regardless of success or failure.
     *
     * <p>This method can be used for cleanup, logging, or other final operations that must run after processing
     * has completed, whether or not an exception was thrown.
     *
     * @param clazz the class that was processed
     */
    void finallyAfter(Class<?> clazz);
}