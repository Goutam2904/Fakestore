package com.goutam.example.fakestoreapi.ControllerAdvice;

import com.goutam.example.fakestoreapi.DTO.ErrorDTO;
import com.goutam.example.fakestoreapi.Exception.Invalid_Input;
import com.goutam.example.fakestoreapi.Exception.ProductnotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(Invalid_Input.class)
    ResponseEntity<ErrorDTO>handleInvalidInput(Invalid_Input invalid_input){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setCode("001");
        errorDTO.setMsessage(invalid_input.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(ProductnotFound.class)
    ResponseEntity<ErrorDTO>ProductnotFound(ProductnotFound productnotFound){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setCode("002");
        errorDTO.setMsessage(productnotFound.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    ResponseEntity<ErrorDTO>Exception(Exception exception){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setCode("500");
        errorDTO.setMsessage("Incorrect Parameter");
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }
}
