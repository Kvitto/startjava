package com.startjava.graduation.bookshelf;

import java.util.Arrays;

public class Bookshelf {
    private static final int CAPACITY = 10;
    private final Book[] books = new Book[CAPACITY];
    private int bookAmount;
    private int length;

    public Book[] getBooks() {
        return Arrays.copyOf(books, bookAmount);
    }

    public int getBookAmount() {
        return bookAmount;
    }

    public int getLength() {
        return length;
    }

    public Book find(String title) {
        if (bookAmount == 0) throw new RuntimeException("Шкаф пуст!");
        for (Book book : getBooks()) {
            if (book.getTitle().equals(title)) return book;
        }
        throw new RuntimeException("В шкафу нет книги: - \"" + title + "\"!");
    }

    public void add(Book book) {
        if (availableShelves() > 0) {
            books[bookAmount++] = book;
            if (book.getLengthInfo() > length) length = book.getLengthInfo();
            return;
        }
        throw new RuntimeException("В шкафу нет места!");
    }

    public void delete(String title) {
        Book book = find(title);
        int index = getIndex(book) + 1;
        System.arraycopy(books, index, books, index - 1, bookAmount - index);
        books[--bookAmount] = null;
        if (book.getLengthInfo() == length) refreshInfo();
    }

    public void clear() {
        Arrays.fill(books, 0, bookAmount, null);
        bookAmount = 0;
    }

    public int availableShelves() {
        return CAPACITY - bookAmount;
    }

    private int getIndex(Book book) {
        Book[] books = getBooks();
        for (int i = 0; i < books.length; i++) {
            if (book.equals(books[i])) return i;
        }
        throw new RuntimeException("Книга \"" + book.getTitle() + "\" отсутствует!");
    }

    private void refreshInfo() {
        length = 0;
        for (Book book : getBooks()) {
            if (book.getLengthInfo() > length) length = book.getLengthInfo();
        }
    }
}
