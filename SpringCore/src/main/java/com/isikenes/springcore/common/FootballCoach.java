package com.isikenes.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{
    @Override
    public String getWorkout() {
        return "100 push-ups!";
    }
}
