package com.goutam.example.advanced_java.Strems_and_lambdas.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Distinct_numbers {
    public static List<Integer> getDistinctNumbers(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        return distinctNumbers;
    }
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 3, 5, 6, 1, 7, 8, 9, 7);
        List<Integer> distinctNumbers = getDistinctNumbers(numbers);
        System.out.println("Distinct numbers: " + distinctNumbers);

        numbers = Arrays.asList(5,5,5,6,6,6,4,4,4);
        distinctNumbers = getDistinctNumbers(numbers);
        System.out.println("Distinct numbers: " + distinctNumbers);

    }
}
