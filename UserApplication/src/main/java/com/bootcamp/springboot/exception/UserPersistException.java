package com.bootcamp.springboot.exception;

public class UserPersistException extends RuntimeException {

    public UserPersistException(String message) {
        super(message);
    }
}
