package org.wxh.bestpractice.algorithms.union_find;

/**
 * Created by maroon on 17-1-22.
 * DES:
 */
public abstract class AbstractArrayUnion implements IUnion{

    protected int[] idArray;
    protected int count;

    public AbstractArrayUnion(int N) {
        this.count = N;
        this.idArray = new int[N];
        for (int i = 0; i < N; i++) idArray[i] = i;
    }

    @Override
    public abstract void union(int p, int q);

    @Override
    public abstract int find(int p);

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return this.count;
    }
}
