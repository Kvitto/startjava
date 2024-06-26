package com.startjava.graduation.bookshelf;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookshelfTest {
    private static final String MENU = """
            
            ========== МЕНЮ ==========
            1. Найти книгу
            2. Добавить книгу
            3. Удалить книгу
            4. Очистить шкаф
            5. Завершить
            ==========================
            Введите номер из списка:\s""";
    private static final String YES = "yes";
    private static final String NO = "no";
    private static Bookshelf bookshelf;
    private static boolean shouldContinue = true;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        bookshelf = new Bookshelf();
        do {
            showBookshelf();
            System.out.print(MENU);
            try {
                chooseAction(console);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("\nДля продолжения работы нажмите клавишу <Enter>");
            console.nextLine();
        } while (shouldContinue);
        console.close();
    }

    private static void showBookshelf() {
        if (bookshelf.getBookAmount() > 0) {
            System.out.printf("В шкафу книг - %d, свободно полок - %d%n%n",
                    bookshelf.getBookAmount(), bookshelf.availableShelves());
            showBooks();
            return;
        }
        System.out.println("\nШкаф пуст. Вы можете добавить в него первую книгу");
    }

    private static void showBooks() {
        for (Book book : bookshelf.getBooks()) {
            System.out.println("|" + book + " ".repeat(bookshelf.getLength() - book.getInfoLength()) + "|");
            System.out.println("|" + "-".repeat(bookshelf.getLength()) + "|");
        }
    }

    private static void chooseAction(Scanner console) {
        int chose = inputAction(console);
        console.nextLine();
        switch (chose) {
            case 1 -> findBook(console);
            case 2 -> addBook(console);
            case 3 -> deleteBook(console);
            case 4 -> clearBookshelf(console);
            case 5 -> shouldContinue = false;
            default -> {
                System.out.print("Ошибка: введите номер из списка: ");
                chooseAction(console);
            }
        }
    }

    private static int inputAction(Scanner console) {
        try {
            return console.nextInt();
        } catch (InputMismatchException e) {
            System.out.print("Ошибка: некорректное значение! Попробуйте еще раз: ");
            console.nextLine();
            return inputAction(console);
        }
    }

    private static void findBook(Scanner console) {
        System.out.println("\nПоиск...");
        String title = inputText(console, "название книги");
        Book book = bookshelf.find(title);
        if (book == null) {
            System.out.println("\nКнига не найдена!");
            return;
        }
        System.out.println(book);
    }

    private static void addBook(Scanner console) {
        System.out.println("\nНовая кника...");
        String title = inputText(console, "название книги");
        String author = inputText(console, "автор книги");
        int published = inputNumber(console, "год издания");
        if (bookshelf.add(new Book(author, title, published))) {
            System.out.println("книга \"" + title + "\" добавлена!");
            return;
        }
        System.out.println("\nВ шкафу нет места!");
    }

    private static void deleteBook(Scanner console) {
        System.out.println("\nУдаление...");
        String title = inputText(console, "название книги");
        if (bookshelf.delete(title)) {
            System.out.println("Книга \"" + title + "\" удалена!");
            return;
        }
        System.out.println("\nКнига не найдена!");
    }

    private static void clearBookshelf(Scanner console) {
        System.out.println("Очистить шкаф от книг [yes / no]: ");
        if (confirmClear(console)) {
            bookshelf.clear();
            System.out.println("Шкаф очищен!");
            return;
        }
        System.out.println("Очистка отменена!");
    }

    private static boolean confirmClear(Scanner console) {
        String option = console.nextLine().toLowerCase();
        if (!YES.equals(option) && !NO.equals(option)) {
            System.out.print("Введите корректный ответ [yes / no]: ");
            return confirmClear(console);
        }
        return YES.equals(option);
    }

    private static String inputText(Scanner console, String title) {
        System.out.print("Введите " + title + ": ");
        String text = console.nextLine();
        if (!text.isBlank()) return text;
        System.out.println("Ошибка: " + title + " не может быть пустым!");
        return inputText(console, title);
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
}
