package org.wxh.bestpractice.priorityqueue;

import java.util.Random;

/**
 * Created by maroon on 17-1-26.
 * DES: 基本的优先级队列实现
 */
public class MaxPQ<Item extends Comparable<Item>> implements IPriorityMaxQueue {

    private PopSortPriortyArrayStock<Item> popSortPriortyArrayStock = new PopSortPriortyArrayStock<Item>();

    @Override
    public void insert(Comparable comparable) {
        this.popSortPriortyArrayStock.push(comparable);
    }

    @Override
    public Comparable max() {
        return this.popSortPriortyArrayStock.peek();
    }

    @Override
    public Comparable delMax() {
        return this.popSortPriortyArrayStock.pop();
    }

    @Override
    public boolean isEmpty() {
        return this.popSortPriortyArrayStock.size() == 0;
    }

    @Override
    public int size() {
        return this.popSortPriortyArrayStock.size();
    }

    public static void main(String[] args) {
        MaxPQ<Integer> maxPQ = new MaxPQ<>();
        for (int i = 0; i < 20; i++) {
            maxPQ.insert(new Random().nextInt(20));
        }
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
    }
}
