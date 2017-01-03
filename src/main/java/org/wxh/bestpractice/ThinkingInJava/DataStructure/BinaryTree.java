package org.wxh.bestpractice.ThinkingInJava.DataStructure;

import java.util.*;

/**
 * Created by wangxh on 16-11-21.
 * package org.wxh.bestpractice.ThinkingInJava.DataStructure
 * des
 */
public class BinaryTree<T> {

    BTNode<T> root;
    private Queue<T> dataQueue;

    public BinaryTree(Collection<T> dataArray) {
        this.dataQueue = new LinkedList<T>(dataArray);
        this.root = new BTNode<>();
        //createTree(root);
        createTreeByStack();
    }

    private class BTNode<T> {
        T data;
        BTNode<T> left;
        BTNode<T> right;

        @Override
        public String toString() {
            return data.toString();
        }
    }

    /**
     * 前序创建树
     *
     * @param node
     */
    private void createTree(BTNode<T> node) {
        T element = this.dataQueue.remove();
        if (element != null) {
            node.data = element;
            node.left = new BTNode<>();
            node.right = new BTNode<>();
            createTree(node.left);
            createTree(node.right);
        }
    }

    /**
     * 使用堆栈来初始化树 (前序)
     */
    public void createTreeByStack() {
        Stack<BTNode<T>> stack = new Stack<>();
        BTNode<T> curr = null;
        while (!this.dataQueue.isEmpty() || !stack.isEmpty()) {
            for (T element = this.dataQueue.remove(); element != null; element = this.dataQueue.remove()) {
                if (this.root.data == null) {
                    curr = root;
                }
                curr.data = element;
                curr.left = new BTNode<>();
                curr.right = new BTNode<>();
                stack.push(curr);
                curr = curr.left;
            }
            if (!stack.isEmpty()) {
                curr = stack.pop();
                curr = curr.right;
            }
        }
    }

    /**
     * 递归函数的封装调用
     */
    public void preOrderTraverse() {
        this.preOrderTraverse(root);
    }

    /**
     * 使用堆栈实现的前序遍历
     */
    public void preOrderStackTraverse() {
        Stack<BTNode<T>> stack = new Stack<>();
        BTNode<T> curr = root;
        while (curr.data != null || !stack.isEmpty()) {
            while (curr.data != null) {
                System.out.print(curr.data + ", ");
                stack.push(curr);
                curr = curr.left;
            }
            if (!stack.isEmpty()) {
                curr = stack.pop();
                curr = curr.right;
            }
        }
    }

    /**
     * 前序遍历
     *
     * @param node
     */
    private void preOrderTraverse(BTNode<T> node) {
        if (node.data == null) return;
        System.out.print(node.data + ", ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    /**
     * 层序遍历
     */
    public void leverOrderTraverse() {
        Queue<BTNode<T>> queue = new LinkedList<>();
        if (this.root == null || this.root.data == null) return;
        queue.offer(root);
        while (!queue.isEmpty()) {
            BTNode<T> temp = queue.poll();
            System.out.print(temp + ", ");
            if (temp.left.data != null) queue.offer(temp.left);
            if (temp.right.data != null) queue.offer(temp.right);
        }
    }

    public static void main(String[] args) {
        // 测试数据
        BinaryTree<String> binaryTree = new BinaryTree<>(new ArrayList<>(Arrays.asList(new String[]{"A", "B", null, "D", null, null, "C", null, null})));
        binaryTree.preOrderTraverse();
        System.out.println("---------------------");
        binaryTree.preOrderStackTraverse();
        System.out.println("---------------------");
        binaryTree.leverOrderTraverse();
        System.out.println("---------------------");
    }

}
