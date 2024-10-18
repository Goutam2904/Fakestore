package com.goutam.example.advanced_java.Thread.print100;

public class print_1to100 implements Runnable {
    int number;
    public print_1to100(int i){
        number = i;
    }
    public void run(){
        System.out.println(Thread.currentThread().getName() + " :"+number);
    }

}
