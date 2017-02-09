package org.wxh.bestpractice.priorityqueue;

import org.wxh.bestpractice.algorithms.stock.ArrayStock;

import java.util.Random;

/**
 * Created by maroon on 17-1-26.
 * DES: 复写数组实现的堆栈使其pop方法带有优先级
 * 数组本来是无序的，每次pop将最大值找出来弹出
 */
public class PopSortPriortyArrayStock<T extends Comparable<T>> extends ArrayStock {
    public PopSortPriortyArrayStock() {
        super();
    }

    public PopSortPriortyArrayStock(Comparable[] comparables) {
        super(comparables);
    }

    @Override
    public Comparable pop() {
        maxSort();
        return super.pop();
    }

    private void maxSort() {
        for (int i = 0; i < index - 1; i++) {
            if (a[i].compareTo(a[index - 1]) > 0) exch(i, index - 1);
        }
    }

    private void exch(int a, int b) {
        Comparable temp = this.a[a];
        this.a[a] = this.a[b];
        this.a[b] = temp;
    }

    public static void main(String[] args) {
        PopSortPriortyArrayStock<Integer> popSortPriortyArrayStock = new PopSortPriortyArrayStock<>();

        for (int i = 0; i < 20; i++) {
            popSortPriortyArrayStock.push(new Random().nextInt(20));
        }

        System.out.println(popSortPriortyArrayStock.pop());
        System.out.println(popSortPriortyArrayStock.pop());
        System.out.println(popSortPriortyArrayStock.pop());
        System.out.println(popSortPriortyArrayStock.pop());
        System.out.println(popSortPriortyArrayStock.pop());
        System.out.println(popSortPriortyArrayStock.pop());

    }

}
