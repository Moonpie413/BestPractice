package org.wxh.bestpractice.algorithms.deque;

/**
 * Created by maroon on 17-1-21.
 * DES:
 */
public interface IDeque<T> {
    boolean isEmpty();
    int size();
    void pushLeft(T t);
    void pushRight(T t);
    T popLeft();
    T popRight();
}
