package com.isikenes.springcore.rest;

import com.isikenes.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach coach;

    //constructor injection
    @Autowired
    public DemoController(@Qualifier("swimmer") Coach coach) {
        this.coach = coach;
    }


    /*
    //setter injection
    //use setter injection when you have optional dependencies
    @Autowired
    public void setCoach(Coach coach){
        this.coach=coach;
    }*/

    @GetMapping("/")
    public String sayHello() {
        return "Homepage";
    }

    @GetMapping("/dailyworkout")
    public String getWorkout() {
        return coach.getWorkout();
    }

}
