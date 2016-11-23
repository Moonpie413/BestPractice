package DataStructure;

import java.util.*;

/**
 * Created by wangxh on 16-11-21.
 * package DataStructure
 * des
 */
public class BinaryTree<T> {

    BTNode<T> root;
    private Queue<T> dataQueue;

    public BinaryTree(Collection<T> dataArray) {
        this.dataQueue = new LinkedList<T>(dataArray);
        this.root = new BTNode<>();
        createTree(root);
    }

    private class BTNode<T> {
        T data;
        BTNode<T> left;
        BTNode<T> right;
    }

    /**
     * 前序创建树
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

    public void preOrderTraverse() {
        this.preOrderTraverse(root);
    }

    /**
     * 前序遍历
     * @param node
     */
    private void preOrderTraverse(BTNode<T> node) {
        if (node.data == null) return;
        System.out.println(node.data);
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    public static void main(String[] args) {
        BinaryTree<String> binaryTree = new BinaryTree<>(new ArrayList<>(Arrays.asList(new String[]{"A", "B", null, "D", null, null, "C", null, null})));
        binaryTree.preOrderTraverse();
    }

}
