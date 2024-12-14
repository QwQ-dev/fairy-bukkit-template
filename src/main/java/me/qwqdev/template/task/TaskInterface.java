package me.qwqdev.template.task;

import io.fairyproject.mc.scheduler.MCScheduler;
import io.fairyproject.scheduler.ScheduledTask;
import io.fairyproject.scheduler.repeat.RepeatPredicate;
import io.fairyproject.scheduler.response.TaskResponse;

import java.time.Duration;
import java.util.concurrent.Callable;

/**
 * TaskInterface provides a higher-level abstraction for scheduling tasks
 * using the {@link io.fairyproject.mc.scheduler.MCScheduler}. It supports delayed tasks, periodic tasks,
 * and tasks with custom repeat predicates.
 *
 * <p>This interface simplifies task scheduling by providing methods that directly mirror
 * those in {@link io.fairyproject.mc.scheduler.MCScheduler} and {@link io.fairyproject.scheduler.Scheduler}, with consistent naming and parameter orders.
 *
 * <p>Additional utility methods for scheduling tasks with {@link java.time.Duration} and thread checks are included.
 *
 * @author qwq-dev
 * @since 2024-12-14 12:30
 */
public interface TaskInterface {

    /**
     * Starts the task. Implementations should define the logic of the task.
     *
     * @return a {@link io.fairyproject.scheduler.ScheduledTask} representing the started task
     */
    ScheduledTask<?> start();

    /**
     * Provides the MCScheduler instance used for task scheduling.
     *
     * @return the {@link io.fairyproject.mc.scheduler.MCScheduler} instance
     */
    MCScheduler getMCScheduler();

    /**
     * Get scheduled task.
     *
     * @return a {@link io.fairyproject.scheduler.ScheduledTask} representing the started task
     */
    ScheduledTask<?> getScheduledTask();

    /**
     * Schedule a one-time task with a specified delay in ticks.
     *
     * @param task       the task to be executed
     * @param delayTicks the delay in ticks before the task is executed
     * @return a {@link io.fairyproject.scheduler.ScheduledTask} representing the scheduled task
     */
    default ScheduledTask<?> schedule(Runnable task, long delayTicks) {
        return getMCScheduler().schedule(task, delayTicks);
    }

    /**
     * Schedule a periodic task with a fixed delay and interval in ticks.
     *
     * @param task          the task to be executed
     * @param delayTicks    the initial delay in ticks before the first execution
     * @param intervalTicks the interval in ticks between consecutive executions
     * @return a {@link io.fairyproject.scheduler.ScheduledTask} representing the scheduled task
     */
    default ScheduledTask<?> scheduleAtFixedRate(Runnable task, long delayTicks, long intervalTicks) {
        return getMCScheduler().scheduleAtFixedRate(task, delayTicks, intervalTicks);
    }

    /**
     * Schedule a periodic task with a fixed delay and interval in ticks, and a custom repeat predicate.
     *
     * @param task          the task to be executed
     * @param delayTicks    the initial delay in ticks before the first execution
     * @param intervalTicks the interval in ticks between consecutive executions
     * @param predicate     the {@link io.fairyproject.scheduler.repeat.RepeatPredicate} to control task repetition
     * @return a {@link io.fairyproject.scheduler.ScheduledTask} representing the scheduled task
     */
    default ScheduledTask<?> scheduleAtFixedRate(Runnable task, long delayTicks, long intervalTicks, RepeatPredicate<?> predicate) {
        return getMCScheduler().scheduleAtFixedRate(task, delayTicks, intervalTicks, predicate);
    }

    /**
     * Schedule a callable task with a specified delay in ticks.
     *
     * @param task       the callable task to be executed
     * @param delayTicks the delay in ticks before the task is executed
     * @param <R>        the return type of the callable task
     * @return a {@link io.fairyproject.scheduler.ScheduledTask} representing the scheduled task
     */
    default <R> ScheduledTask<R> schedule(Callable<R> task, long delayTicks) {
        return getMCScheduler().schedule(task, delayTicks);
    }

    /**
     * Schedule a periodic callable task with a fixed delay and interval in ticks.
     *
     * @param task          the callable task to be executed
     * @param delayTicks    the initial delay in ticks before the first execution
     * @param intervalTicks the interval in ticks between consecutive executions
     * @param <R>           the return type of the callable task
     * @return a {@link io.fairyproject.scheduler.ScheduledTask} representing the scheduled task
     */
    default <R> ScheduledTask<R> scheduleAtFixedRate(Callable<TaskResponse<R>> task, long delayTicks, long intervalTicks) {
        return getMCScheduler().scheduleAtFixedRate(task, delayTicks, intervalTicks);
    }

    /**
     * Schedule a periodic callable task with a fixed delay and interval in ticks, and a custom repeat predicate.
     *
     * @param task          the callable task to be executed
     * @param delayTicks    the initial delay in ticks before the first execution
     * @param intervalTicks the interval in ticks between consecutive executions
     * @param predicate     the {@link io.fairyproject.scheduler.repeat.RepeatPredicate} to control task repetition
     * @param <R>           the return type of the callable task
     * @return a {@link io.fairyproject.scheduler.ScheduledTask} representing the scheduled task
     */
    default <R> ScheduledTask<R> scheduleAtFixedRate(Callable<TaskResponse<R>> task, long delayTicks, long intervalTicks, RepeatPredicate<R> predicate) {
        return getMCScheduler().scheduleAtFixedRate(task, delayTicks, intervalTicks, predicate);
    }

    /**
     * Schedule a one-time task without a delay.
     *
     * @param task the task to be executed
     * @return a {@link io.fairyproject.scheduler.ScheduledTask} representing the scheduled task
     */
    default ScheduledTask<?> schedule(Runnable task) {
        return getMCScheduler().schedule(task);
    }

    /**
     * Schedule a one-time task with a specified delay.
     *
     * @param task  the task to be executed
     * @param delay the delay before the task is executed
     * @return a {@link io.fairyproject.scheduler.ScheduledTask} representing the scheduled task
     */
    default ScheduledTask<?> schedule(Runnable task, Duration delay) {
        return getMCScheduler().schedule(task, delay);
    }

    /**
     * Schedule a periodic task with a fixed delay and interval.
     *
     * @param task     the task to be executed
     * @param delay    the initial delay before the first execution
     * @param interval the interval between consecutive executions
     * @return a {@link io.fairyproject.scheduler.ScheduledTask} representing the scheduled task
     */
    default ScheduledTask<?> scheduleAtFixedRate(Runnable task, Duration delay, Duration interval) {
        return getMCScheduler().scheduleAtFixedRate(task, delay, interval);
    }

    /**
     * Schedule a periodic task with a fixed delay and interval, and a custom repeat predicate.
     *
     * @param task     the task to be executed
     * @param delay    the initial delay before the first execution
     * @param interval the interval between consecutive executions
     * @param predicate the {@link io.fairyproject.scheduler.repeat.RepeatPredicate} to control task repetition
     * @return a {@link io.fairyproject.scheduler.ScheduledTask} representing the scheduled task
     */
    default ScheduledTask<?> scheduleAtFixedRate(Runnable task, Duration delay, Duration interval, RepeatPredicate<?> predicate) {
        return getMCScheduler().scheduleAtFixedRate(task, delay, interval, predicate);
    }

    /**
     * Schedule a callable task without a delay.
     *
     * @param task the callable task to be executed
     * @param <R>  the return type of the callable task
     * @return a {@link io.fairyproject.scheduler.ScheduledTask} representing the scheduled task
     */
    default <R> ScheduledTask<R> schedule(Callable<R> task) {
        return getMCScheduler().schedule(task);
    }

    /**
     * Schedule a callable task with a specified delay.
     *
     * @param task  the callable task to be executed
     * @param delay the delay before the task is executed
     * @param <R>   the return type of the callable task
     * @return a {@link io.fairyproject.scheduler.ScheduledTask} representing the scheduled task
     */
    default <R> ScheduledTask<R> schedule(Callable<R> task, Duration delay) {
        return getMCScheduler().schedule(task, delay);
    }

    /**
     * Schedule a periodic callable task with a fixed delay and interval.
     *
     * @param task     the callable task to be executed
     * @param delay    the initial delay before the first execution
     * @param interval the interval between consecutive executions
     * @param <R>      the return type of the callable task
     * @return a {@link io.fairyproject.scheduler.ScheduledTask} representing the scheduled task
     */
    default <R> ScheduledTask<R> scheduleAtFixedRate(Callable<TaskResponse<R>> task, Duration delay, Duration interval) {
        return getMCScheduler().scheduleAtFixedRate(task, delay, interval);
    }

    /**
     * Schedule a periodic callable task with a fixed delay and interval, and a custom repeat predicate.
     *
     * @param task     the callable task to be executed
     * @param delay    the initial delay before the first execution
     * @param interval the interval between consecutive executions
     * @param predicate the {@link io.fairyproject.scheduler.repeat.RepeatPredicate} to control task repetition
     * @param <R>      the return type of the callable task
     * @return a {@link io.fairyproject.scheduler.ScheduledTask} representing the scheduled task
     */
    default <R> ScheduledTask<R> scheduleAtFixedRate(Callable<TaskResponse<R>> task, Duration delay, Duration interval, RepeatPredicate<R> predicate) {
        return getMCScheduler().scheduleAtFixedRate(task, delay, interval, predicate);
    }

    /**
     * Check if the current thread is the scheduler thread.
     *
     * @return {@code true} if the current thread is the scheduler thread, {@code false} otherwise
     */
    default boolean isCurrentThread() {
        return getMCScheduler().isCurrentThread();
    }

    /**
     * Execute a task immediately.
     *
     * @param task the task to be executed
     */
    default void execute(Runnable task) {
        getMCScheduler().execute(task);
    }
}
