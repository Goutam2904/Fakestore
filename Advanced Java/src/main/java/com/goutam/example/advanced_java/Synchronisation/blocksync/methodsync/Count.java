package com.goutam.example.advanced_java.Synchronisation.methodsync;

public class Count {
    public int value = 0;

    public synchronized void increment(int i) {
        value += i;
    }

    public int getValue() {
        return value;
    }
}
