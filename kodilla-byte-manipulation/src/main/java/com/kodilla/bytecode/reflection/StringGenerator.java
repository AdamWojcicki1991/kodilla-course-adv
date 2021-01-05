package com.kodilla.bytecode.reflection;

import java.util.Random;

public class StringGenerator {
    private final static int LEFT_LIMIT = 48; // numeral '0'
    private final static int RIGHT_LIMIT = 57; // numeral '9'
    private final static Random RANDOM = new Random();

    public static String generateRandomIndexNumberString(final int targetStringLength) {
        return RANDOM.ints(LEFT_LIMIT, RIGHT_LIMIT)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .replace(0, 1, "" + (RANDOM.nextInt(8) + 1))
                .toString();
    }
}
