package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumber {
    private final Player[] players;

    public GuessNumber(String... names) {
        players = new Player[names.length];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(names[i]);
        }
    }

    public void reset() {
        for (Player player : players) player.resetNumbers();
    }

    public void play() {
        int secretNum = (int) (Math.random() * 100 + 1);
        var scanner = new Scanner(System.in);
        Player currentPlayer = players[0];
        int playerNum = 0;
        int startPlayer = (int) (Math.random() * players.length);
        for (int i = startPlayer; i < players.length; ) {
            currentPlayer = players[i];
            if (!hasAttempts(currentPlayer)) return;
            System.out.printf("Игрок %s введите число от 1 до 100: ", currentPlayer.getName());
            playerNum = scanner.nextInt();
            currentPlayer.setNumbers(playerNum);
            if (secretNum < playerNum) {
                System.out.printf("Число %d больше того, что загадал компьютер%n%n", playerNum);
            } else if (secretNum > playerNum) {
                System.out.printf("Число %d меньше того, что загадал компьютер%n%n", playerNum);
            }
            if (secretNum == playerNum) break;
            if (++i == players.length) i = 0;
        }
        System.out.printf("%s угадал число %d с %d-й попытки!%n", currentPlayer.getName(), playerNum,
                currentPlayer.getNumbers().length);
        printResult();
    }

    private boolean hasAttempts(Player player) {
        if (player.getAttempts() == 0) {
            System.out.printf("У %s закончились попытки!%n", player.getName());
            printResult();
            return false;
        }
        return true;
    }

    private void printResult() {
        for (Player player : players) System.out.printf("%s : %s%n", player.getName(),
                player.printNumbers());
    }
}