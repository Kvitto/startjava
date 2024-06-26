package com.startjava.graduation.bookshelf;

import java.util.Arrays;

public class Bookshelf {
    public static final int BOOKSHELF_SIZE = 10;
    private int bookAmount;
    private final Book[] books = new Book[BOOKSHELF_SIZE];

    public Book[] getBooks() {
        return books;
    }

    public int getBookAmount() {
        return bookAmount;
    }

    public void add(Book book) {
        books[bookAmount++] = book;
    }

    public void delete(Book book) {
        if (book == null) return;
        int index = indexBook(book);
        System.arraycopy(books, index + 1, books, index, bookAmount - index);
        books[--bookAmount] = null;
    }

    public Book find(String title) {
        for (Book book : books) {
            if (book == null) {
                break;
            }
            if (title.equals(book.getTitle())) {
                return book;
            }
        }
        return null;
    }

    public int availableShelves() {
        return BOOKSHELF_SIZE - bookAmount;
    }

    public void clear() {
        Arrays.fill(books, 0, bookAmount, null);
        bookAmount = 0;
    }

    private int indexBook(Book book) {
        for (int i = 0; i < BOOKSHELF_SIZE; i++) {
            if (books[i] == null) break;
            if (book.equals(books[i])) return i;
        }
        return -1;
    }
}
