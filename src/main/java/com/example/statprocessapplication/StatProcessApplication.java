package com.example.statprocessapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StatProcessApplication {

    public static void main(String[] args) {
        SpringApplication.run(StatProcessApplication.class, args);
    }

}
