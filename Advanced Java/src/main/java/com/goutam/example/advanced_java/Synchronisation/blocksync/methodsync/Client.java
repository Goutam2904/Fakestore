package com.goutam.example.advanced_java.Synchronisation.methodsync;

public class Client {
    public static void main(String[] args) throws InterruptedException {
            Count count = new Count();
            count.value=0;
            Adder add = new Adder(count);
            Subtractor subtractor = new Subtractor(count);
            Thread thread = new Thread(add);
            Thread thread2 = new Thread(subtractor);
            thread.start();
            thread2.start();
            thread.join();
            thread2.join();

            System.out.println(count.getValue());
    }
    }

