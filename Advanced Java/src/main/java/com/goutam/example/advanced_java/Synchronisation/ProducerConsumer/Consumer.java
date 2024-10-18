package com.goutam.example.advanced_java.Semophores;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    private Queue<Object> queue;
    private Semaphore producedemaphore;
    private Semaphore consumedSemaphore;

    public Consumer(Queue<Object> queue, Semaphore producedSemaphore, Semaphore consumedSemaphore) {
        this.queue = queue;
        this.producedemaphore = producedSemaphore;
        this.consumedSemaphore = consumedSemaphore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                consumedSemaphore.acquire();
                if (queue.size() > 0) {
                    System.out.println("Consuming " + queue.size());
                    queue.poll();
                }
                producedemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            }
    }
}
