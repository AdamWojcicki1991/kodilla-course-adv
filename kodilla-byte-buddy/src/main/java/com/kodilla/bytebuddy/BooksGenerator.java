package com.kodilla.bytebuddy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BooksGenerator {
    private static final Random random = new Random();

    public static List<Book> generate(int howMuch) {
        List<Book> books = new ArrayList<>();
        for (int n = 0; n < howMuch; n++)
            books.add(randomBook());
        return books;
    }

    private BooksGenerator() {
    }

    private static Book randomBook() {
        return new Book(randomTitle(), randomAuthor(), random.nextInt(30) + 1980);
    }

    private static String randomAuthor() {
        return randomString(10, 20);
    }

    private static String randomTitle() {
        return randomString(5, 30);
    }

    private static String randomString(int minLen, int maxLen) {
        int howLong = random.nextInt(maxLen - minLen) + minLen;
        StringBuilder builder = new StringBuilder();

        for (int n = 0; n < howLong; n++) {
            char c = (char) (random.nextInt(90 - 65) + 65);
            builder.append(c);
        }
        return builder.toString();
    }
}
