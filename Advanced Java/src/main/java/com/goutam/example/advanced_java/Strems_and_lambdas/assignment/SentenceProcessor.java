package com.goutam.example.advanced_java.Strems_and_lambdas.assignment;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class SentenceProcessor {
    public static int processSentences(List<String> sentences) {
        //code here
        int average = (int)sentences.stream().
                filter(sentence -> sentence.contains("Java")).
                mapToInt(String::length).
                average()
                .orElse(0);
        return (int) average;
    }

    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
                "Java is a programming language.",
                "Python is also a good language.",
                "Java stream processing is powerful.",
                "C++ is not as popular as Java."
        );

        int averageLength = SentenceProcessor.processSentences(sentences);
        System.out.println(averageLength);

        sentences = Arrays.asList(
                "Python is a programming language.",
                "JS is used for web development.",
                "Ruby is known for its simplicity.",
                "java is good"
        );

        averageLength = SentenceProcessor.processSentences(sentences);
        System.out.println(averageLength);
    }
}

