package com.ronengi;


/**
 * Created by stimpy on 8/2/16.
 */
public interface Queue<T> extends Iterable<T>{
    public void enqueue(T item);
    public T dequeue();
    public boolean isEmpty();
    public int size();
}
