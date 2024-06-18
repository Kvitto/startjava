package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class GuessNumber {
    private static final int ROUNDS_AMOUNT = 3;
    private final Player[] players;

    public GuessNumber(String... names) {
        int length = names.length;
        players = new Player[length];
        for (int i = 0; i < length; i++) {
            players[i] = new Player(names[i]);
        }
    }

    public void play(Scanner scanner) {
        shufflePlayers();
        System.out.println("\nИгра началась!");
        for (int i = 1; i <= ROUNDS_AMOUNT; i++) {
            System.out.printf("%nРаунд %d!%nУ каждого игрока по %d попыток.%n%n", i, Player.ATTEMPT_MAX);
            playRound(scanner);
            printRoundResult();
            reset();
        }
        printResult();
        resetResult();
    }

    private void playRound(Scanner scanner) {
        int secretNumber = (int) (Math.random() * Player.NUMBER_TO + Player.NUMBER_FROM);
        for (int i = 0; i < players.length; ) {
            if (!hasAttempts(players[i])) break;
            System.out.printf("Игрок %s введите число от %d до %d: ",
                    players[i].getName(), Player.NUMBER_FROM, Player.NUMBER_TO);
            inputPlayerNumber(players[i], scanner);
            if (hasGuessed(secretNumber, players[i])) break;
            if (++i == players.length) i = 0;
        }
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
        if (player.getAttempt() == ROUNDS_AMOUNT) {
            System.out.printf("У %s закончились попытки!%n", player.getName());
            return false;
        }
        return true;
    }

    private void inputPlayerNumber(Player player, Scanner scanner) {
        try {
            int inputNum = scanner.nextInt();
            checkDouble(inputNum);
            player.setNumbers(inputNum);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.print("\nПопробуйте еще раз: ");
            inputPlayerNumber(player, scanner);
        }
    }

    private void checkDouble(int inputNum) {
        for (Player player : players) {
            for (int num : player.getNumbers()) {
                if (num == inputNum) throw new RuntimeException("Число " + num + " уже вводилось.");
            }
        }
    }

    private boolean hasGuessed(int secretNumber, Player player) {
        int playerNumber = player.getNumbers()[player.getNumbers().length - 1];
        if (secretNumber == playerNumber) {
            System.out.printf("%s угадал число %d с %d-й попытки!%n", player.getName(), secretNumber,
                    player.getNumbers().length);
            player.setGoal(player.getGoal() + 1);
            return true;
        }
        System.out.printf("Число %d %s того, что загадал компьютер%n%n",
                playerNumber, secretNumber > playerNumber ? "меньше" : "больше");
        return false;
    }

    private void printRoundResult() {
        StringBuilder str = new StringBuilder();
        for (Player player : players) {
            for (int number : player.getNumbers()) {
                str.append(number).append(" ");
            }
            System.out.printf("%s : %s%n", player.getName(), str.toString().trim());
            str.setLength(0);
        }
    }

    private void printResult() {
        System.out.print("\nПо результатам " + ROUNDS_AMOUNT + " раундов: ");
        Arrays.sort(players, Comparator.comparing(Player::getGoal));
        Player player = players[players.length - 1];
        if (player.getGoal() == 0) {
            System.out.println("Общий проигрыш!");
        } else if (player.getGoal() == players[players.length - 2].getGoal()) {
            System.out.println("Ничья!");
        } else {
            System.out.printf("Победил %s!!!%n", player.getName());
        }
    }

    private void reset() {
        for (Player player : players) {
            player.clear();
        }
    }

    private void resetResult() {
        for (Player player : players) {
            player.setGoal(0);
        }
    }
}