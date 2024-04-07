package com.isikenes.mvcintro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class DemoController {

    @GetMapping("/date")
    public String dateMethod(Model theModel) {

        theModel.addAttribute("theDate", new Date());

        return "datepage";
    }
}
