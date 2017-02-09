package org.wxh.bestpractice.algorithms.sort.impl;

import org.wxh.bestpractice.algorithms.sort.AbstractSort;

/**
 * Created by maroon on 17-1-23.
 * DES:
 */
public class BubbleSort extends AbstractSort{
    @Override
    public void sort(Comparable[] comparables) {
        if (comparables == null) throw new NullPointerException("没有数据");
        for (int i = 0; i < comparables.length; i++) {
            for (int j = i + 1; j < comparables.length; j++) {
                if (!less(comparables[i], comparables[j])) exch(comparables, i, j);
            }
        }
    }
}
