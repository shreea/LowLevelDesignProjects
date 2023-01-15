package Multithreading.BoundedBlockingQueue;

import Multithreading.BoundedBlockingQueue.BoundedBlockingQueue;

public class Client {
    public static void main (String[] args) {
        BoundedBlockingQueue blockingQueue = new BoundedBlockingQueue(10);
        Thread producer = new Thread(() -> {
           for(int i = 0; i < 10; ++i) {
               try {
                   blockingQueue.enqueue(i);
                   Thread.sleep(500);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        });
        Thread consumer = new Thread(() -> {
            while(true) {
                try {
                    blockingQueue.dequeue();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        consumer.start();
        producer.start();
    }
}
