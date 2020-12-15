package com.kodilla.exercise.service;

import com.kodilla.exercise.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class UserServiceConfiguration {
    @Bean
    UserService userService(UserRepository repository) {
        return new UserServiceImpl(repository);
    }
}
