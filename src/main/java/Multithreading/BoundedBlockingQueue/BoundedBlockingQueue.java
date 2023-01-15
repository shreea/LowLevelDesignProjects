package Multithreading.BoundedBlockingQueue;

import java.util.LinkedList;
import java.util.Queue;

class BoundedBlockingQueue {
    Queue<Integer> q;
    int capacity;
    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        q = new LinkedList();
    }

    public void enqueue(int element) throws InterruptedException {
        synchronized(this) {
            while (q.size() == capacity) {
                wait();
            }
            q.add(element);
            System.out.println("added element " + element);
            notifyAll();
        }
    }

    public int dequeue() throws InterruptedException {
        synchronized(this) {
            while (q.size() == 0) {
                wait();
            }
            int a = q.poll();
            System.out.println("removed element " + a);
            notifyAll();
            return a;
        }
    }

    public int size() {
        return q.size();
    }
}