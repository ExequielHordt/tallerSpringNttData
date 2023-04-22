package com.bootcamp.exercise1.service;

import com.bootcamp.exercise1.interfaces.MessageInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageService implements MessageInterface {

    @Value("${default.message}")
    private String message;

    public String getMessage() {
        return message;
    }
}
