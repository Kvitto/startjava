package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    private static final String YES = "yes";
    private static final String NO = "no";

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Введите имя первого игрока: ");
        var namePlayer1 = scanner.nextLine();
        System.out.print("Введите имя второго игрока: ");
        var namePlayer2 = scanner.nextLine();
        var game = new GuessNumber(namePlayer1, namePlayer2);
        do {
            game.reset();
            System.out.println("\nИгра началась! У каждого игрока по 10 попыток.\n");
            game.play();
            System.out.print("\nХотите повторить? [yes / no]: ");
        } while (shouldContinue(scanner));
        scanner.close();
    }

    private static boolean shouldContinue(Scanner console) {
        String option = console.nextLine().toLowerCase();
        if (!YES.equals(option) && !NO.equals(option)) {
            System.out.print("Введите корректный ответ [yes / no]: ");
            return shouldContinue(console);
        }
        return YES.equals(option);
    }
}
