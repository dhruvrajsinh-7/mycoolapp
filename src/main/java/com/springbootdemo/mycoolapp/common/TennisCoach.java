package com.springbootdemo.mycoolapp.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
// @Primary
public class TennisCoach implements Coach {

    public TennisCoach() {
        System.out.println("TennisCoach: inside no-arg constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

}
