package current.test24;

import java.util.concurrent.TimeUnit;

/**
 * Created by stormaroon on 16-10-5.
 */
public class Chef implements Runnable {

    private Restaurant restaurant;
    private int count;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null) {
                        System.out.println("厨师等待");
                        wait();
                    }
                }
                if (count == 10) restaurant.exec.shutdownNow();
                System.out.println("厨师开始下厨");
                synchronized (restaurant.waitress) {
                    restaurant.meal = new Meal(count++);
                    restaurant.waitress.notify();
                }
                TimeUnit.MILLISECONDS.sleep(200);
                }
            } catch (InterruptedException e) {
            System.out.println("厨师终止");
        }
    }

}
