package com.springdemo.test;

public interface SortedList<T>{
    void add(T value);
    T get(int index);
    int size();
}
