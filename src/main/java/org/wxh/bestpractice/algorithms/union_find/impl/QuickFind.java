package org.wxh.bestpractice.algorithms.union_find.impl;

import org.wxh.bestpractice.algorithms.union_find.AbstractArrayUnion;

/**
 * Created by maroon on 17-1-22.
 * DES: 快速find算法
 * 详细参考算法第四版 1.5.2.1
 */
public class QuickFind extends AbstractArrayUnion {

    public QuickFind(int N) {
        super(N);
    }

    @Override
    public void union(int p, int q) {
         // 每次 union 操作都要遍历一遍数组
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) return;
        for (int i = 0; i < idArray.length; i++)
            if (idArray[i] == pID) idArray[i] = qID;
        this.count--;
    }

    @Override
    public int find(int p) {
        return idArray[p];
    }

}
