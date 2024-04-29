public class CyclesTheme {
    public static void main(String[] args) {
        // 1. Подсчет суммы четных и нечетных чисел
        System.out.println("\n1. Подсчет суммы четных и нечетных чисел");

        int evenSum = 0;
        int oddSum = 0;
        int countFrom = -10;
        int countTo = 21;

        do {
            if (countFrom % 2 == 0) {
                evenSum += countFrom;
            } else {
                oddSum += countFrom;
            }
            countFrom++;
        } while (countFrom <= countTo);
        System.out.println("В отрезке [" + countFrom + ", " + countTo + "] сумма четных чисел = " +
                evenSum + ", а нечетных = " + oddSum);

        // 2. Вывод чисел в порядке убывания
        System.out.println("\n2. Вывод чисел в порядке убывания");

        int a = -1;
        int b = 5;
        int c = 10;
        int min = 0;
        int max = 0;
        
        if (c >= b && b >= a) {
            max = c;
            min = a;
        } else if (a >= c && c >= b) {
            max = a;
            min = b;
        } else if (b >= a && a >= c) {
            max = b;
            min = c;
        }

        System.out.print("В интервале (" + min + "; " + max + ") находятся числа: ");
        for (int i = max - 1; i > min; i--) {
            System.out.print(i + " ");
        }

        // 3. Вывод реверсивного числа и суммы его цифр
        System.out.println("\n\n3. Вывод реверсивного числа и суммы его цифр");

        int srcNumber = 1234;
        int sumReversNumber = 0;

        System.out.print("Число в обратном порядке - ");
        while (srcNumber > 0) {
            System.out.print(srcNumber % 10);
            sumReversNumber += srcNumber % 10;
            srcNumber /= 10;
        }

        System.out.println("\nСумма его цифр - " + sumReversNumber);

        // 4. Вывод чисел в несколько строк
        System.out.println("\n4. Вывод чисел в несколько строк");

        a = 1;
        b = 24;
        int cols = 5;
        int curCol = cols;
        int cycEnd;

        if (b % (cols * 2) > 0) {
            cycEnd = (b / (cols * 2) + 1) * cols * 2;
        } else {
            cycEnd = b;
        }

        for (int i = a; i < cycEnd; i++) {
            if (i % 2 == 1) {
                c = i <= b ? i : 0;
                System.out.printf("%4d", c);
                if (curCol > 1) {
                    curCol--;
                } else {
                    System.out.println();
                    curCol = cols;
                }
            }
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
            if ((i > 47 && i < 97) || (i <= 47 && i % 2 == 0) || (i >= 97 && i % 2 == 1)) continue;
            System.out.printf("  %-4d %8s %10s %-22s %n", i, (char) i, "", Character.getName(i));
        }

        // 8. Проверка, является ли число палиндромом
        System.out.println("\n8. Проверка, является ли число палиндромом");

        srcNumber = 1234321;
        int srcNumberCopy = srcNumber;
        int invertNumber = 0;

        while (srcNumberCopy > 0) {
            invertNumber *= 10;
            invertNumber += srcNumberCopy % 10;
            srcNumberCopy /= 10;
        }
        if (srcNumber == invertNumber) {
            System.out.println("число " + srcNumber + " является палиндромом");
        } else {
            System.out.println("число " + srcNumber + " не является палиндромом");
        }

        // 9. Проверка, является ли число счастливым
        System.out.println("\n9. Проверка, является ли число счастливым");

        srcNumber = 123321;
        int firstThreeDigits = srcNumber / 1000;
        int firstThreeDigitsSum = 0;
        int lastThreeDigits = srcNumber % 1000;
        int lastThreeDigitsSum = 0;

        for (int i = 0; i < 3; i++) {
            firstThreeDigitsSum += firstThreeDigits % 10;
            firstThreeDigits /= 10;
            lastThreeDigitsSum += lastThreeDigits % 10;
            lastThreeDigits /= 10;
        }
        if (firstThreeDigitsSum == lastThreeDigitsSum) {
            System.out.println("Число " + srcNumber + " является счастливым");
        } else {
            System.out.println("Число " + srcNumber + " не является счастливым");
        }
        System.out.printf("Сумма цифр ABC = %s, а сумма DEF = %s%n", firstThreeDigitsSum, lastThreeDigitsSum);

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