package com.isikenes.springcore.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach{
    @Override
    public String getWorkout() {
        return "100 squats!";
    }

    @PostConstruct
    public void myInit() {
        System.out.println(getClass().getSimpleName()+" is initialized");
    }

    @PreDestroy
    public void myDestroy() {
        System.out.println(getClass().getSimpleName()+" is destroyed");
    }


}
