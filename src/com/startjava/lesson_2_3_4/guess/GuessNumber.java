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

    public void play(Scanner scanner) {
        int secretNum = (int) (Math.random() * 100 + 1);
        int startPlayer = (int) (Math.random() * players.length);
        for (int i = startPlayer; i < players.length; ) {
            if (!hasAttempts(players[i])) break;
            System.out.printf("Игрок %s введите число от 1 до 100: ", players[i].getName());
            players[i].setNumbers(scanner.nextInt());
            if (hasGuessed(secretNum, players[i])) break;
            if (++i == players.length) i = 0;
        }
        printResult();
        reset();
    }

    private boolean hasAttempts(Player player) {
        if (player.getAttempts() == 0) {
            System.out.printf("У %s закончились попытки!%n", player.getName());
            return false;
        }
        return true;
    }

    private boolean hasGuessed(int secretNum, Player player) {
        int playerNum = player.getNumbers()[player.getNumbers().length - 1];
        if (secretNum == playerNum) {
            System.out.printf("%s угадал число %d с %d-й попытки!%n", player.getName(), secretNum,
                    player.getNumbers().length);
            return true;
        }
        System.out.printf("Число %d %s того, что загадал компьютер%n%n",
                playerNum, secretNum > playerNum ? "меньше" : "больше");
        return false;
    }

    private void printResult() {
        StringBuilder str = new StringBuilder();
        for (Player player : players) {
            for (int number : player.getNumbers()) {
                str.append(number).append(" ");
            }
            System.out.printf("%s : %s%n", player.getName(), str.toString().trim());
            str.setLength(0);
        }
    }

    private void reset() {
        for (Player player : players) {
            player.resetPlayer();
        }
    }
}