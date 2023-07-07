package com.cardKeeper.cardKeeperAPI.Infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentConversionNotSupportedException;

@RestControllerAdvice
public class ErrorHandler {
    //Handles the 404 error message
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity Handle404(){
        //Simply returns the 404 message
        return ResponseEntity.notFound().build();
    }
    //Handles the 400 error message
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity Handle400(MethodArgumentNotValidException ex){
        //Gets the field error and stores them into the var err
        var err = ex.getFieldErrors();
        //Gets the err, throws it into the DTO, gets back the info and turns it into a list
        return ResponseEntity.badRequest().body(err.stream().map(Err400::new).toList());
    }

    //Just a local DTO since its going to be used just once
    private record Err400(String field, String msg){
        //Usual DTO stuff to get the error and return them
        public Err400(FieldError err){
            this(err.getField(), err.getDefaultMessage());
        }

    }
}
