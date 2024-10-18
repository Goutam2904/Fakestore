package com.goutam.example.advanced_java.Callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {

    private List<Integer> list;
    private ExecutorService es;
    public Sorter(List<Integer> list, ExecutorService es) {
        this.list = list;
        this.es = es;
    }
    @Override
    public List<Integer> call() throws Exception {
        if(list.size()<=1){
            return list;
        }
        int mid = list.size() / 2;
        List<Integer> leftsortedList = new ArrayList<>();
        List<Integer> rightsortedList = new ArrayList<>();
        for (int i = 0; i < mid; i++) {
            leftsortedList.add(list.get(i));
        }
        for (int i = mid; i < list.size(); i++) {
            rightsortedList.add(list.get(i));
        }
        Sorter left = new Sorter(leftsortedList,es);
        Sorter right = new Sorter(rightsortedList,es);

        Future<List<Integer>> leftsorter = es.submit(left);
        Future<List<Integer>> rightsorter = es.submit(right);

        int i = 0, j =0;

        List<Integer> sortedList = new ArrayList<>();
        List<Integer> leftarraytosort = leftsorter.get();
        List<Integer> rightarraytosort = rightsorter.get();
        while (i < leftarraytosort.size() && j < rightarraytosort.size()) {
            if (leftarraytosort.get(i) < rightarraytosort.get(j)) {
                sortedList.add(leftarraytosort.get(i));
                i++;
            }
            else{
                sortedList.add(rightarraytosort.get(j));
                j++;
            }
        }
        while (i < leftarraytosort.size()) {
            sortedList.add(leftarraytosort.get(i));
            i++;
        }
        while (j < rightarraytosort.size()) {
            sortedList.add(rightarraytosort.get(j));
            j++;
        }

        return sortedList;
    }
}
