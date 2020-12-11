package com.kodilla.exercise.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class User {
    String login;
    String email;
}
