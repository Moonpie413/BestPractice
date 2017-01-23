package org.wxh.bestpractice.algorithms.sort.impl;

import org.wxh.bestpractice.algorithms.sort.AbstractSort;

/**
 * Created by maroon on 17-1-23.
 * DES: 插入排序
 */
public class InsertSort extends AbstractSort{
    @Override
    public void sort(Comparable[] comparables) {
        for (int i = 1; i < comparables.length; i++) {
            for (int j = i; j > 0 && less(comparables[j], comparables[j - 1]); j--) {
                exch(comparables, j, j - 1);
            }
        }
    }

    /**
     * 移位实现的插入排序
     * @param comparables
     */
    public void sortWithOutExch(Comparable[] comparables) {
        for (int i = 1; i < comparables.length; i++) {
            Comparable temp = comparables[i];
            int j;
            // 直接将temp与各个元素进行比较
            for (j = i; j > 0 && less(temp, comparables[j - 1]); j--) {
                comparables[j] = comparables[j - 1];
            }
            comparables[j] = temp;
        }
    }
}
