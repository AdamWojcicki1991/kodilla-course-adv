package com.kodilla.exercise.repository;


import com.kodilla.exercise.domain.User;

import java.util.ArrayList;
import java.util.List;

class InMemoryUserRepository implements UserRepository {
    private List<User> books = new ArrayList<>();

    @Override
    public List<User> findAll() {
        return books;
    }

    @Override
    public void save(User book) {
        books.add(book);
    }

    @Override
    public void delete(User user) {
        books.remove(user);
    }
}
