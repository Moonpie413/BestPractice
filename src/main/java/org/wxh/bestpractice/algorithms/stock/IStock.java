package org.wxh.bestpractice.algorithms.stock;

/**
 * Created by maroon on 17-1-26.
 * DES: 堆栈接口
 */
public interface IStock<T extends Comparable<T>> {

    T peek();

    T pop();

    int size();

    void push(T t);
}
