package com.startjava.graduation.bookshelf;

import java.util.Arrays;

public class Bookshelf {
    private static final int CAPACITY = 10;
    private final Book[] books = new Book[CAPACITY];
    private int booksAmount;
    private int length;

    public Book[] getBooks() {
        return Arrays.copyOf(books, booksAmount);
    }

    public int getBookAmount() {
        return booksAmount;
    }

    public int getLength() {
        return length;
    }

    public Book find(String title) {
        return books[findIndex(title)];
    }

    public boolean add(Book book) {
        if (availableShelves() > 0) {
            books[booksAmount++] = book;
            if (book.getInfoLength() > length) length = book.getInfoLength();
            return true;
        }
        return false;
    }

    public void delete(String title) {
        int index = findIndex(title);
        int bookInfoLength = books[index].getInfoLength();
        System.arraycopy(books, index + 1, books, index, booksAmount - index - 1);
        books[--booksAmount] = null;
        if (bookInfoLength == length) refreshInfo();
    }

    public void clear() {
        Arrays.fill(books, 0, booksAmount, null);
        booksAmount = 0;
    }

    public int availableShelves() {
        return CAPACITY - booksAmount;
    }

    private int findIndex(String title) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) break;
            if (books[i].getTitle().equals(title)) return i;
        }
        return books.length;
    }

    private void refreshInfo() {
        length = 0;
        for (Book book : getBooks()) {
            if (book.getInfoLength() > length) length = book.getInfoLength();
        }
    }
}
