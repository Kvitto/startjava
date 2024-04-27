public class CyclesTheme {
    public static void main(String[] args) {
        // 1. Подсчет суммы четных и нечетных чисел
        System.out.println("\n1. Подсчет суммы четных и нечетных чисел");

        int even = 0;
        int odd = 0;
        int iteration = -10;

        do {
            if (iteration % 2 == 0) {
                even += iteration;
            } else {
                odd += iteration;
            }
            iteration++;
        } while (iteration <= 21);
        System.out.println("В отрезке [-10, 21] сумма четных чисел = " + even + ", а нечетных = " + odd);

        // 2. Вывод чисел в порядке убывания
        System.out.println("\n2. Вывод чисел в порядке убывания");

        int maxNumber = -1;
        int centralNumber = 5;
        int minNumber = 10;

        while (!(maxNumber > centralNumber && centralNumber > minNumber)) {
            if (maxNumber < centralNumber) {
                maxNumber = maxNumber + centralNumber;
                centralNumber = maxNumber - centralNumber;
                maxNumber -= centralNumber;
            }
            if (centralNumber < minNumber) {
                minNumber = minNumber + centralNumber;
                centralNumber = minNumber - centralNumber;
                minNumber -= centralNumber;
            }
        }

        for (int i = maxNumber; i >= minNumber; i--) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 3. Вывод реверсивного числа и суммы его цифр
        System.out.println("\n3. Вывод реверсивного числа и суммы его цифр");

        int srcNumber = 1234;
        int reversNumber = 0;
        int sumReversNumber = 0;

        while (srcNumber > 0) {
            reversNumber *= 10;
            reversNumber += srcNumber % 10;
            sumReversNumber += srcNumber % 10;
            srcNumber /= 10;
        }

        System.out.println("Число в обратном порядке - " + reversNumber);
        System.out.println("Сумма его цифр - " + sumReversNumber);

        // 4. Вывод чисел в несколько строк
        System.out.println("\n4. Вывод чисел в несколько строк");

        int rows = 0;

        for (int i = 1; i < 24; i++) {
            if (i % 2 == 1) {
                if (rows < 4) {
                    System.out.printf("%4d", i);
                    rows++;
                } else {
                    System.out.printf("%4d", i);
                    System.out.println();
                    rows = 0;
                }
            }
        }
        if (rows > 0) {
            for (; rows < 5; rows++) {
                if (rows < 4) {
                    System.out.printf("%4d", 0);
                } else if (rows == 4) {
                    System.out.printf("%4d", 0);
                    System.out.println();
                }
            }
        }

        // 5. Проверка количества двоек числа на четность/нечетность
        System.out.println("\n5. Проверка количества двоек числа на четность/нечетность");

        int countTwo = 0;
        int tempVal = 0;
        srcNumber = 3242592;

        System.out.print("В " + srcNumber);

        while (srcNumber > 0) {
            tempVal = srcNumber % 10;
            srcNumber /= 10;
            if (tempVal == 2) countTwo++;
        }

        if (countTwo % 2 == 0) {
            System.out.println(" четное количество двоек — " + countTwo);
        } else {
            System.out.println(" нечетное количество двоек — " + countTwo);
        }

        // 6. Отображение геометрических фигур
        System.out.println("\n6. Отображение геометрических фигур");

        int lines = 5;
        int symbolNumber = 1;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        while (lines > 0) {
            int cnt = lines;

            while (cnt > 0) {
                System.out.print("#");
                cnt--;
            }
            System.out.println();
            lines--;
        }
        System.out.println();

        lines = 5;

        do {
            int j = symbolNumber;
            do {
                System.out.print("$");
                j--;
            } while (j > 0);
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
            if (i > 47 && i < 97) continue;
            System.out.printf("  %-4d %8s %10s %-22s %n", i, (char) i, "", Character.getName(i));
        }

        // 8. Проверка, является ли число палиндромом
        System.out.println("\n8. Проверка, является ли число палиндромом");

        srcNumber = 1234321;
        tempVal = srcNumber;
        reversNumber = 0;

        while (tempVal > 0) {
            reversNumber += tempVal % 10;
            reversNumber *= 10;
            tempVal /= 10;
        }
        reversNumber /= 10;
        if (srcNumber == reversNumber) {
            System.out.println("число " + srcNumber + " является палиндромом");
        } else {
            System.out.println("число " + srcNumber + " не является палиндромом");
        }

        // 9. Проверка, является ли число счастливым
        System.out.println("\n9. Проверка, является ли число счастливым");

        srcNumber = 123321;
        int abc = srcNumber / 1000;
        int abcSum = 0;
        int def = srcNumber % 1000;
        int defSum = 0;

        for (int i = 0; i < 3; i++) {
            abcSum += abc % 10;
            abc /= 10;
            defSum += def % 10;
            def /= 10;
        }
        if (abcSum == defSum) {
            System.out.println("Число " + srcNumber + " является счастливым");
            System.out.printf("Сумма цифр ABC = %s, а сумма DEF = %s%n", abcSum, defSum);
        } else {
            System.out.println("Число " + srcNumber + " не является счастливым");
            System.out.printf("Сумма цифр ABC = %s, а сумма DEF = %s%n", abcSum, defSum);
        }

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