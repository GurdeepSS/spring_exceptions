package com.spring.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({ "com.spring.**" })
@SpringBootApplication
public class SpringExceptionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringExceptionsApplication.class, args);
    }
}
