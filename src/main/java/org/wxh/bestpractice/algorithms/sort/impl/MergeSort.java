package org.wxh.bestpractice.algorithms.sort.impl;

import org.wxh.bestpractice.algorithms.sort.AbstractSort;

/**
 * Created by maroon on 17-1-24.
 * DES: 归并排序
 */
public class MergeSort extends AbstractSort{

    private Comparable[] aux;

    @Override
    public void sort(Comparable[] comparables) {
        aux = new Comparable[comparables.length];
        sort(comparables, 0, aux.length - 1);
    }

    private void sort(Comparable[] a, int low, int high) {
        if (high <= low) return;
        int mid = low + (high - low) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    private void merge(Comparable[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        // 分段排序
        System.arraycopy(a, low, aux, low, high + 1 - low);
        for (int x = low; x <= high; x++) {
            if (i > mid) a[x] = aux[j++];
            else if (j > high) a[x] = aux[i++];
            else if (less(aux[j], aux[i])) a[x] = aux[j++];
            else a[x] = aux[i++];
        }
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[]{2, 1};
        MergeSort mergeSort = new MergeSort();
//        mergeSort.merge(data, 0, (data.length - 1) / 2, data.length - 1);
        mergeSort.sort(data);
        for (Integer i : data) System.out.print(i + "");
    }
}
