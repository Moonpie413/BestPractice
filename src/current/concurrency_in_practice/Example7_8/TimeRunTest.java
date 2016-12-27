package current.concurrency_in_practice.Example7_8;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangxh on 16-12-27.
 * Package current.concurrency_in_practice.Example7_8
 * DES:
 */
public class TimeRunTest {

    private static final ScheduledExecutorService cancelExec = Executors.newScheduledThreadPool(1);

    public static void timedRun(Runnable r, long timeout, TimeUnit unit) {
        final Thread taskThread = Thread.currentThread();
        System.out.println("Thread from timedRun: " + taskThread.getName());
        cancelExec.schedule( () -> {
            System.out.println("Thread from schedule: " + Thread.currentThread().getName());
            taskThread.interrupt();
        }, timeout, unit);
        r.run();
    }

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("Thread from runnable: " + Thread.currentThread().getName());
        };
        timedRun(runnable, 200, TimeUnit.MILLISECONDS);
        cancelExec.shutdown();
    }
}
