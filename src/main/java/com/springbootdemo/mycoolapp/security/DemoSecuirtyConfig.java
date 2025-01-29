package com.springbootdemo.mycoolapp.security;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecuirtyConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailManager() {
        UserDetails john = User.builder()
            .username("john")
            .password("{noop}johnwick")
            .roles("EMPLOYEE")
            .build();

        UserDetails mary = User.builder()
            .username("mary")
            .password("kom")
            .roles("EMPLOYEE","MANAGER")
            .build();

        UserDetails susan = User.builder()
            .username("susan")
            .password("hasse")
            .roles("EMPLOYEE","ADMIN","MANAGER")
            .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
            configure -> configure
                .requestMatchers(HttpMethod.GET,"/mycoolapp/api/employees").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET,"/mycoolapp/api/employees/**").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.POST,"/mycoolapp/api/employees").hasAnyRole("MANAGER")
                .requestMatchers(HttpMethod.PUT,"/mycoolapp/api/employees/**").hasAnyRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE,"/mycoolapp/api/employees/**").hasAnyRole("ADMIN")
        );
        http.httpBasic(Customizer.withDefaults());

        // disable csrf
        http.csrf().disable();

        return http.build();
    }
}
