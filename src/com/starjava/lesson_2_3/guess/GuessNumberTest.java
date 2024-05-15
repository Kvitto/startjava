package com.starjava.lesson_2_3.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Введите имя первого игрока: ");
        var player1 = new Player(scanner.nextLine());
        System.out.print("Введите имя второго игрока: ");
        var player2 = new Player(scanner.nextLine());
        var game = new GuessNumber(player1, player2);
        String choice;
        do {
            game.play();
            do {
                System.out.print("Хотите продолжить игру? [yes/no]: ");
                choice = scanner.next().toLowerCase();
            } while (!"yes".equals(choice) && !"no".equals(choice));
        } while ("yes".equals(choice));
        scanner.close();
    }
}
