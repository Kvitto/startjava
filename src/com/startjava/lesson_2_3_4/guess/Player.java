package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private final String name;
    private int attempts;
    private final int[] numbers;

    public Player(String name, int roundsAmount) {
        this.name = name;
        numbers = new int[roundsAmount];
        attempts = 0;
    }

    public String getName() {
        return name;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, attempts);
    }

    public void setNumbers(int number) {
        if (number < 1 || number > 100) throw new RuntimeException();
        numbers[attempts] = number;
        attempts++;
    }

    public void resetPlayer() {
        Arrays.fill(numbers, 0, getNumbers().length, 0);
        attempts = 0;
    }

    public int getAttempts() {
        return numbers.length - attempts;
    }
}
