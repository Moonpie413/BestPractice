package current.test22;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by stormaroon on 16-10-5.
 */
public class Main {

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        Task2 task2 = new Task2(task1);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(task1);
        exec.execute(task2);
        exec.shutdown();
    }

}
