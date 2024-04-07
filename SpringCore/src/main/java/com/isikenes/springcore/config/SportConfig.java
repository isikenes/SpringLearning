package com.isikenes.springcore.config;

import com.isikenes.springcore.common.Coach;
import com.isikenes.springcore.common.FootballCoach;
import com.isikenes.springcore.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    //springin arkaplanda yaptigini manuel yapmak:
    @Bean("swimmer")
    public Coach swimCoach() {
        return new SwimCoach();
    }

    //hem @component hem @bean birlikte çalışmaz, override açmak gerekir
    /*
    @Bean("footballCoach")
    public Coach footballCoach() {
        System.out.println("Custom football Coach");
        return new FootballCoach();
    }*/
}
