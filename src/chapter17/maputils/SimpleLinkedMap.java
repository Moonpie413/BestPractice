package chapter17.maputils;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Created by wangxh on 16-11-12.
 * package chapter17.maputils
 * des
 */
public class SimpleLinkedMap<K, V> {

    private Node<K, V> header = new Node<K, V>(null, null, null);
    private MyEntrySet myEntrySet = new MyEntrySet();
    private int size;

    public void put(K k, V v) {
        if (k == null) throw new NullPointerException();
        Node<K, V> newNode = new Node<>(k, v, null);
        if (header.next == null) {
            header.next = newNode;
        } else {
            for (Node<K, V> curr = header; ; curr = curr.next) {
                if (curr.next == null) {
                    curr.next = newNode;
                    break;
                }
            }
        }
        this.size++;
    }

    public V get(K k) {
        if (k == null) throw new NullPointerException();
        V result = null;
        for (Node<K, V> curr = header.next; ; curr = curr.next) {
            if (curr.getKey().equals(k)) result = curr.getValue();
            if (curr.next == null) break;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Iterator iterator = entrySet().iterator();
        while (iterator.hasNext()) {
            Node<K, V> node = (Node<K, V>) iterator.next();
            builder.append("[" + node.getKey() + " = " + node.getValue() + "]");
        }
        return builder.toString();
    }

    public MyEntrySet entrySet() {
        return myEntrySet;
    }

    private class MyEntrySet extends AbstractSet<Node<K, V>> {

        private class Iter implements Iterator<Node<K, V>> {

            Node<K, V> next;
            Node<K, V> lastReturned;

            private Iter() {
                this.next = header.next;
            }

            @Override
            public boolean hasNext() {
                return this.next != null;
            }

            @Override
            public Node<K, V> next() {
                if (this.next == header) throw new NoSuchElementException();
                lastReturned = next;
                this.next = this.next.next;
                return lastReturned;
            }
        }

        @Override
        public Iterator<Node<K, V>> iterator() {
            return new Iter();
        }

        @Override
        public int size() {
            return size;
        }
    }

    /**
     * 内部节点类
     *
     * @param <K>
     * @param <V>
     */
    private class Node<K, V> implements Map.Entry<K, V> {

        final K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V v) {
            return this.value = v;
        }

        @Override
        public int hashCode() {
            return (this.key == null ? 0 : this.key.hashCode()) ^ (this.value == null ? 0 : this.value.hashCode());
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof MyEntry)) return false;
            MyEntry entry = (MyEntry) o;
            return (this.key == null ? getKey() == null : getKey().equals(entry.getKey()) &&
                    this.value == null ? getValue() == null : getValue().equals(entry.getValue()));
        }

    }

    public static void main(String[] args) {
        SimpleLinkedMap<String, String> linkedMap = new SimpleLinkedMap<>();
        linkedMap.put("test1", "hello");
        linkedMap.put("test2", "world");
        linkedMap.put("test3", "again");
        System.out.println(linkedMap.get("test3"));
        System.out.println("---------------------");
        System.out.println(linkedMap.entrySet().size());
        for (Map.Entry node : linkedMap.entrySet()) {
//            System.out.println(node.getKey() + " = " + node.getValue());
            node.setValue("changed?");
        }
        System.out.println(linkedMap);
    }
}
