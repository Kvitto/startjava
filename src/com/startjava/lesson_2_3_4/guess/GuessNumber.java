package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumber {
    private final Player[] players;

    public GuessNumber(int roundsAmount, String... names) {
        players = new Player[names.length];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(names[i], roundsAmount);
        }
    }

    public void play(Scanner scanner) {
        int secretNum = (int) (Math.random() * 100 + 1);
        shufflePlayers();
        for (int i = 0; i < players.length; ) {
            if (!hasAttempts(players[i])) break;
            System.out.printf("Игрок %s введите число от 1 до 100: ", players[i].getName());
            inputPlayerNum(players[i], scanner);
            if (hasGuessed(secretNum, players[i])) break;
            if (++i == players.length) i = 0;
        }
        printResult();
        reset();
    }

    private void shufflePlayers() {
        for (int i = 1; i < players.length; i++) {
            int swapTo = players.length - i;
            int swapFrom = (int) (Math.random() * (swapTo + 1));
            if (swapFrom == swapTo) continue;
            Player swap = players[swapFrom];
            players[swapFrom] = players[swapTo];
            players[swapTo] = swap;
        }
    }

    private boolean hasAttempts(Player player) {
        if (player.getAttempts() == 0) {
            System.out.printf("У %s закончились попытки!%n", player.getName());
            System.out.println("Ничья!");
            return false;
        }
        return true;
    }

    private void inputPlayerNum(Player player, Scanner scanner) {
        try {
            int inputNum = scanner.nextInt();
            checkDouble(inputNum);
            player.setNumbers(inputNum);
        } catch (RuntimeException e) {
            System.out.print("Число должно входить в интервал [1, 100]\nПопробуйте еще раз: ");
            inputPlayerNum(player, scanner);
        }
    }

    private void checkDouble(int inputNum) {
        for (Player player : players) {
            for (int num : player.getNumbers()) {
                if (num == inputNum) throw new RuntimeException();
            }
        }
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