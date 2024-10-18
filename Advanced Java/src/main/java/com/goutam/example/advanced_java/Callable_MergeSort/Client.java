package com.goutam.example.advanced_java.Callable;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = List.of(1,6,2,5,7,9,4,3);
        ExecutorService executor = Executors.newCachedThreadPool();
        Sorter sorter = new Sorter(list, executor);
        Future<List<Integer>> future = executor.submit(sorter);
        System.out.println("Work In Progress");
        System.out.println(future.get());
    }
}
