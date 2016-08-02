package com.ronengi;


import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Created by stimpy on 8/2/16.
 */
public class ArrayQueue<T> implements Queue<T> {

    private T[] q;
    private int N;
    private int first;
    private int last;


    public ArrayQueue() {
        this.q = (T[]) new Object[1];
        this.N = 0;
        this.first = 0;
        this.last = 0;
    }


    @Override
    public void enqueue(T item) {
        if (this.N == q.length)
            resize(2 * q.length);
        q[last]  = item;
        ++last;
        if (last == q.length)
            last = 0;
        ++this.N;
    }

    private void resize(int capacity) {
        assert capacity >= this.N;
        T[] copy = (T[]) new Object[capacity];
        for (int i = 0; i < this.N; ++i)
            copy[i] = q[(first + i) % q.length];
        q = copy;
        first = 0;
        last = this.N;
    }


    @Override
    public T dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");
        T item = q[first];
        q[first] = null;
        ++first;
        --this.N;
        if (first == q.length)
            first = 0;
        if (this.N > 0  &&  this.N == q.length / 4)
            resize(q.length / 2);
        return item;
    }

    @Override
    public boolean isEmpty() {
        return this.N == 0;
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

    public String toStringAsIs() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q.length; ++i)
            sb.append("[").append(q[i]).append("]").append("\t");
        return sb.toString();
    }


    @Override
    public Iterator<T> iterator() {
        return new ArrayQueueIterator();
    }


    private class ArrayQueueIterator implements Iterator<T> {

        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < N;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            T item = q[(first + i) % q.length];
            ++i;
            return item;
        }

    }

}
