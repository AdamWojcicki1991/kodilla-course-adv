package com.kodilla.exercise.service;

import com.kodilla.exercise.domain.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    void createUser(User user);

    void deleteUser(User user);
}
