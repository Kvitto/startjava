package com.startjava.lesson_2_3.guess;

import java.util.Scanner;

public class GuessNumber {
    private Player player1;
    private Player player2;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() {
        int secretNum = (int) (Math.random() * 100 + 1);
        var scanner = new Scanner(System.in);
        Player currentPlayer = null;
        int playerNum;
        do {
            currentPlayer = player1.equals(currentPlayer) ? player2 : player1;
            System.out.printf("Игрок %s введите число от 1 до 100: ", currentPlayer.getName());
            playerNum = scanner.nextInt();
            if (secretNum < playerNum) {
                System.out.printf("Число %d больше того, что загадал компьютер\n", playerNum);
            } else if (secretNum > playerNum) {
                System.out.printf("Число %d меньше того, что загадал компьютер\n", playerNum);
            }
        } while (secretNum != playerNum);
        System.out.printf("Игрок %s победил(а)!!!\n", currentPlayer.getName());
    }
}