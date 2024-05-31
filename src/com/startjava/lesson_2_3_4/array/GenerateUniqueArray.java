package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class GenerateUniqueArray {
    public static void main(String[] args) {
        printByTen(generate(-10, 20));
        printByTen(generate(60, 100));
        printByTen(generate(34, -34));
        printByTen(generate(0, 0));
    }
    /*
     * Для последовальностей меньше 3 элементов невозможно сгенерировать уникальный массив если
     * она пересикае 0.
     * При инициализации, массив заполняется нулями по умолчанию, и при генерации случайного числа
     * равного 0, оно не проходит проверку на уникальность, т.к. в массиве уже есть ячейки с 0.
     * Для этого в строке 24 производится декремент кол-ва циклов заполнения массива,
     * чтобы оставить 0 в крайней ячейке.
     * Граммотного решения чтобы заносить в массив 0 не нашел. Решение задачи у меня получилось кривое.
     */

    public static int[] generate(int from, int to) {
        int[] minMax = {from, to};
        Arrays.sort(minMax);
        int len = (int) Math.round((minMax[1] - minMax[0] + 1) * 0.75);
        int[] sequence = new int[len];
        if (len < 3 && minMax[0] <= 0 && minMax[1] >= 0) len--;
        for (int i = 0; i < len; i++) {
            int rndNumb;
            do {
                rndNumb = (int) Math.round(minMax[0] + Math.random() * (minMax[1] - minMax[0]));
            } while (!isUnique(sequence, rndNumb));
            sequence[i] = rndNumb;
        }
        return sequence;
    }

    public static void printByTen(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            System.out.println("\nМассив не определен");
        } else {
            Arrays.sort(sequence);
            for (int i = 0; i < sequence.length; i++) {
                if (i % 10 == 0) System.out.println();
                System.out.printf("%3d ", sequence[i]);
            }
            System.out.println();
        }
    }

    public static boolean isUnique(int[] arr, int toCheckValue) {
        for (int element : arr) {
            if (element == toCheckValue) {
                return false;
            }
        }
        return true;
    }
}
