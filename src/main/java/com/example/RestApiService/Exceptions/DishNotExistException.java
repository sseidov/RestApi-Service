package com.example.RestApiService.Exceptions;

public class DishNotExistException extends Exception {
    public DishNotExistException(String message) {
        super(message);
    }
}
