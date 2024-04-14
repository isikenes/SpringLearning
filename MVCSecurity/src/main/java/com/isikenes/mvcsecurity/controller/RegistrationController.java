package com.isikenes.mvcsecurity.controller;

import com.isikenes.mvcsecurity.entity.User;
import com.isikenes.mvcsecurity.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {
    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegister(Model model) {
        model.addAttribute("user",new User());

        return "register-page";
    }

    @PostMapping("/processRegistration")
    public String processRegistrationForm(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "register-page";
        }
        userService.registerUser(user);

        return "redirect:/login";
    }


}
