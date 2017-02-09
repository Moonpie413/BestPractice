package org.wxh.bestpractice.algorithms.sort;

/**
 * Created by maroon on 17-1-23.
 * DES:
 */
public interface ISort {
    /**
     * 排序方法，由实现类实现
     * @param comparables
     */
    void sort(Comparable[] comparables);

    /**
     * 比较a是否比b小
     * @param a
     * @param b
     * @return
     */
    boolean less(Comparable a, Comparable b);

    /**
     * 交换 a 中 i 和 j 的位置
     * @param a 实现了a 接口的数组
     * @param i
     * @param j
     */
    void exch(Comparable[] a, int i, int j);

    /**
     * 输出 a 中的元素
     * @param a
     */
    default void show(Comparable[] a) {
        for (Comparable comparable : a) {
            System.out.print(comparable + " ");
        }
        System.out.println();
    }

    /**
     * 检查是否已经排序
     * @param a
     * @return
     */
    boolean isSorted(Comparable[] a);
}
