package org.wxh.bestpractice.algorithms.sort.impl;

import org.wxh.bestpractice.algorithms.sort.AbstractSort;

/**
 * Created by maroon on 17-1-23.
 * DES: 希尔排序
 * 思想： 利用一个h因子先排一部分，将乱序的数据进行部分整理，使其接近 "顺序"，再进行插入排序
 * 由于插入排序对越接近顺序的序列排序效率越高，因此可以提高效率
 */
public class ShellSort extends AbstractSort{
    @Override
    public void sort(Comparable[] comparables) {
        int h = 1;
        while (h < comparables.length / 3) h = h * 3 + 1;
        while (h >= 1) {
            for (int i = h; i < comparables.length; i++) {
                Comparable temp = comparables[i];
                int j;
                for (j = i; j >= h && less(temp, comparables[j - h]); j -= h)
                    comparables[j] = comparables[j - h];
                comparables[j] = temp;
            }
            h = h / 3;
        }
    }
}
