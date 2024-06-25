package com.startjava.graduation.bookshelf;

public class Book {
    private static final int INFO_SPACE = 4;
    private final String author;
    private final String title;
    private final int published;
    private final int info;

    public Book(String author, String title, int published) {
        this.author = author;
        this.title = title;
        this.published = published;
        info = author.length() + title.length() + String.valueOf(published).length() + INFO_SPACE;
    }

    public String getTitle() {
        return title;
    }

    public int getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return author + ", " + title + ", " + published;
    }
}