package com.startjava.lesson_2_3_4.array;

public class FactorialCalculator {
    public static void main(String[] args) {
        factorial();
        factorial(null);
        factorial(8, 0, 9);
        factorial(-3, 1, 7, 13);
        factorial(-22, -0);
    }

    public static void factorial(int... numbers) {
        if (numbers == null || numbers.length == 0) {
            System.out.println("\nМассив не определен.");
            return;
        }
        int len = numbers.length;
        long[] factorialResults = new long[len];
        for (int i = 0; i < len; i++) {
            if (numbers[i] >= 0) {
                factorialResults[i] = calculate(numbers[i]);
            }
        }
        printFactorial(numbers, factorialResults);
    }

    private static long calculate(int fact) {
        long result = 1;
        for (int i = 1; i <= fact; i++) result *= i;
        return result;
    }

    private static void printFactorial(int[] sequence, long[] factorial) {
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] > 1) {
                System.out.print("\n" + sequence[i] + "! = ");
                for (int j = 1; j <= sequence[i]; j++) {
                    System.out.print(j < sequence[i] ? j + " * " : sequence[i] + " = " + factorial[i] + "\n");
                }
            } else if (sequence[i] == 0 || sequence[i] == 1) {
                System.out.println("\n" + sequence[i] + "! = 1");
            } else {
                System.out.println("\nОшибка: факториал " + sequence[i] + "! не определен");
            }
        }
    }
}
