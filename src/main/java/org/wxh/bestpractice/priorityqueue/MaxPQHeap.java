package org.wxh.bestpractice.priorityqueue;

import java.util.Random;

/**
 * Created by maroon on 17-1-26.
 * DES: 二差堆实现的优先级队列
 */
public class MaxPQHeap implements IPriorityMaxQueue {

    private Comparable[] pq;
    private int N;

    public MaxPQHeap(int maxN) {
        this.pq = new Comparable[maxN + 1];
    }

    /**
     * 插入元素
     * @param comparable
     */
    @Override
    public void insert(Comparable comparable) {
        this.pq[++N] = comparable;
        swim(N);
    }

    @Override
    public Comparable max() {
        throw new UnsupportedOperationException();
    }

    /**
     * 删除最大值
     * @return maxNumber
     */
    @Override
    public Comparable delMax() {
        Comparable max = pq[1];
        exch(1, N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return this.N;
    }

    /**
     * 把元素k上浮
     * @param k item key
     */
    private void swim(int k) {
        // 只要父节点小于当前节点就交换两个节点的位置
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    /**
     * 把元素k下沉
     * @param k item key
     */
    private void sink(int k) {
        while (k <= N / 2) {
            int j = k * 2;
            // 比较两个子节点，取较大值
            // 如果j等于N的话一定没有右节点所以排除
            if (j < N && less(j, j + 1)) j += 1;
            if (!less(k, j)) break; // 如果pq[k]已经大于他的字节点则break
            exch(k, j); // 交换位置
            k = j; // 循环继续
        }
    }

    /**
     * 比较i跟j的大小
     * @param i item key
     * @param j item key
     * @return i是否小于j
     */
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    /**
     * 交换i和j的位置
     * @param i item key
     * @param j item key
     */
    private void exch(int i, int j) {
        {Comparable temp = pq[i];pq[i] = pq[j];pq[j] = temp;}
    }

    public static void main(String[] args) {
        MaxPQHeap maxPQHeap = new MaxPQHeap(10);
        for (int i = 0; i < 10; i++) {
            maxPQHeap.insert(new Random().nextInt(100));
        }
        System.out.println(maxPQHeap.delMax());
        System.out.println(maxPQHeap.delMax());
        System.out.println(maxPQHeap.delMax());
        System.out.println(maxPQHeap.delMax());
        System.out.println(maxPQHeap.delMax());
        System.out.println(maxPQHeap.delMax());
        System.out.println(maxPQHeap.delMax());
    }
}
