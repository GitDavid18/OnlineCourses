package com.codewithmosh.iterator;

public interface IIterator<T> {
    void next();
    boolean hasNext();
    T current();
}
