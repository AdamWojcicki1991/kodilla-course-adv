package com.kodilla.kodillajms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class KodillaJmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(KodillaJmsApplication.class, args);
    }

}
