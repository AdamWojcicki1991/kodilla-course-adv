package com.kodilla.bytebuddy.exercise;

import java.util.stream.IntStream;

public class UserApp {
    public static void main(String[] args) {
        User user = new User();
        IntStream.range(1, 6).forEach(invoke -> user.doSomething());
    }
}
