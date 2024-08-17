package com.goutam.example.fakestoreapi.Exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class Invalid_Input extends Exception {
    public Invalid_Input() {

    }
    public Invalid_Input(String message) {
        super(message);
    }

}
