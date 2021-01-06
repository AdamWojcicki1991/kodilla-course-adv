package com.kodilla.webflux;

import reactor.core.publisher.Flux;

public class FirstFluxCheck {
    public static void main(String[] args) {
        Book b1 = new Book("Title1", "Author1", 2000);
        Book b2 = new Book("Title2", "Author2", 2001);
        Flux<Book> bookFlux = Flux.just(b1, b2);
        bookFlux = bookFlux.concatWith(Flux.error(new Exception("Test exception")));
        bookFlux.subscribe(System.out::println, FirstFluxCheck::handleException);
    }

    private static void handleException(Throwable exception) {
        System.out.println("There was an error: " + exception);
    }
}
