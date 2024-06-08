package com.startjava.lesson_2_3_4.array;

public class FactorialCalculator {
    public static void main(String[] args) {
        calculate();
        calculate(null);
        calculate(8, 0, 9);
        calculate(-3, 1, 7, 13);
        calculate(-22, -0);
    }

    public static void calculate(int... sequence) {
        if (sequence == null || sequence.length == 0) {
            System.out.println("\nМассив не определен.");
            return;
        }
        long[] factorialResults = new long[sequence.length];
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] >= 0) {
                factorialResults[i] = factorial(sequence[i]);
                printFactorial(sequence[i], factorialResults[i]);
                continue;
            }
            System.out.println("\nОшибка: факториал " + sequence[i] + "! не определен");
        }
    }

    private static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) result *= i;
        return result;
    }

    private static void printFactorial(int n, long factorial) {
        if (n > 1) {
            System.out.print("\n" + n + "! = ");
            for (int i = 1; i <= n; i++) {
                System.out.print(i < n ? i + " * " : n + " = " + factorial + "\n");
            }
            return;
        }
        System.out.println("\n" + n + "! = 1");
    }
}
