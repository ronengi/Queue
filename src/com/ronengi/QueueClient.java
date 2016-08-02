package com.ronengi;


/**
 * Created by stimpy on 8/2/16.
 */
public class QueueClient {

    public static void main(String[] args) {

        // LinkedListQueue<String> qu = new LinkedListQueue<>();
        ArrayQueue<String> qu = new ArrayQueue<>();

        qu.enqueue("this");
        System.out.println(qu);

        qu.enqueue("is");
        System.out.println(qu);

        qu.enqueue("a");
        System.out.println(qu);

        System.out.println(qu.dequeue());
        System.out.println(qu);

        qu.enqueue("queue");
        System.out.println(qu);

        qu.enqueue("of");
        System.out.println(qu);

        // qu.enqueue("strings");
        // System.out.println(qu);


        while (!qu.isEmpty()) {
            System.out.println(qu.dequeue());
            System.out.println(qu);
        }

    }


}
