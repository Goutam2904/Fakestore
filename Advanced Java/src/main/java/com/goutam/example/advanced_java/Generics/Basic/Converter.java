package com.goutam.example.advanced_java.Generics;

public class Converter {


    public void test(Test_class t) {
        String i = (String) t.getFirst();
        System.out.println(i);
        Integer i2 = (Integer)t.getSecond();
        System.out.println(i2);
    }
}
