/**
 * Created by stormaroon on 16-10-5.
 */

package org.wxh.bestpractice.current.test22;

public class Task1 implements Runnable {

    public synchronized void waitThis() {
        try {
            System.out.println("task1 waiting");
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        waitThis();
        System.out.println(Thread.currentThread().getName() + " stop waiting");
    }

}
