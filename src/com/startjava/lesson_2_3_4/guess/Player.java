package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    public static final int START_RANGE = 1;
    public static final int END_RANGE = 100;
    private final String name;
    private final int[] numbers;
    private int attempt;
    private int wins;

    public Player(String name, int maxAttempt) {
        this.name = name;
        numbers = new int[maxAttempt];
    }

    public String getName() {
        return name;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, attempt);
    }

    public void addNumber(int number) {
        if (number < START_RANGE || number > END_RANGE) {
            throw new RuntimeException("Число должно входить " +
                    "в интервал [" + START_RANGE + ", " + END_RANGE + "]");
        }
        numbers[attempt++] = number;
    }

    public int getLastNumber() {
        return numbers[attempt - 1];
    }

    public int getAttempt() {
        return attempt;
    }

    public int getWins() {
        return wins;
    }

    public void clearWins() {
        wins = 0;
    }

    public void incWin() {
        wins++;
    }

    public void clear() {
        Arrays.fill(numbers, 0, attempt, 0);
        attempt = 0;
    }
}
