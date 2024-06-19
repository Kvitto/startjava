package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private static final int ATTEMPTS_LIMIT = 10;
    private static final int ROUNDS_AMOUNT = 3;
    private final Player[] players;

    public GuessNumber(String... names) {
        players = new Player[names.length];
        for (int i = 0; i < names.length; i++) {
            players[i] = new Player(names[i], ATTEMPTS_LIMIT);
        }
    }

    public void play(Scanner scanner) {
        shufflePlayers();
        System.out.println("\nИгра началась!");
        for (int i = 1; i <= ROUNDS_AMOUNT; i++) {
            System.out.printf("%nРаунд %d!%nУ каждого игрока по %d попыток.%n%n", i, ATTEMPTS_LIMIT);
            playRound(scanner);
            reset();
        }
        defineWinner();
        resetWins();
    }

    private void shufflePlayers() {
        for (int i = 1; i < players.length; i++) {
            int swapTo = players.length - i;
            int swapFrom = new Random().nextInt(swapTo + 1);
            if (swapFrom == swapTo) continue;
            Player swap = players[swapFrom];
            players[swapFrom] = players[swapTo];
            players[swapTo] = swap;
        }
    }

    private void playRound(Scanner scanner) {
        int secretNumber = new Random().nextInt(Player.END_RANGE) + Player.START_RANGE;
        int attempts = players.length;
        while (attempts > 0) {
            for (Player player : players) {
                if (!hasAttempts(player)) {
                    attempts--;
                    continue;
                }
                if (hasGuessed(scanner, player, secretNumber)) {
                    printRoundResult();
                    return;
                }
            }
        }
    }

    private boolean hasAttempts(Player player) {
        if (player.getAttempt() == ATTEMPTS_LIMIT) {
            System.out.printf("У %s закончились попытки!%n", player.getName());
            return false;
        }
        return true;
    }

    private boolean hasGuessed(Scanner scanner, Player player, int secretNumber) {
        tryGuess(scanner, player);
        int playerNumber = player.getNumbers()[player.getNumbers().length - 1];
        if (secretNumber == playerNumber) {
            System.out.printf("%s угадал число %d с %d-й попытки!%n", player.getName(), secretNumber,
                    player.getNumbers().length);
            player.incWins();
            return true;
        }
        System.out.printf("Число %d %s того, что загадал компьютер%n%n",
                playerNumber, secretNumber > playerNumber ? "меньше" : "больше");
        return false;
    }

    private void tryGuess(Scanner scanner, Player player) {
        System.out.printf("Игрок %s введите число от %d до %d: ",
                player.getName(), Player.START_RANGE, Player.END_RANGE);
        try {
            int inputNumber = scanner.nextInt();
            checkDouble(inputNumber);
            player.setNumber(inputNumber);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("\nПопробуйте еще раз.");
            tryGuess(scanner, player);
        }
    }

    private void checkDouble(int inputNumber) {
        for (Player player : players) {
            for (int number : player.getNumbers()) {
                if (number == inputNumber) throw new RuntimeException("Число " + number + " уже вводилось.");
            }
        }
    }

    private void printRoundResult() {
        StringBuilder lineNumbers = new StringBuilder();
        for (Player player : players) {
            for (int number : player.getNumbers()) {
                lineNumbers.append(number).append(" ");
            }
            System.out.printf("%s : %s%n", player.getName(), lineNumbers);
            lineNumbers.setLength(0);
        }
    }

    private void reset() {
        for (Player player : players) {
            player.clear();
        }
    }

    private void defineWinner() {
        System.out.print("\nПо результатам " + ROUNDS_AMOUNT + " раундов: ");
        Arrays.sort(players, Comparator.comparing(Player::getWins));
        int length = players.length;
        Player player = players[length - 1];
        if (player.getWins() == 0) {
            System.out.println("Все проиграли!");
        } else if (length > 1 && player.getWins() == players[length - 2].getWins()) {
            System.out.println("Ничья!");
        } else {
            System.out.printf("Победил %s!!!%n", player.getName());
        }
    }

    private void resetWins() {
        for (Player player : players) {
            player.setWins(0);
        }
    }
}