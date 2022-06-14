package com.example.RestApiService.Exceptions;

public class CustomerAlreadyExistException extends Exception {
    public CustomerAlreadyExistException(String message) {
        super(message);
    }
}
