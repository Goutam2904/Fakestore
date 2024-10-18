package com.goutam.example.advanced_java.Strems_and_lambdas.assignment;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class getOdd {
    static List<Integer> getOdd(Stream<Integer> stream){
        // write code here
         List<Integer> oddnumbers = stream
                 .filter(i -> i % 2 != 0)
                 .collect(Collectors.toList());
        return oddnumbers;
    }

}
