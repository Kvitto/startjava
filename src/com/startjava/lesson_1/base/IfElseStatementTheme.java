package com.startjava.lesson_1.base;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IfElseStatementTheme {
    public static void main(String[] args) {
        // 1. Перевод псевдокода на язык Java
        System.out.println("\n1. Перевод псевдокода на язык Java");

        boolean male = false;
        
        if (!male) {
            System.out.println("Hi Darling!");
        } else {
            System.out.println("Hi Man!");
        }

        int age = 12;

        if (age > 18) {
            System.out.println("Access permitted! 8)");
        } else {
            System.out.println("Access denied! 8(");
        }

        double height = 2.05;

        if (height < 1.8) {
            System.out.println("Go ahead brave!");
        } else {
            System.out.println("WTF");
        }

        char firstLetterName = "Gary".charAt(0);

        if (firstLetterName == 'M') {
            System.out.println("Hello Mary!");
        } else if (firstLetterName == 'I') {
            System.out.println("Hello Ivan!");
        } else {
            System.out.println("Who are you?");
        }

        // 2. Поиск большего числа
        System.out.println("\n2. Поиск большего числа");

        int a = 5;
        int b = 5;

        if (a > b) {
            System.out.println("Число " + a + " больше " + b);
        } else if (a < b) {
            System.out.println("Число " + b + " больше " + a);
        } else {
            System.out.println("Число " + a + " равно " + b);
        }

        // 3. Проверка числа
        System.out.println("\n3. Проверка числа");

        int testNumber = 0;

        if (testNumber == 0) {
            System.out.println("число равно нулю");
        } else {
            if (testNumber < 0) {
                System.out.print(testNumber + " является отрицательным и ");
            } else {
                System.out.print(testNumber + " является положительным и ");
            }
            if (testNumber % 2 == 0) {
                System.out.println("четным");
            } else {
                System.out.println("нечетным");
            }
        }

        // 4. Поиск одинаковых цифр в числах
        System.out.println("\n4. Поиск одинаковых цифр в числах");

        a = 485;
        b = 396;

        int digits = 0;
        int ranks = 0;

        if (a / 100 == b / 100) {
            ranks = 3;
            digits = a / 100;
        }
        if ((a % 100) / 10 == (b % 100) / 10) {
            ranks = ranks * 10 + 2;
            digits = digits * 10 + (a % 100) / 10;
        }
        if (a % 10 == b % 10) {
            ranks = ranks * 10 + 1;
            digits = digits * 10 + a % 10;
        }
        if (ranks > 0) {
            System.out.println("исходные числа: " + a + " " + b);
            System.out.println("одинаковые числа: " + digits);
            System.out.println("номера разрядов: " + ranks);
        } else {
            System.out.println("Равных цифр нет");
        }

        // 5. Определение символа по его коду
        System.out.println("\n5. Определение символа по его коду");

        char code = '^';

        if (code >= '0' && code <= '9') {
            System.out.println("Символ \"" + code + "\" является цифрой");
        } else if (code >= 'A' && code <= 'Z') {
            System.out.println("Символ \"" + code + "\" является большой буквой");
        } else if (code >= 'a' && code <= 'z') {
            System.out.println("Символ \"" + code + "\" является маленькой буквой");
        } else {
            System.out.println("Символ \"" + code + "\" является ни цифрой, ни буквой");
        }

        // 6. Подсчет суммы вклада и начисленных банком %
        System.out.println("\n6. Подсчет суммы вклада и начисленных банком %");

        var deposit = new BigDecimal("321123.59");
        var interestRate = new BigDecimal("0.05");

        if (deposit.compareTo(BigDecimal.valueOf(300000)) > 0) {
            interestRate = BigDecimal.valueOf(0.1);
        } else if (deposit.compareTo(BigDecimal.valueOf(100000)) > 0) {
            interestRate = BigDecimal.valueOf(0.07);
        }
        System.out.printf("Сумма вклада: %.2f %n", deposit);
        System.out.printf("Сумма начисленного %%: %.2f %n",
                deposit.multiply(interestRate)
                .setScale(2, RoundingMode.HALF_UP));
        System.out.printf("Итоговая сумма с %%: %.2f %n",
                (deposit.add(deposit.multiply(interestRate))
                .setScale(2, RoundingMode.HALF_UP)));

        // 7. Определение оценки по предметам
        System.out.println("\n7. Определение оценки по предметам");

        int historyPercent = 59;
        int historyGrade = 2;

        if (historyPercent > 91) {
            historyGrade = 5;
        } else if (historyPercent > 73) {
            historyGrade = 4;
        } else if (historyPercent > 60) {
            historyGrade = 3;
        }

        int programmingPercent = 92;
        int programmingGrade = 2;

        if (programmingPercent > 91) {
            programmingGrade = 5;
        } else if (programmingPercent > 73) {
            programmingGrade = 4;
        } else if (programmingPercent > 60) {
            programmingGrade = 3;
        }

        System.out.println("История - " + historyGrade);
        System.out.println("Программирование - " + programmingGrade);
        System.out.println("Средний балл оценок по предметам - " +
                (double) (historyGrade + programmingGrade) / 2);
        System.out.println("Средний процент по предметам - " +
                (double) (historyPercent + programmingPercent) / 2);

        // 8. Расчет годовой прибыли
        System.out.println("\n8. Расчет годовой прибыли");

        var incomeMonth = new BigDecimal("13025.233");
        var rentMonth = new BigDecimal("5123.018");
        var netCost = new BigDecimal("9001.729");
        var sum = incomeMonth.subtract(rentMonth)
                .subtract(netCost)
                .multiply(BigDecimal.valueOf(12))
                .setScale(2, RoundingMode.HALF_UP);

        if (sum.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.printf("Прибыль за год: %.2f руб. %n", sum);
        } else {
            System.out.printf("Прибыль за год: +%.2f руб. %n", sum);
        }
    }
}