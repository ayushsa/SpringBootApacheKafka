package com.research;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootHelloWorldApplication {

    public static void main(String[] args) {

        SpringApplication.run(
                new Object[]{SpringBootHelloWorldApplication.class}, args);

        System.out.println("Spring Boot KAFKA Running ...");
    }
}