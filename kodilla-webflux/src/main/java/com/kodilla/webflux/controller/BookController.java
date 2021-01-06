package com.kodilla.webflux.controller;

import com.kodilla.webflux.BookDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class BookController {
    @GetMapping(value = "/books", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<BookDto> getStrings() {
        return Flux
                .just(new BookDto("Title1", "Author1", 2000),
                      new BookDto("Title2", "Author2", 1991),
                      new BookDto("Title3", "Author3", 2021))
                .delayElements(Duration.ofSeconds(2))
                .log();
    }
}
