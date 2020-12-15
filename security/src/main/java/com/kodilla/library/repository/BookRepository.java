package com.kodilla.adv.repository;

import com.kodilla.adv.domain.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();

    void save(Book book);

    void deleteByIndex(int index);
}
