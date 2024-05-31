package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Reverse {
    public static void main(String[] args) {
        reverseInts();
        reverseInts(null);
        reverseInts(6, 8, 9, 1);
        reverseInts(13, 8, 5, 3, 2, 1, 1);
    }

    public static void reverseInts(int... ints) {
        if (ints == null) {
            System.out.println("\nМассив не определен.");
            return;
        }
        int len = ints.length;
        System.out.printf("%n%14s %s%n", "До реверса:", Arrays.toString(ints));
        for (int i = 0; i < len; i++) {
            int swap = ints[i];
            ints[i] = ints[--len];
            ints[len] = swap;
        }
        System.out.printf("%14s %-21s%n", "После реверса:", Arrays.toString(ints));
    }
}
