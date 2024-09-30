package com.angel.restexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.angel.restexample"})
public class RestexampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestexampleApplication.class, args);
    }

}
