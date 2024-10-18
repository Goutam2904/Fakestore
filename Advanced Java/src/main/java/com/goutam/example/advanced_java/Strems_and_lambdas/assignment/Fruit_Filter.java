package com.goutam.example.advanced_java.Strems_and_lambdas.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Fruit_Filter {

    public static List<String> filterFruitsStartingWithA(List<String> fruits) {
        final String s = "A";
        List<String> filteredFruits = fruits.stream()
                .filter(e -> e.charAt(0) == 'A')
                .collect(Collectors.toList());
        return filteredFruits;
    }
}


