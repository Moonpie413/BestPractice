package org.wxh.bestpractice.priorityqueue;

import org.wxh.bestpractice.algorithms.stock.ArrayStock;

/**
 * Created by maroon on 17-1-26.
 * DES: 数组在插入是就保持有序状态(这个类中不能直接把乱序数组作为构造器参数传入，偷懒直接用父类构造器了)
 */
public class PushSortPriorityArrayStock<Item extends Comparable<Item>> extends ArrayStock{
    @Override
    public void push(Comparable comparable) {
        if (index == a.length) {
            resize(a.length * 2);
        }
        if (index == 0 || comparable.compareTo(a[index - 1]) > 0) a[index++] = comparable;
        else {
            int i;
            // 如果前一位比要比较的数小就挪到这一位
            for (i = index; i > 0 && comparable.compareTo(a[i - 1]) < 0; i--) a[i] = a[i-1];
            a[i] = comparable;
            index++;
        }
    }

    public static void main(String[] args) {
        PushSortPriorityArrayStock<Integer> pushSortPriorityArrayStock
                = new PushSortPriorityArrayStock<>();
        pushSortPriorityArrayStock.push(2);
        pushSortPriorityArrayStock.push(10);
        pushSortPriorityArrayStock.push(100);
        pushSortPriorityArrayStock.push(87);
        pushSortPriorityArrayStock.push(1);
        System.out.println(pushSortPriorityArrayStock.pop());
        System.out.println(pushSortPriorityArrayStock.pop());
        System.out.println(pushSortPriorityArrayStock.pop());
        System.out.println(pushSortPriorityArrayStock.pop());
        System.out.println(pushSortPriorityArrayStock.pop());
        System.out.println(pushSortPriorityArrayStock.pop());
        System.out.println(pushSortPriorityArrayStock.pop());
        pushSortPriorityArrayStock.push(87);
        System.out.println(pushSortPriorityArrayStock.pop());
    }
}
