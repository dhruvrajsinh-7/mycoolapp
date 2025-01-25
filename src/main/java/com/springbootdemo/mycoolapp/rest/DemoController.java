package com.springbootdemo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootdemo.mycoolapp.common.Coach;

@RestController
public class DemoController {
    //define a private field for the dependency
    private Coach coach;
    private Coach anotherCoach;
    //define a constructor for dependency injection
    // @Autowired
    // public DemoController(Coach theCoach) {
    //     coach = theCoach;
    // }
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach,
                          @Qualifier("cricketCoach") Coach theanotherCoach  
    ) {
        System.out.println("DemoController: inside constructor");
        coach = theCoach;
        anotherCoach = theanotherCoach;
    }

    @GetMapping("/newcheck")
    public String check() {
        return "comparing beans : coach and anotherCoach " + (coach == anotherCoach);
    }

    //define endpoint for "/dailyworkout"
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }
}   

