package org.wxh.bestpractice.algorithms.union_find.impl;

import org.wxh.bestpractice.algorithms.union_find.IUnion;

/**
 * Created by maroon on 17-1-23.
 * DES:
 */
public class LinkedQuickUnion implements IUnion {

    private class Node<T> {
        private T item;
        private Node<T> next;
    }

    @Override
    public void union(int p, int q) {

    }

    @Override
    public int find(int p) {
        return 0;
    }

    @Override
    public boolean connected(int p, int q) {
        return false;
    }

    @Override
    public int count() {
        return 0;
    }
}
