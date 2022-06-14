package com.example.RestApiService.Exceptions;

public class DishAlreadyExistException extends Exception{
    public DishAlreadyExistException(String message) {
        super(message);
    }
}
