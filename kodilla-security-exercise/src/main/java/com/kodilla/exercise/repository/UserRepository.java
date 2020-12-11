package com.kodilla.exercise.repository;

import com.kodilla.exercise.domain.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    void save(User user);

    void delete(User user);
}
