package com.example.testtest.exceptions;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException() {
        super("Book not found in database!");
    }
}
