package chapter17.maputils;

import java.util.Map;

/**
 * Created by wangxh on 16-11-12.
 * package chapter17.maputils
 * des
 */
public class MyEntry<K, V> implements Map.Entry<K, V>{
    private K key;
    private V value;

    public MyEntry() {
    }

    public MyEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(K k) {
        this.key = k;
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
        return (this.key ==  null ? getKey() == null : getKey().equals(entry.getKey()) &&
                this.value == null ? getValue() == null : getValue().equals(entry.getValue()));
    }

}
