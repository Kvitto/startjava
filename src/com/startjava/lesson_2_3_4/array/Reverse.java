package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Reverse {
    public static void main(String[] args) {
        reverseArray(new int[]{});
        int[] sequence = null;
        reverseArray(sequence);
        reverseArray(new int[]{6, 8, 9, 1});
        reverseArray(new int[]{13, 8, 5, 3, 2, 1, 1});
    }

    public static void reverseArray(int[] wholeNumbers) {
        if (wholeNumbers == null) {
            System.out.println("\nМассив не определен.");
            return;
        }
        int len = wholeNumbers.length;
        System.out.printf("%n %14s %s %n", "До реверса:", Arrays.toString(wholeNumbers));
        for (int i = 0; i < len ; i++) {
            len--;
            int swap = wholeNumbers[i];
            wholeNumbers[i] = wholeNumbers[len];
            wholeNumbers[len] = swap;
        }
        System.out.printf("%14s  %-21s %n", "После реверса:", Arrays.toString(wholeNumbers));
    }
}
