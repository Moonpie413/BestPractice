package org.wxh.bestpractice.current.chapter21_7_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by wangxh on 16-12-24.
 * Package org.wxh.bestpractice.current.chapter21_7_2
 * DES:
 */

class Horse implements Runnable{

    private final CyclicBarrier barrier;
    private static final Random rand = new Random(47);
    // 这个是否需要同步
    private static int counter = 0;
    private final int id = counter++;
    private int move;

    public Horse(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

//    public synchronized int getMove() {
//        return this.move;
//    }

    public int getMove() { return this.move; }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // 这个同步是否是必要的
//                synchronized (this) {
//                    // 每次随机移动0,1,2步
                    this.move += rand.nextInt(3);
//                }
                this.barrier.await();
            }
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Horse{" + id + "}";
    }

    public String tracks() {
        StringBuilder s = new StringBuilder();
        for (int i=0; i< move; i++) {
            s.append("*");
        }
        s.append(id);
        return s.toString();
    }
}

public class HorseRace {
    private static final int FINISH_LINE = 75;
    private List<Horse> horses = new ArrayList<>();
    private ExecutorService exec = Executors.newCachedThreadPool();

    public HorseRace(int horsesNum, int pause) {
        CyclicBarrier barrier = new CyclicBarrier(horsesNum, () -> {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < FINISH_LINE; i++) {
                builder.append("=");
            }
            System.out.println(builder.toString());
            for (Horse horse : horses) {
                System.out.println(horse.tracks());
            }
            for (Horse horse : horses) {
                if (horse.getMove() >= FINISH_LINE) {
                    System.out.println("House " + horse + "won!");
                    exec.shutdownNow();
                    return;
                }
            }
            try {
                TimeUnit.MILLISECONDS.sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        for (int i = 0; i < horsesNum; i++) {
            Horse horse = new Horse(barrier);
            horses.add(horse);
            exec.execute(horse);
        }
    }

    public static void main(String[] args) {
        int horseNum = 20;
        int pause = 100;
        new HorseRace(horseNum, pause);
    }
}
