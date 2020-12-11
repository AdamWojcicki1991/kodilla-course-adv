package com.kodilla.library.repository;

import com.kodilla.library.domain.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();

    void save(Book book);

    void deleteByIndex(int index);
}
