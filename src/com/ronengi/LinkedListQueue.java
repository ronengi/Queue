package com.ronengi;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by stimpy on 8/2/16.
 */
public class LinkedListQueue<T> implements Queue<T> {

    private Node first;
    private Node last;
    private int N;


    public LinkedListQueue() {
        this.first = null;
        this.last = null;
        this.N = 0;
    }


    @Override
    public void enqueue(T item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
        ++this.N;
    }


    @Override
    public T dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");
        T item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;
        --this.N;
        return item;
    }


    @Override
    public boolean isEmpty() {
        return first == null;
    }


    @Override
    public int size() {
        return this.N;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T i : this)
            sb.append("[").append(i).append("]").append("\t");
        return sb.toString();
    }


    @Override
    public Iterator<T> iterator() {
        return new LinkedListQueueIterator();
    }


    private class LinkedListQueueIterator implements Iterator<T> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            T item = current.item;
            current = current.next;
            return item;
        }

    }


    private class Node {
        private T item;
        private Node next;
    }

}
