package org.wxh.bestpractice.algorithms.union_find.impl;

import org.wxh.bestpractice.algorithms.union_find.AbstractUnion;

/**
 * Created by maroon on 17-1-22.
 * DES:
 */
public class UnionFind extends AbstractUnion{
    private int[] sz; // 保存根节点上的子节点数量
    public UnionFind(int N) {
        super(N);
        this.sz = new int[N];
        for (int i = 0; i < N; i++) sz[i] = 1;
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        if (sz[pRoot] > sz[qRoot]) {super.idArray[qRoot] = pRoot;sz[pRoot]++;}
        else {super.idArray[pRoot] = qRoot;sz[qRoot]++;}
    }

    @Override
    public int find(int p) {
        while (p != super.idArray[p]) p = super.idArray[p];
        return p;
    }
}
