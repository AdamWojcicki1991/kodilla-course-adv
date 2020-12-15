package com.kodilla.adv.service;

import com.kodilla.adv.repository.BookRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class BookServiceConfiguration {
    @Bean
    BookService bookService(BookRepository repository) {
        return new BookServiceImpl(repository);
    }
}
