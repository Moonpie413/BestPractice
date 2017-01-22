package org.wxh.bestpractice.algorithms.deque.impl;

import org.wxh.bestpractice.algorithms.deque.IDeque;

/**
 * Created by maroon on 17-1-21.
 * DES:
 */
public class LinkedDeque<Item> implements IDeque<Item> {

    private Node<Item> left;
    private Node<Item> right;
    private int size;

    public LinkedDeque() {
        this.left = new Node<>();
        this.right = new Node<>();
        this.link(left, right);
    }

    private class Node<T> {
        T item;
        Node<T> left;
        Node<T> right;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void pushLeft(Item item) {
        this.left.item = item;
        Node newLeft = new Node();
        link(newLeft, left);
        this.left = newLeft;
        this.size++;
    }

    @Override
    public void pushRight(Item item) {
        this.right.item = item;
        Node newRight = new Node();
        link(right, newRight);
        this.right = newRight;
        this.size++;
    }

    @Override
    public Item popLeft() {
        Item item = this.left.right.item;
        if (size <= 0 || item == null) throw new RuntimeException("Deque中没有元素");
        link(this.left, this.left.right.right);
        this.size--;
        return item;
    }

    @Override
    public Item popRight() {
        Item item = this.right.left.item;
        if (size <= 0 || item == null) throw new RuntimeException("Deque中没有元素");
        link(this.right.left.left, this.right);
        this.size--;
        return item;
    }

    /**
     * 将左右节点连接起来
     * @param left
     * @param right
     */
    private void link(Node left, Node right) {
        left.right = right;
        right.left = left;
    }

    public static void main(String[] args) {
        LinkedDeque<String> linkedDeque = new LinkedDeque<>();
        linkedDeque.pushRight("123133");
        linkedDeque.pushLeft("sadadad");
        System.out.println(linkedDeque.popRight());
        System.out.println(linkedDeque.popRight());
    }
}
