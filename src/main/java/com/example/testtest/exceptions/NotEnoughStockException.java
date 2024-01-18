package com.example.testtest.exceptions;

public class NotEnoughStockException extends RuntimeException{
    public NotEnoughStockException() {
        super("Not enough stock!");
    }
}
