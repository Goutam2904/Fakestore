package com.goutam.example.advanced_java.Strems_and_lambdas.assignment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AnimalSorter {
    public static List<String> sortAnimalsByLengthDescending(List<String> animals) {

        List<String> sortedAnimals = animals.stream().sorted(((ele1,ele2) -> ele2.length()-ele1.length())).collect(Collectors.toList());
        return sortedAnimals;
                //add your code here
    }

    public static void main(String[] args) {
        List<String> animals = Arrays.asList("zebra", "lion", "tiger", "elephant", "giraffe");
        List<String> sortedAnimals = sortAnimalsByLengthDescending(animals);
        System.out.println(sortedAnimals);

        animals = Arrays.asList("cat","dog","animal-x","elephant","mouse");
        sortedAnimals = sortAnimalsByLengthDescending(animals);
        System.out.println(sortedAnimals);

        animals = Arrays.asList();
        sortedAnimals = sortAnimalsByLengthDescending(animals);
        System.out.println(sortedAnimals);

        animals = Arrays.asList("a","b","d","c","a");
        sortedAnimals = sortAnimalsByLengthDescending(animals);
        System.out.println(sortedAnimals);
    }
}
