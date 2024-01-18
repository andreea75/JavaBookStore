package com.example.testtest.exceptions;

public class BookDetailsNotFoundException extends RuntimeException{
    public BookDetailsNotFoundException() {
        super("Book details not found in database!");
    }
}
