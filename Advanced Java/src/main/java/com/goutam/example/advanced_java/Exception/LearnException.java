package com.goutam.example.advanced_java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Exception {
    public static void main(String[] args) {

    }
    public void Readfile(String filename)  {
        File file = new File(filename);
        FileReader fr = new FileReader(file);
    }
}
