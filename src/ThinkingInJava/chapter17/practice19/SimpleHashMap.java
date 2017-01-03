package ThinkingInJava.chapter17.practice19;

import java.util.*;

/**
 * Created by wangxh on 16-11-12.
 * package ThinkingInJava.chapter17.practice19
 * des
 */
public class SimpleHashMap<K, V> extends AbstractMap<K, V> {

    private Node<K, V>[] buckets = new Node[997];
    private Node<K, V> header = new Node<K,V>(null, null, null);
    private MyEntrySet myEntrySet = new MyEntrySet();
    private int size;

    /**
     * 内部节点类
     *
     * @param <K>
     * @param <V>
     */
    private class Node<K, V> implements Entry<K, V> {

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
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return (this.key == null ? getKey() == null : getKey().equals(node.getKey()) &&
                    this.value == null ? getValue() == null : getValue().equals(node.getValue()));
        }

    }

    private class MyEntrySet extends AbstractSet<Entry<K, V>> {

        private class Iter implements Iterator<Entry<K, V>> {

            private List<Node<K, V>> headList = new ArrayList<>();
            private Node<K, V> lastReturned = header;
            private int index;

            public Iter() {
                for (int i=0; i<buckets.length; i++) {
                    if (buckets[i] != null) {
                        headList.add((Node<K, V>) buckets[i]);
                    }
                }
            }

            @Override
            public boolean hasNext() {
                return (size > 0) && (index < headList.size());
            }

            @Override
            public Entry<K, V> next() {
                if (lastReturned == header) {
                    lastReturned = headList.get(index).next;
                } else {
                    lastReturned = lastReturned.next;
                }
                if (lastReturned.next == null) {
                    lastReturned = header;
                    index++;
                }
                return lastReturned;
            }
        }

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new Iter();
        }

        @Override
        public int size() {
            return size;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public V get(Object o) {
        if (o == null) throw new NullPointerException();
        int index = generateIndex((K) o);
        V result = null;
        for (Node<K, V> curr = buckets[index]; ; curr = curr.next) {
            if (curr.getKey() == null) continue;
            if (curr.getKey().equals(o)) {
                result = curr.getValue();
            }
            if (curr.next == null) break;
        }
        return result;
    }

    @Override
    public V put(K k, V v) {
        if (k == null) throw new NullPointerException();
        V oldV = null;
        int index = generateIndex(k);
        // 判断该节点是否已经初始化
        if (buckets[index] == null) {
            // 初始化节点
            buckets[index] = new Node<>(null, null, null);
        }
        boolean founded = false;
        for (Node<K, V> curr = buckets[index]; ; curr = curr.next) {
            if (k.equals(curr.getKey())) {
                founded = true;
                oldV = curr.getValue();
                curr.setValue(v);
            }
            if (curr.next == null) break;
        }
        if (!founded) {
            for (Node<K, V> curr = buckets[index]; ; curr = curr.next) {
                if (curr.next == null) {
                    curr.next = new Node<>(k, v, null);
                    break;
                }
            }
        }
        this.size++;
        return oldV;
    }

    @Override
    public V remove(Object o) {
        return super.remove(o);
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return this.myEntrySet;
    }

    /**
     * 通过键的hashcode生成index
     *
     * @param k
     * @return index[数组下标]
     */
    private int generateIndex(K k) {
        return Math.abs(k.hashCode() % buckets.length);
    }

    public static void main(String[] args) {
        SimpleHashMap<String, String> hashMap = new SimpleHashMap<>();
        hashMap.put("test1", "hello");
        hashMap.put("test2", "world");
        hashMap.put("test3", "again");
        System.out.println(hashMap.get("test2"));
        System.out.println(hashMap.get("test1").equals(hashMap.get("test2")));

        for (Entry<String, String> node : hashMap.entrySet()) {
            node.setValue("changed");
        }

        for (Entry<String, String> node : hashMap.entrySet()) {
            System.out.println(node.getValue());
        }
    }

}
