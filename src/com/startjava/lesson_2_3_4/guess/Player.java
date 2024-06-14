package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private final String name;
    private final int[] numbers;

    public Player(String name) {
        this.name = name;
        numbers = new int[10];
    }

    public String getName() {
        return name;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, getFreeIndex());
    }

    public void setNumbers(int number) {
        numbers[getFreeIndex()] = number;
    }

    public void resetNumbers() {
        Arrays.fill(numbers, 0);
    }

    public String printNumbers() {
        StringBuilder str = new StringBuilder();
        for (int number : getNumbers()) {
            str.append(number).append(" ");
        }
        return str.toString().trim();
    }

    public int getAttempts() {
        return numbers.length - getFreeIndex();
    }

    private int getFreeIndex() {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0) continue;
            return i;
        }
        return numbers.length;
    }
}
