package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class CharsToPyramid {
    private static int[] charsIndexSequence;
    private static int pyramidHeight;

    public static void main(String[] args) {
        charsToPyramid('0', '9', false);
        charsToPyramid('/', '!', true);
        charsToPyramid('A', 'J', false);
    }

    public static void charsToPyramid(char from, char to, boolean sort) {
        fillFields(from, to, sort);
        printPyramid();
    }

    private static void fillFields(int from, int to, boolean sort) {
        int[] minMax = {from, to};
        Arrays.sort(minMax);
        pyramidHeight = minMax[1] - minMax[0] + 1;
        charsIndexSequence = new int[pyramidHeight];
        if (sort) {
            for (int i = 0; i < pyramidHeight; i++) {
                charsIndexSequence[i] = minMax[0] + i;
            }
        } else {
            for (int i = 0; i < pyramidHeight; i++) {
                charsIndexSequence[i] = minMax[1] - i;
            }
        }
    }

    private static void printPyramid() {
        var line = new StringBuilder();
        System.out.println();
        for (int i = 0; i < pyramidHeight; i++) {
            line.delete(0, line.length());
            line.append(" ".repeat(Math.max(0, pyramidHeight - i - 1)));
            line.append(String.valueOf((char) charsIndexSequence[i]).repeat(Math.max(0, i * 2 + 1)));
            System.out.println(line);
        }
    }
}