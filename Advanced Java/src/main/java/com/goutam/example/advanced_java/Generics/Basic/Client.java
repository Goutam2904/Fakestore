package com.goutam.example.advanced_java.Generics;


import java.net.Inet4Address;

public class Client {
    public static void main(String[] args) {
        Test_class test = new Test_class();
        String a = "Test";
        Integer b = 2;
        test.setFirst(a);
        test.setSecond(b);

        Converter converter = new Converter();

       converter.test(test);


    }

}
