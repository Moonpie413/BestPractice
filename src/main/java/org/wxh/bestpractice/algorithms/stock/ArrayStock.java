package org.wxh.bestpractice.algorithms.stock;

/**
 * Created by maroon on 17-1-26.
 * DES:
 */
public class ArrayStock<T extends Comparable<T>> implements IStock{

    protected Comparable[] a;
    protected int index;

    public ArrayStock() {
        this.a = new Comparable[1];
    }

    public ArrayStock(Comparable[] ts) {
        this.a = ts;
        this.index = this.a.length;
    }

    @Override
    public Comparable peek() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Comparable pop() {
        if (index <= 0) return null;
        if (index == a.length / 4) resize(a.length / 2);
        Comparable result = a[--index];
        a[index] = null;
        return result;
    }

    @Override
    public int size() {
        return this.index;
    }

    @Override
    public void push(Comparable comparable) {
        // 如果数组长度不够先扩容
        if (index == a.length) {
            resize(a.length * 2);
        }
        a[index++] = comparable;
    }

    protected void resize(int newsize) {
        Comparable[] newArray = new Comparable[newsize];
        System.arraycopy(a, 0, newArray, 0, index);
        this.a = newArray;
    }

    public static void main(String[] args) {
        ArrayStock<Integer> arrayStock = new ArrayStock<>();
        for (int i = 0; i < 10; i++) {
            arrayStock.push(i);
        }
        System.out.println(arrayStock.pop());
        System.out.println(arrayStock.pop());
        System.out.println(arrayStock.pop());
        System.out.println(arrayStock.pop());
        System.out.println(arrayStock.pop());
        System.out.println(arrayStock.pop());
        System.out.println(arrayStock.pop());
        System.out.println(arrayStock.pop());
        System.out.println(arrayStock.pop());
        System.out.println(arrayStock.pop());
        System.out.println(arrayStock.pop());
        System.out.println(arrayStock.pop());
        arrayStock.push(1);
        System.out.println(arrayStock.pop());
        System.out.println(arrayStock.pop());
        System.out.println(arrayStock.size());
    }
}
