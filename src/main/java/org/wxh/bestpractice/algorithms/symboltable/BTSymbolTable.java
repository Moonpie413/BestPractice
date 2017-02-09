package org.wxh.bestpractice.algorithms.symboltable;

/**
 * Created by maroon on 17-1-28.
 * DES:
 */
public class BTSymbolTable<K extends Comparable<K>, V> implements SymbolTable<K, V>{

    private Node<K, V> root;

    private class Node<Key, Value> {
        private Node<Key, Value> left, right;
        private Key key;
        private Value value;
        private int size;

        public Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    @Override
    public void put(K k, V v) {
        root = put(root, k, v);
    }

    private Node<K, V> put(Node<K, V> x, K key, V value) {
        if (x == null) return new Node<>(key, value, 1);
        // 如果比x小往左递归，比x大往右递归
        // 如果到底了就返回新节点，赋值给上层节点的左/右节点
        // 如果找到了就直接返回当前的节点，还是会赋值给上层，直到x
        // 也就是说不管找没找到最终都会返回x，只不过会更新树的结构
        int compareNum = key.compareTo(x.key);
        // 如下这种情况如果没有赋值给上层而是直接return则会跳过size的计算但不影响生成节点
        // if (compareNum < 0) return put(x.left, key, value);
        if (compareNum < 0) x.left = put(x.left, key, value);
        if (compareNum < 0) x.left = put(x.left, key, value);
        else if (compareNum > 0) x.right = put(x.right, key, value);
        else x.value = value;
        // 递归回到上层后重新计算size
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public V get(K k) {
        return get(root, k);
    }

    private V get(Node<K, V> x, K k) {
        if (x == null) return null;
        int compareNum = k.compareTo(x.key);
        if (compareNum < 0) return get(x.left, k);
        else if (compareNum > 0) return get(x.right, k);
        else return x.value;
    }

    @Override
    public void delete(K k) {

    }

    public Node<K, V> deleteMax(Node<K, V> x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public boolean contains(K k) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public int size() {
        return this.size(root);
    }

    public Node<K, V> select(int n) {
        return select(root, n);
    }

    private Node<K, V> select(Node<K, V> x, int n) {
        if (x == null) return null;
        int t = size(x.left);
        if (n < t) return select(x.left, n);
        // n大于t，左边节点数不够
        if (n > t) return select(x.right, n - t - 1);
        else return x;
    }

    public int rank(K k) {
        return 0;
    }

    /**
     * 计算 x 节点的size
     * @param x 节点
     * @return int 节点的size
     */
    private int size(Node<K, V> x) {
        if (x == null) return 0;
        else return x.size;
    }

    public static void main(String[] args) {
        BTSymbolTable<Integer, String> btSymbolTable = new BTSymbolTable<>();
        for (int i = 0; i < 10; i++) {
            btSymbolTable.put(i, "string " + i);
        }
        System.out.println(btSymbolTable.get(9));
        System.out.println("size: " + btSymbolTable.size());
    }
}
