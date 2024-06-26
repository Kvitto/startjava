package com.startjava.graduation.bookshelf;

public class Book {
    private final String author;
    private final String title;
    private final int published;
    private final int infoLength;

    public Book(String author, String title, int published) {
        this.author = author;
        this.title = title;
        this.published = published;
        infoLength = toString().length();
    }

    public String getTitle() {
        return title;
    }

    public int getInfoLength() {
        return infoLength;
    }

    @Override
    public String toString() {
        return author + ", " + title + ", " + published;
    }
}