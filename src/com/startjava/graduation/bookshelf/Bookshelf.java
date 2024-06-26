package com.startjava.graduation.bookshelf;

import java.util.Arrays;

public class Bookshelf {
    public static final int BOOKSHELF_SIZE = 10;
    private final Book[] books = new Book[BOOKSHELF_SIZE];
    private int bookAmount;
    private int length;

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

    public void add(Book book) {
        books[bookAmount++] = book;
        if (book.getInfo() > length) length = book.getInfo();
    }

    public void delete(Book book) {
        if (book == null) return;
        int index = indexBook(book) + 1;
        System.arraycopy(books, index, books, index - 1, bookAmount - index);
        books[--bookAmount] = null;
        if (book.getInfo() == length) refreshInfo();
    }

    public void clear() {
        Arrays.fill(books, 0, bookAmount, null);
        bookAmount = 0;
    }

    public Book[] getBooks() {
        return books;
    }

    public int getBookAmount() {
        return bookAmount;
    }

    public int getLength() {
        return length;
    }

    public int availableShelves() {
        return BOOKSHELF_SIZE - bookAmount;
    }

    private int indexBook(Book book) {
        for (int i = 0; i < BOOKSHELF_SIZE; i++) {
            if (books[i] == null) break;
            if (book.equals(books[i])) return i;
        }
        throw new RuntimeException("Ошибка: в шкафу такой книги \"" + book.getTitle() + "\" нет!");
    }

    private void refreshInfo() {
        length = 0;
        for (Book book : books) {
            if (book == null) return;
            if (book.getInfo() > length) length = book.getInfo();
        }
    }
}
