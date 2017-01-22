package org.wxh.bestpractice.algorithms.union_find;

/**
 * Created by maroon on 17-1-22.
 * DES:
 */
public interface IUnion {
    /**
     * 将两个节点连通
     * @param p 节点P
     * @param q 节点q
     */
    void union(int p, int q);

    /**
     * 找到节点的位置
     * @param p 节点p
     * @return int 节点位置
     */
    int find(int p);

    /**
     * 判断两个节点是否相连
     * @param p 节点p
     * @param q 节点q
     * @return boolean 是否相连
     */
    boolean connected(int p, int q);

    /**
     * 获得连通分量的数量
     * @return int 连通分量的数量
     */
    int count();
}
