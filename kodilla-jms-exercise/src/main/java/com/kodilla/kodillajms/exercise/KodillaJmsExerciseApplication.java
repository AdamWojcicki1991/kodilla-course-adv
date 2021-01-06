package com.kodilla.kodillajms.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class KodillaJmsExerciseApplication {

    public static void main(String[] args) {
        SpringApplication.run(KodillaJmsExerciseApplication.class, args);
    }

}
