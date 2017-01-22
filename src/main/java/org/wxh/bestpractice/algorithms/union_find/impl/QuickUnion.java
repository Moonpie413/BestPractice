package org.wxh.bestpractice.algorithms.union_find.impl;

import org.wxh.bestpractice.algorithms.union_find.AbstractUnion;

/**
 * Created by maroon on 17-1-22.
 * DES:
 */
public class QuickUnion extends AbstractUnion{
    public QuickUnion(int N) {
        super(N);
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        // 将pRoot的父触点设为qRoot
        super.idArray[pRoot] = qRoot;
        super.count--;
    }

    @Override
    public int find(int p) {
        while (p != super.idArray[p]) p = super.idArray[p];
        return p;
    }
}
