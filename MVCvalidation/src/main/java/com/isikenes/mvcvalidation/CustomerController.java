package com.isikenes.mvcvalidation;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CustomerController {

    //whitespace engellemek icin:
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor editor=new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, editor);
    }

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("customer",new Customer());

        return "form-page";

    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer,
                              BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "form-page";
        } else{
            return "success-page";
        }

    }

}
