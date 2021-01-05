package com.kodilla.bytebuddy;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class BuddyApp {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//  Method modification by Instrumentation API
//        Class<?> dynamicBookClass = new ByteBuddy()
//                .subclass(Book.class)
//                .method(ElementMatchers.named("toString"))
//                .intercept(FixedValue.value("Hello my Buddy!"))
//                .make()
//                .load(Book.class.getClassLoader(), WRAPPER)
//                .getLoaded();
//
//        Class[] parameterTypes = { String.class, String.class, int.class };
//        System.out.println(dynamicBookClass.getDeclaredConstructor(parameterTypes).newInstance("title", "author", 2010));

        List<Book> books = BooksGenerator.generate(100);
        BooksFilter booksFilter = new BooksFilter(books);
        List<Book> filteredBooks = booksFilter.onlyBooksOlderThan(20);
        System.out.println(filteredBooks.size());
    }
}
