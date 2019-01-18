package com.example.rocketmqdemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RocketmqDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(RocketmqDemo1Application.class, args);
    }

}

