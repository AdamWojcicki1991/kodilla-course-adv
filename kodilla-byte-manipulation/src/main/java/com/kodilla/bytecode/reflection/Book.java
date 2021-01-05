package com.kodilla.bytecode.reflection;

public class Book {
    private String title;
    private String signature;
    private int year;

    private boolean rentBook() {
        System.out.println("Book is already rented");
        return false;
    }

    private void setDetails(String signature, int year) {
        this.signature = signature;
        this.year = year;
    }

    public Book(String title, String signature, int year) {
        this.title = title;
        this.signature = signature;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getSignature() {
        return signature;
    }

    public int getYear() {
        return year;
    }

}
