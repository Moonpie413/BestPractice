package current.concurrency_in_practice.Example7_15;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.concurrent.*;

/**
 * Created by wangxh on 16-12-27.
 * Package current.concurrency_in_practice.Example7_15
 * DES:
 */
public class LogService {
    private final BlockingQueue<String> queue = new LinkedBlockingDeque<>(20);
    private final LoggerThread loggerThread = new LoggerThread();
    private final PrintStream writer = new PrintStream(System.out);

    private boolean isShutdown;
    private int count;

    void start() {
        writer.println("log线程启动");
        loggerThread.start();
    }

    void stop() {
        synchronized (this) { isShutdown = true; };
        this.loggerThread.interrupt();
    }

    // 多生产者
    void log(String msg) throws InterruptedException {
        synchronized (this) {
            if (isShutdown) throw new IllegalStateException();
            ++count;
        }
        // 可中断
        try {
            queue.put(msg);
        } catch (InterruptedException e) {
            writer.println("生产者线程中断");
            throw e;
        }
    }

    // 单一消费者
    private class LoggerThread extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    synchronized (LogService.this) {
                        if (isShutdown && count == 0) break;
                    }
                    writer.println(queue.take());
                    synchronized (LogService.this) {
                        count--;
                    }
                }
            } catch (InterruptedException e) {
                writer.println("消费者线程终止");
                e.printStackTrace();
            } finally {
                writer.close();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LogService service = new LogService();
        service.start();
        ExecutorService exec = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            String logContent = "log: { " + i + " }";
            exec.execute(() -> {
                try {
                    service.log(logContent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        TimeUnit.MILLISECONDS.sleep(1);
        service.stop();
        exec.shutdown();
        exec.awaitTermination(200, TimeUnit.SECONDS);
    }
}

