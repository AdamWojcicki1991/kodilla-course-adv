package com.kodilla.adv.service;

import com.kodilla.adv.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();

    void createBook(Book book);

    void deleteBook(int index);
}
