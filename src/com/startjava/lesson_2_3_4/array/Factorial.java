package com.startjava.lesson_2_3_4.array;

public class Factorial {
    public static void main(String[] args) {
        calcFactorialArray(new int[]{});
        calcFactorialArray(null);
        calcFactorialArray(new int[]{8, 0, 9});
        calcFactorialArray(new int[]{-3, 1, 7, 13});
        calcFactorialArray(new int[]{-22, -0});
    }

    public static void calcFactorialArray(int[] args) {
        if (args == null || args.length == 0) {
            System.out.println("Массив не определен.");
            return;
        }
        int len = args.length;
        long[] readyFactorials = new long[len];
        for (int i = 0; i < len; i++) {
            if (args[i] <= 0) {
                readyFactorials[i] = 0;
            } else {
                readyFactorials[i] = factorial(args[i]);
            }
        }
        printFactorial(args, readyFactorials);
    }

    private static long factorial(int fact) {
        long result = 1;
        for (int i = 1; i <= fact; i++) result *= i;
        return result;
    }

    private static void printFactorial(int[] sequence, long[] factorial) {
        int len = sequence.length;
        for (int i = 0; i < len; i++) {
            if (sequence[i] > 0) {
                System.out.print("\n" + sequence[i] + "! = ");
                for (int j = 1; j <= sequence[i]; j++) {

                    System.out.print(j < sequence[i] ? j + " * " : sequence[i] + " = " + factorial[i] + "\n");
                }
            } else {
                System.out.println("\nОшибка: факториал " + sequence[i] + "! не определен");
            }
        }
    }
}
