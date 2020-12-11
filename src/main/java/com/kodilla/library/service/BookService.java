package com.kodilla.library.service;

import com.kodilla.library.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();

    void createBook(Book book);

    void deleteBook(int index);
}
