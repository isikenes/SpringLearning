package com.isikenes.SpringLearning.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerDemo {
    @GetMapping("/")
    public String sayHello() {
        return "Hello Universe!";
    }

    @GetMapping("/me")
    public String me() {
        return "I'm Enes Işık!";
    }
}
