package org.wxh.bestpractice.algorithms.sort;

/**
 * Created by maroon on 17-1-23.
 * DES:
 */
public abstract class AbstractSort implements ISort {
    @Override
    public boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    @Override
    public void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    @Override
    public boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1])) return false;
        }
        return true;
    }
}
