package com.springbootdemo.mycoolapp.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;

@Component
// @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {
    
    
    // define our init method
    // @PostConstruct
    // public void doMyStartupStuff() {
    //     System.out.println("CricketCoach: inside of doMyStartupStuff");
    // }

    // @PreDestroy
    // public void doMyCleanupStuff() {
    //     System.out.println("CricketCoach: inside of doMyCleanupStuff");
    // }

    public CricketCoach() {
        System.out.println("CricketCoach: inside no-arg constructor");
    }

        @Override
        public String getDailyWorkout() {
            return "Practice fast bowling for 15 minutes";
        }
}
