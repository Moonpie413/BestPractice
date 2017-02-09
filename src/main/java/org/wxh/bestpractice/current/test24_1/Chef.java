package org.wxh.bestpractice.current.test24_1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chef implements Runnable {
    private Restaurant restaurant;
    private int count;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void waitThis() throws InterruptedException {
        try {
            lock.lock();
            while (restaurant.meal != null) {
                System.out.println("厨师等待");
                condition.await();
            }
        } finally {
            lock.unlock();
        }
    }

    public void notifyWaitressWork() {
        try {
            restaurant.waitress.lock.lock();
            restaurant.meal = new Meal(++count);
            restaurant.waitress.condition.signal();
        } finally {
            restaurant.waitress.lock.unlock();
        }
    }

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                waitThis();
                System.out.println("厨师开始下厨");
                notifyWaitressWork();
                if (this.count == 10) {
                    restaurant.exec.shutdownNow();
//                    throw new InterruptedException();
                };
                TimeUnit.MILLISECONDS.sleep(200);
            }
        } catch (InterruptedException e) {
            System.out.println("厨师退出");
        }
    }
}
