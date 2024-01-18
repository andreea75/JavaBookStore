package com.example.testtest.exceptions.handler;

import com.example.testtest.exceptions.BookDetailsNotFoundException;
import com.example.testtest.exceptions.BookNotFoundException;
import com.example.testtest.exceptions.NotEnoughStockException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(
            {
                    BookNotFoundException.class,
                    BookDetailsNotFoundException.class,
                    NotEnoughStockException.class
            })
    public ResponseEntity handle(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}

