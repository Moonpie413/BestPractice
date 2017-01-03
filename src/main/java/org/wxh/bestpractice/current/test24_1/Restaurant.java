package org.wxh.bestpractice.current.test24_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by stormaroon on 16-10-5.
 */
public class Restaurant {
    Meal meal;
    Chef chef = new Chef(this);
    Waitress waitress = new Waitress(this);
    ExecutorService exec = Executors.newCachedThreadPool();

    public Restaurant() {
        exec.execute(chef);
        exec.execute(waitress);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}
