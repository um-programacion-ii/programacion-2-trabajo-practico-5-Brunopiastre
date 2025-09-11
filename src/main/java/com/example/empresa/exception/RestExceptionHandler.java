package com.example.empresa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> notFound(NoSuchElementException ex){
        return Map.of("error","Recurso no encontrado");
    }
}
