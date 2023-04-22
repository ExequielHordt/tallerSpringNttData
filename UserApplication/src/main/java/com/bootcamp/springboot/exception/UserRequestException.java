package com.bootcamp.springboot.exception;

public class UserRequestException extends RuntimeException {

    public UserRequestException(String message) {
        super(message);
    }
}
