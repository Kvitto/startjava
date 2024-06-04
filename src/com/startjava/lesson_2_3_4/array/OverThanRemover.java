package com.startjava.lesson_2_3_4.array;

public class OverThanRemover {
    public static void main(String[] args) {
        remove(-1);
        remove(15);
        remove(0);
        remove(14);
    }

    public static void remove(int position) {
        double[] randSequence = generateRandSequence();
        if (position >= randSequence.length || position < 0) {
            System.out.println("\nЭлемент с индексом " + position + " отсутствует.");
            return;
        }
        System.out.println("\nИсходный массив:");
        printArray(randSequence);
        double positionValue = randSequence[position];
        int clearedCell = removeElements(randSequence, position);
        System.out.printf("\nЗначение ячейки %d = %.3f%n", position, positionValue);
        System.out.println("\nКоличество измененных ячеек: " + clearedCell);
    }

    private static int removeElements(double[] randSequence, int position) {
        int clearedCell = 0;
        for (int i = 0; i < randSequence.length; i++) {
            if (randSequence[i] > randSequence[position]) {
                randSequence[i] = 0;
                clearedCell++;
            }
        }
        System.out.println("\nИзмененный массив:");
        printArray(randSequence);
        return clearedCell;
    }

    private static double[] generateRandSequence() {
        double[] sequence = new double[15];
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = Math.random();
        }
        return sequence;
    }

    private static void printArray(double[] randSequence) {
        int len = randSequence.length;
        for (int i = 0; i < len; i++) {
            System.out.printf("%.3f ", randSequence[i]);
            if (i == len / 2 || i == len - 1) System.out.println();
        }
    }
}
