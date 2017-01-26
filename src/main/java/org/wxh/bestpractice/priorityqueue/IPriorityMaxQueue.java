package org.wxh.bestpractice.priorityqueue;

/**
 * Created by maroon on 17-1-26.
 * DES: 最大堆队列接口
 */
public interface IPriorityMaxQueue<T extends Comparable<T>> {
    void insert(T t);
    T max();
    T delMax();
    boolean isEmpty();
    int size();
}
