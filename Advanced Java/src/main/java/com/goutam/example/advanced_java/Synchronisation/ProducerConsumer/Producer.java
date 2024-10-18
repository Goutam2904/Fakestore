package com.goutam.example.advanced_java.Semophores;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    private Queue<Object> queue;
    Semaphore producedsemaphore;
    Semaphore consumedSemaphore;
    public Producer(Queue<Object> queue, Semaphore producedsemaphore, Semaphore consumedSemaphore) {
        this.queue = queue;
        this.producedsemaphore = producedsemaphore;
        this.consumedSemaphore = consumedSemaphore;
    }

    @Override
    public void run() {
        while(true) {
            try {
                producedsemaphore.acquire();
                if (queue.size() < 6) {
                    queue.add(new Object());
                    System.out.println("Producing " + queue.size());
                }
                consumedSemaphore.release();
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            }
        }
    }

