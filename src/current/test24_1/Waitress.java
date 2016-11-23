package current.test24_1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by stormaroon on 16-10-5.
 */
public class Waitress implements Runnable {
    private Restaurant restaurant;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public Waitress(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void waitThis() throws InterruptedException {
        try {
            lock.lock();
            while (restaurant.meal == null) {
                System.out.println("服务员等待");
                condition.await();
            }
        } finally {
            lock.unlock();
        }
    }

    public void notfyChefWork() {
        try {
            restaurant.chef.lock.lock();
            restaurant.meal = null;
            restaurant.chef.condition.signal();
        } finally {
            restaurant.chef.lock.unlock();
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                waitThis();
                System.out.println("服务员上菜: " + restaurant.meal);
                notfyChefWork();
            }
        } catch (InterruptedException e) {
            System.out.println("服务员退出");
        }
    }
}
