package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    private static final int PLAYERS_AMOUNT = 3;
    private static final String YES = "yes";
    private static final String NO = "no";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GuessNumber game = init(scanner);
        do {
            game.play(scanner);
            scanner.nextLine();
            System.out.print("\nХотите повторить? [yes / no]: ");
        } while (shouldContinue(scanner));
        scanner.close();
    }

    private static GuessNumber init(Scanner scanner) {
        String[] playerNames = new String[PLAYERS_AMOUNT];
        for (int i = 0; i < PLAYERS_AMOUNT; i++) {
            playerNames[i] = inputName(scanner, i + 1);
        }
        return new GuessNumber(playerNames);
    }

    private static String inputName(Scanner scanner, int playerIndex) {
        System.out.printf("Введите имя " + (playerIndex) + "-го игрока: ");
        String name = scanner.nextLine();
        if (name.isBlank()) {
            System.out.println("У " + (playerIndex) + "-го игрока должно быть имя!");
            return inputName(scanner, playerIndex);
        }
        return name;
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
