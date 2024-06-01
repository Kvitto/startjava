package com.startjava.lesson_2_3_4.array;

public class OverMidElement {
    public static void main(String[] args) {
        remove(15);
        remove(15);
        remove(15);
    }

    public static void remove(int sequenceSize) {
        double[] randSequence = generateRandSequence(sequenceSize);
        System.out.println("\nИсходный массив:");
        printArray(randSequence);
        removeElements(randSequence);
        System.out.printf("\nЗначение средней ячейки = %.3f%n", randSequence[randSequence.length / 2]);
    }

    private static void removeElements(double[] randSequence) {
        int clearedCell = 0;
        for (int i = 0; i < randSequence.length; i++) {
            if (randSequence[i] > randSequence[randSequence.length / 2]) {
                randSequence[i] = 0;
                clearedCell++;
            }
        }
        System.out.println("\nИзмененный массив:");
        printArray(randSequence);
        System.out.println("\nКоличество измененных ячеек: " + clearedCell);
    }

    private static double[] generateRandSequence(int len) {
        double[] sequence = new double[len];
        for (int i = 0; i < len; i++) {
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
