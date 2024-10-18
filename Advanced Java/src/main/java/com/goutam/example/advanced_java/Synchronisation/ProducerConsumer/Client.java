package com.goutam.example.advanced_java.Semophores;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.*;

public class Client {
    public static void main(String[] args) throws InterruptedException {

        Queue <Object> queue = new ConcurrentLinkedQueue<>();


        Semaphore producedSemaphore = new Semaphore(6);
        Semaphore consumedSemaphore = new Semaphore(0);

        Producer producer = new Producer(queue, producedSemaphore, consumedSemaphore);
        Producer producer2 = new Producer(queue, producedSemaphore, consumedSemaphore);
        Producer producer3 = new Producer(queue, producedSemaphore, consumedSemaphore);
        Producer producer4 = new Producer(queue, producedSemaphore, consumedSemaphore);
        Producer producer5 = new Producer(queue, producedSemaphore, consumedSemaphore);
        Producer producer6 = new Producer(queue, producedSemaphore, consumedSemaphore);

        Consumer consumer = new Consumer(queue,producedSemaphore, consumedSemaphore);
        Consumer consumer2 = new Consumer(queue,producedSemaphore, consumedSemaphore);
        Consumer consumer3 = new Consumer(queue,producedSemaphore, consumedSemaphore);
        Consumer consumer4 = new Consumer(queue,producedSemaphore, consumedSemaphore);

        ExecutorService executors = Executors.newFixedThreadPool(10);

        executors.submit(producer);
        executors.submit(producer2);
        executors.submit(producer3);
        executors.submit(producer4);
        executors.submit(producer5);
        executors.submit(producer6);
        executors.submit(consumer);
        executors.submit(consumer2);
        executors.submit(consumer3);
        executors.submit(consumer4);

        executors.shutdown();

    }
}
