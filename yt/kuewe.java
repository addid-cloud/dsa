package yt;

import java.util.LinkedList;
import java.util.Queue;

public class kuewe {
    public static void main(String[] args) {
        // fist in first out FIFO
        // enque add items
        // deque remove items
        Queue<String> queue = new LinkedList<String>();
        queue.offer("keren");
        queue.offer("chad");
        queue.offer("Steve");
        queue.offer("harold");
        System.out.println(queue.peek()); // kepalanya / paling awal
        queue.poll();
        System.out.println(queue);
        //uses of queue
        // keyboard buffer
        // printer queue
        // used in linkedlist, priorityqueue, bfs
    }
}
