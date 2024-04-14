package com.isikenes.mvcsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MVCController {

    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @GetMapping("/list")
    public String showList() {
        return "list-page";
    }

    @GetMapping("/system")
    public String showSystem() {
        return "system-page";
    }
}
