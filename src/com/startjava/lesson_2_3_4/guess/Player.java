package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    public static final int NUMBER_FROM = 1;
    public static final int NUMBER_TO = 100;
    private final String name;
    private final int[] numbers;
    private int attempt;
    private int goal;

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

    public void setNumbers(int number) {
        if (number < NUMBER_FROM || number > NUMBER_TO) throw new RuntimeException("Число должно входить " +
                "в интервал [" + NUMBER_FROM + ", " + NUMBER_TO + "]");
        numbers[attempt++] = number;
    }

    public void clear() {
        Arrays.fill(numbers, 0, attempt, 0);
        attempt = 0;
    }

    public int getAttempt() {
        return attempt;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }
}
