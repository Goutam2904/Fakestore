package com.goutam.example.advanced_java.Thread;

public class Client {
    public static void main(String[] args) {
        Hello_World obj = new Hello_World();
        System.out.println(Thread.currentThread().getName());
            Thread t = new Thread(obj);
            t.start();
            System.out.println(Thread.currentThread().getName());
    }
}
