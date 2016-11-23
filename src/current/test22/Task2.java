package current.test22;

import java.util.concurrent.TimeUnit;

/**
 * Created by stormaroon on 16-10-5.
 */
public class Task2 implements Runnable{

    private final Task1 task1;

    Task2(Task1 task1) {
        this.task1 = task1;
    }

    private void wakeTask1() {
        synchronized (task1) {
            System.out.println("notifying task 1");
            this.task1.notify();
        }
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
            wakeTask1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
