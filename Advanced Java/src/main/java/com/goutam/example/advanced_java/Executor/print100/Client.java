package com.goutam.example.advanced_java.Thread.print100;

public class Client {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            print_1to100 p = new print_1to100(i);
            Thread t1 = new Thread(p);
            t1.start();
        }
    }
}
