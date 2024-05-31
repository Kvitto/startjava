package com.startjava.lesson_2_3_4.array;

public class OverMidElementsRemove {
    private static double[] randSequence;
    private static int len;
    private static int midIndex;
    private static int clearedCell;

    public static void main(String[] args) {
        OverMidElementsRemove.start();
        OverMidElementsRemove.start();
        OverMidElementsRemove.start();
    }

    public static void start() {
        fillFields();
        System.out.println("\nИсходный массив:");
        printArray();
        removeElements();
        System.out.println("\nИзмененный массив:");
        printArray();
        System.out.println("\nКоличество обнуленных ячеек = " + clearedCell);
        System.out.println("\nЗначение средней ячейки = " + randSequence[midIndex]);
    }

    private static void fillFields() {
        randSequence = new double[15];
        len = randSequence.length;
        for (int i = 0; i < len; i++) {
            randSequence[i] = Math.random();
        }
        midIndex = len / 2;
        clearedCell = 0;
    }

    private static void removeElements() {
        for (int i = 0; i < len; i++) {
            if (randSequence[i] > randSequence[midIndex]) {
                randSequence[i] = 0;
                clearedCell++;
            }
        }
    }

    private static void printArray() {
        for (int i = 0; i < len; i++) {
            System.out.printf("%.3f ", randSequence[i]);
            if (i == midIndex || i == len - 1) System.out.println();
        }
    }
}
