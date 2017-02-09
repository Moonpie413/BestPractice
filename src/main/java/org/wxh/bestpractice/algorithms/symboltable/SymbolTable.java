package org.wxh.bestpractice.algorithms.symboltable;

/**
 * Created by maroon on 17-1-28.
 * DES: 符号表接口
 */
public interface SymbolTable<Key extends Comparable<Key>, Value> {
    void put(Key key, Value value);
    Value get(Key key);
    void delete(Key key);
    boolean contains(Key key);
    boolean isEmpty();
    int size();
}
