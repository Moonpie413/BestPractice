package current.test24;

import java.util.concurrent.TimeUnit;

/**
 * Created by stormaroon on 16-10-5.
 */
public class Waitress implements Runnable {

    private Restaurant restaurant;

    public Waitress(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null) {
                        System.out.println("服务员等待");
                        wait();
                    }
                }
                System.out.println("服务员拿到菜:" + restaurant.meal);
                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notify();
                }
            }
        } catch (InterruptedException e) {
            //e.printStackTrace();
            System.out.println("服务员终止");
        }
    }

}
