package com.startjava.lesson_2_3_4.array;

public class CharsToPyramid {
    public static void main(String[] args) {
        charsToPyramid('0', '9', true);
        charsToPyramid('/', '!', false);
        charsToPyramid('A', 'J', false);
    }

    public static void charsToPyramid(char from, char to, boolean direction) {
        printPyramid(init(from, to, direction));
    }

    private static int[] init(int from, int to, boolean direction) {
        if (from > to) {
            int swap = from;
            from = to;
            to = swap;
        }
        int height = to - from + 1;
        int[] charsIndexSequence = new int[height];
        if (direction) {
            for (int i = 0; i < height; i++) {
                charsIndexSequence[i] = from + i;
            }
        } else {
            for (int i = 0; i < height; i++) {
                charsIndexSequence[i] = to - i;
            }
        }
        return charsIndexSequence;
    }

    private static void printPyramid(int[] sequence) {
        System.out.println();
        var line = new StringBuilder();
        for (int i = 0; i < sequence.length; i++) {
            line.delete(0, line.length());
            line.append(" ".repeat(Math.max(0, sequence.length - i - 1)));
            line.append(String.valueOf((char) sequence[i]).repeat(Math.max(0, i * 2 + 1)));
            System.out.println(line);
        }
    }
}