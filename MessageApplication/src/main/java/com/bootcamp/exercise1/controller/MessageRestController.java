package com.bootcamp.exercise1.controller;

import com.bootcamp.exercise1.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageRestController {

    @Autowired
    private MessageService service;

    @GetMapping("/message")
    public String index() {
        return service.getMessage();
    }
}
