package com.startjava.graduation.bookshelf;

import java.util.Arrays;

public class Bookshelf {
    public static final int BOOKSHELF_SIZE = 10;
    private int bookQty;
    private final Book[] books = new Book[BOOKSHELF_SIZE];

    public Book[] getBooks() {
        return books;
    }

    // выводить количество всех книг (перед выводом шкафа)
    public int getBookQty() {
        return bookQty;
    }

    //сохранить книгу
    public void addBook(Book book) {
        books[bookQty++] = book;
    }

    //удалять по названию

    //искать по названию

    //выводить количество свободных полок (перед выводом шкафа)
    public int freeShelfQty() {
        return BOOKSHELF_SIZE - bookQty;
    }

    //выводить все книги (только для визуализации шкафа)


    //очищать шкаф от книг
    public void clearBookshelf() {
        Arrays.fill(books, 0, bookQty, null);
        bookQty = 0;
    }
}
