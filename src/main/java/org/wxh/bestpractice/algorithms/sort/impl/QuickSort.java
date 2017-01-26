package org.wxh.bestpractice.algorithms.sort.impl;

import edu.princeton.cs.algs4.StdRandom;
import org.wxh.bestpractice.algorithms.sort.AbstractSort;

/**
 * Created by maroon on 17-1-25.
 * DES:
 */
public class QuickSort extends AbstractSort{
    @Override
    public void sort(Comparable[] comparables) {
        sort(comparables, 0, comparables.length - 1);
    }

    private void sort(Comparable[] comparables, int low, int high) {
        if (low >= high) return;
        int partitionNum = partition(comparables, low, high);
        sort(comparables, low, partitionNum - 1);
        sort(comparables, partitionNum + 1, high);
    }

    private int partition(Comparable[] comparables, int low, int high) {
        Comparable sig = comparables[low];
        int i = low + 1;
        int j = high;
        while (true) {
            while (less(comparables[i], sig) && i < high) i++;
            while (less(sig, comparables[j]) && j > low) j--;
            if (i >= j) break;
            exch(comparables, i, j);
        }
        exch(comparables, low, j);
        return j;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        Integer[] testData = new Integer[]{100, 3, 6, 4, 1, 101};
        StdRandom.shuffle(testData);
        quickSort.show(testData);
        int partNum = quickSort.partition(testData, 0, testData.length - 1);
        System.out.println(partNum);
        quickSort.show(testData);
    }
}
