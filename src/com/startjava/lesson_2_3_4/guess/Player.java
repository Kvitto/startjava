package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private final String name;
    private int attempts;
    private final int[] numbers;

    public Player(String name) {
        this.name = name;
        numbers = new int[10];
        attempts = numbers.length;
    }

    public String getName() {
        return name;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, numbers.length - attempts);
    }

    public void setNumbers(int number) {
        numbers[numbers.length - attempts] = number;
        attempts--;
    }

    public void resetPlayer() {
        Arrays.fill(numbers, 0, getNumbers().length, 0);
        attempts = numbers.length;
    }

    public int getAttempts() {
        return attempts;
    }
}
