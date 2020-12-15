package com.kodilla.exercise.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class RepositoryConfiguration {
    @Bean
    UserRepository repository() {
        return new InMemoryUserRepository();
    }
}
