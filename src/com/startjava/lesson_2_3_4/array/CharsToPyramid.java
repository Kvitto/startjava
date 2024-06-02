package com.startjava.lesson_2_3_4.array;

public class CharsToPyramid {
    public static void main(String[] args) {
        printPyramid('0', '9', true);
        printPyramid('/', '!', false);
        printPyramid('A', 'J', false);
    }

    public static void printPyramid(char from, char to, boolean isAscending) {
        print(init(from, to, isAscending));
    }

    private static int[] init(int from, int to, boolean isAscending) {
        if (from > to) {
            int swap = from;
            from = to;
            to = swap;
        }
        int height = to - from + 1;
        int[] sequence = new int[height];
        for (int i = 0; i < height; i++) {
            sequence[i] = isAscending ? from + i : to - i;
        }
        return sequence;
    }

    private static void print(int[] sequence) {
        System.out.println();
        StringBuilder line;
        for (int i = 0; i < sequence.length; i++) {
            line = new StringBuilder();
            line.append(" ".repeat(sequence.length - i - 1));
            line.append(String.valueOf((char) sequence[i]).repeat(i * 2 + 1));
            System.out.println(line);
        }
    }
}