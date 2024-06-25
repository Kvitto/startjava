package com.startjava.graduation.bookshelf;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookshelfTest {
    public static final String MENU = """
            
            ========== МЕНЮ ==========
            1. Найти книгу
            2. Добавить книгу
            3. Удалить книгу
            4. Очистить шкаф
            5. Завершить
            ==========================
            Введите номер из списка:\s""";
    private static Bookshelf bookshelf;
    private static boolean shouldContinue = true;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        bookshelf = new Bookshelf();
        do {
            shelfView();
            menu(console);
            System.out.println("\nДля продолжения работы нажмите клавишу <Enter>");
            console.nextLine();
        } while (shouldContinue);
        console.close();
    }

    // - вывод шкафа
    private static void shelfView() {
        if (bookshelf.getBookQty() == 0) {
            System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу");
            return;
        }
        System.out.printf("В шкафу книг - %d, свободно полок - %d%n%n",
                bookshelf.getBookQty(), bookshelf.freeShelfQty());
        for (Book book : bookshelf.getBooks()) {
            if (book == null) break;
            System.out.println(book.toString());
        }
    }

    private static void menu(Scanner console) {
        System.out.print(MENU);
        while (true) {
            try {
                chooseAction(console);
                break;
            } catch (RuntimeException e) {
                System.out.print(e.getMessage());
            }
        }
    }

    private static void chooseAction(Scanner console) {
        int choise;
        try {
            choise = console.nextInt();
        } catch (InputMismatchException e) {
            choise = 0;
        }
        console.nextLine();
        switch (choise) {
            case 1 -> {
                return;
            }
            case 2 -> addBook(console);
            case 3 -> deleteBook();
            case 4 -> bookshelf.clearBookshelf();
            case 5 -> shouldContinue = false;
            default -> throw new RuntimeException("Ошибка: Введите номер из списка: ");
        }
    }

    private static void deleteBook() {
        System.out.println("bookDelete");
    }

    private static void addBook(Scanner console) {
        System.out.println("\nНовая кника...");
        String title = inputText(console, "Название книги");
        String author = inputText(console, "Автор книги");
        int published = inputNumber(console, "Год издания");
        bookshelf.addBook(new Book(author, title, published));
        System.out.println("книга добавлена!");
    }

    private static String inputText(Scanner console, String title) {
        System.out.print("Введите " + title + ": ");
        String text = console.nextLine();
        if (text.isBlank()) {
            System.out.println("Ошибка: " + title + " не может быть пустым!");
            return inputText(console, title);
        }
        return text;
    }

    private static int inputNumber(Scanner console, String title) {
        System.out.print("Введите " + title + ": ");
        try {
            int number = console.nextInt();
            console.nextLine();
            return number;
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: " + title + " - неверное значение!");
            console.nextLine();
            return inputNumber(console, title);
        }
    }
    /*

    - меню
        - искать книгу
        - добавить книгу
        - удалить книгу
        - очистить шкаф
    - выполнить выбраный пункт меню
    - вывести сообщение "Для продолжения работы нажмите клавишу <Enter>"
     */
}
