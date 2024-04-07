package com.isikenes.SpringLearning.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerDemo {

    //injecting property name
    @Value("${developer.name}")
    private String devName;

    @GetMapping("/")
    public String sayHello() {
        return "Hello Universe!";
    }

    @GetMapping("/me")
    public String me() {
        return "I'm "+devName+"!";
    }
}
