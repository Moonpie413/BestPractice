package ThinkingInJava.chapter17.practice16;

import ThinkingInJava.chapter17.maputils.MyEntry;

import java.util.*;

/**
 * Created by wangxh on 16-11-12.
 * package ThinkingInJava.chapter17.practice16
 * des
 */

class SlowMap<K, V> extends AbstractMap<K, V> {

    private List<K> keys = new ArrayList<K>();
    private List<V> values = new ArrayList<V>();
    private EntrySet entrySet = new EntrySet();

    private class EntrySet extends AbstractSet<Entry<K, V>> {

        private class Iter implements Iterator<Entry<K, V>> {

            private int index = -1;
            private MyEntry<K, V> myEntry = new MyEntry<>();

            @Override
            public boolean hasNext() {
                return this.index < size() - 1;
            }

            @Override
            public Entry<K, V> next() {
                index++;
                this.myEntry.setKey(keys.get(index));
                this.myEntry.setValue(values.get(index));
                return this.myEntry;
            }
        }

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new Iter();
        }

        @Override
        public int size() {
            return keys.size();
        }
    }

    @Override
    public V get(Object o) {
        if (o == null) throw new NullPointerException();
        if (!keys.contains(o)) return null;
        return values.get(keys.indexOf(o));
    }

    @Override
    public V put(K k, V v) {
        if (k == null) throw new NullPointerException();
        V oldV = this.get(k);
        if (keys.contains(k)) {
            values.set(keys.indexOf(k), v);
        } else {
            keys.add(k);
            values.add(v);
        }
        return oldV;
    }

    @Override
    public V remove(Object o) {
        //TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return entrySet;
    }
}

public class SlowMapTest {
    public static void main(String[] args) {
        Map<String, String> slowMap = new SlowMap<>();
        slowMap.put("test1", "hello");
        slowMap.put("test2", "world");

        for (Map.Entry<String, String> entry : slowMap.entrySet()) {
            entry.setValue("changed");
        }

        for (Map.Entry<String, String> entry : slowMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
