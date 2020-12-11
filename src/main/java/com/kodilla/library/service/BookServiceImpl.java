package com.kodilla.library.service;

import com.kodilla.library.domain.Book;
import com.kodilla.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
class BookServiceImpl implements BookService {
    private final BookRepository repository;

    @Override
    public List<Book> getBooks() {
        return repository.findAll();
    }

    @Override
    public void createBook(Book book) {
        repository.save(book);
    }

    @Override
    public void deleteBook(int index) {
        repository.deleteByIndex(index);
    }
}
