package com.goutam.example.advanced_java.Strems_and_lambdas.assignment;

import java.util.stream.Stream;

public class allmatch {
    static boolean areAllEven(Stream<Integer> stream){
        // write code here
        return stream.allMatch(e -> e % 2 == 0);

    }
}
