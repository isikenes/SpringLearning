package com.isikenes.mvcintro.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/form")
    public String showForm() {
        return "formpage";
    }

    @PostMapping("/hello")
    public String hello(@RequestParam("username") String username, Model model) {

        String message="Hello "+username.toUpperCase();

        model.addAttribute("message",message);

        return "hellopage";
    }

    /*
    @RequestMapping("/hello")
    public String hello(HttpServletRequest  request, Model model) {

        String username=request.getParameter("username");
        String message="Hello "+username.toUpperCase();

        model.addAttribute("message",message);

        return "hellopage";
    }

     */
}
