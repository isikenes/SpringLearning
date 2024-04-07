package com.isikenes.mvcintro.controller;

import com.isikenes.mvcintro.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${pets}")
    private List<String> pets;

    @GetMapping("/studentForm")
    public String studentForm(Model model) {

        Student student=new Student();

        model.addAttribute("student",student);
        model.addAttribute("countries",countries);
        model.addAttribute("pets",pets);

        return "student-form";
    }


    @PostMapping("/processStudent")
    public String processForm(@ModelAttribute("student") Student student) {
        return "student-saved";
    }

}
