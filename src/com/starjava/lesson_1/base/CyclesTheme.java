package com.starjava.lesson_1.base;

public class CyclesTheme {
    public static void main(String[] args) {
        // 1. Подсчет суммы четных и нечетных чисел
        System.out.println("\n1. Подсчет суммы четных и нечетных чисел");

        int sumEven = 0;
        int sumOdd = 0;
        int from = 22;
        int to = 21;

        System.out.print("В отрезке [" + from + ", " + to + "]");
        if (from > to) {
            from += to;
            to = from - to;
            from -= to;
        }

        do {
            if (from % 2 == 0) {
                sumEven += from;
            } else {
                sumOdd += from;
            }
            from++;
        } while (from <= to);
        System.out.println(" сумма четных чисел = " + sumEven + ", а нечетных = " + sumOdd);

        // 2. Вывод чисел в порядке убывания
        System.out.println("\n2. Вывод чисел в порядке убывания");

        int a = -1;
        int b = 5;
        int c = 10;
        int max = b;
        int min = c;

        if (c >= b && b >= a) {
            max = c;
            min = a;
        } else if (a >= c && c >= b) {
            max = a;
            min = b;
        } 

        System.out.print("В интервале (" + min + "; " + max + ") находятся числа: ");
        for (int i = max - 1; i > min; i--) {
            System.out.print(i + " ");
        }

        // 3. Вывод реверсивного числа и суммы его цифр
        System.out.println("\n\n3. Вывод реверсивного числа и суммы его цифр");

        int srcNumber = 1234;
        int sumDigits = 0;

        System.out.print("Число в обратном порядке - ");
        while (srcNumber > 0) {
            int digit = srcNumber % 10;
            System.out.print(digit);
            sumDigits += digit;
            srcNumber /= 10;
        }

        System.out.println("\nСумма его цифр - " + sumDigits);

        // 4. Вывод чисел в несколько строк
        System.out.println("\n4. Вывод чисел в несколько строк");

        from = 1;
        to = 24;
        int cols = 5;

        for (int i = from; i < 30; ) {
            for (int j = 0; j < cols; j++) {
                if (i < to) {
                    System.out.printf("%3d", i);
                } else {
                    System.out.printf("%3d", 0);
                }
                i += 2;
            }
            System.out.println();
        }

        // 5. Проверка количества двоек числа на четность/нечетность
        System.out.println("\n5. Проверка количества двоек числа на четность/нечетность");

        int twosCount = 0;
        srcNumber = 3242592;

        System.out.print("В " + srcNumber);

        while (srcNumber > 0) {
            if (srcNumber % 10 == 2) twosCount++;
            srcNumber /= 10;
        }

        if (twosCount % 2 == 0) {
            System.out.println(" четное количество двоек — " + twosCount);
        } else {
            System.out.println(" нечетное количество двоек — " + twosCount);
        }

        // 6. Отображение геометрических фигур
        System.out.println("\n6. Отображение геометрических фигур");

        int lines = 5;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        while (lines > 0) {
            int count = lines;

            while (count > 0) {
                System.out.print("#");
                count--;
            }
            System.out.println();
            lines--;
        }
        System.out.println();

        lines = 5;
        int symbolNumber = 1;

        do {
            int symbolOut = symbolNumber;
            do {
                System.out.print("$");
                symbolOut--;
            } while (symbolOut > 0);
            lines--;
            if (lines < 3) {
                symbolNumber--;
            } else {
                symbolNumber++;
            }
            System.out.println();
        } while (lines > 0);

        // 7. Отображение ASCII-символов
        System.out.println("\n7. Отображение ASCII-символов");

        System.out.println("DECIMAL   CHARACTER   DESCRIPTION");
        for (int i = 33; i < 123; i++) {
            if ((i < 48 && i % 2 == 1) || (i > 96 && i % 2 == 0)) {
                System.out.printf("  %-4d %8c %10s %-22s %n", i, i, "", Character.getName(i));
            }
        }

        // 8. Проверка, является ли число палиндромом
        System.out.println("\n8. Проверка, является ли число палиндромом");

        srcNumber = 1234321;
        int srcNumberCopy = srcNumber;
        int reverseNumber = 0;

        while (srcNumberCopy > 0) {
            reverseNumber *= 10;
            reverseNumber += srcNumberCopy % 10;
            srcNumberCopy /= 10;
        }
        if (srcNumber == reverseNumber) {
            System.out.println("число " + srcNumber + " является палиндромом");
        } else {
            System.out.println("число " + srcNumber + " не является палиндромом");
        }

        // 9. Проверка, является ли число счастливым
        System.out.println("\n9. Проверка, является ли число счастливым");

        srcNumber = 123321;
        int leftHelf = srcNumber / 1000;
        int sumLeftHalf = 0;
        int rightHalf = srcNumber % 1000;
        int sumRightHalf = 0;

        for (int i = 0; i < 3; i++) {
            sumLeftHalf += leftHelf % 10;
            leftHelf /= 10;
            sumRightHalf += rightHalf % 10;
            rightHalf /= 10;
        }
        if (sumLeftHalf == sumRightHalf) {
            System.out.println("Число " + srcNumber + " является счастливым");
        } else {
            System.out.println("Число " + srcNumber + " не является счастливым");
        }
        System.out.printf("Сумма цифр ABC = %s, а сумма DEF = %s%n", sumLeftHalf, sumRightHalf);

        // 10. Отображение таблицы умножения Пифагора
        System.out.println("\n10. Отображение таблицы умножения Пифагора");

        System.out.print("   |");
        for (int i = 2; i < 10; i++) {
            System.out.printf("%3s", i);
        }
        System.out.println("\n----------------------------");
        for (int i = 2; i < 10; i++) {
            System.out.printf("%2s |", i);
            for (int j = 2; j < 10; j++) {
                System.out.printf("%3s", i * j);
            }
            System.out.println();
        }
    }
}