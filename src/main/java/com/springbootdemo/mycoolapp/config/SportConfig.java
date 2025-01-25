package com.springbootdemo.mycoolapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbootdemo.mycoolapp.common.Coach;
import com.springbootdemo.mycoolapp.common.SwimCoach;

@Configuration
public class SportConfig {

    @Bean("acquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
