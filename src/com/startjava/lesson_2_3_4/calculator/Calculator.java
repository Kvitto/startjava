package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    private static final int BINOMIAL = 3;
    private static int arg1;
    private static char sign;
    private static int arg2;

    private Calculator() {
    }

    public static double calculate(String expression) throws RuntimeException {
        prepareExpression(expression);
        return switch (sign) {
            case '+' -> arg1 + arg2;
            case '-' -> arg1 - arg2;
            case '*' -> arg1 * arg2;
            case '/' -> (double) arg1 / arg2;
            case '^' -> Math.pow(arg1, arg2);
            case '%' -> Math.IEEEremainder(arg1, arg2);
            default -> throw new RuntimeException("Ошибка: операция '" + sign + "' не поддерживается." +
                        " Доступны следующие операции: +, -, *, /, ^, %");
        };
    }

    private static void prepareExpression(String expression) throws RuntimeException {
        String[] elements = expression.split(" ");
        if (elements.length != BINOMIAL) throw new RuntimeException("Ошибка: выражения данного " +
                "вида не поддерживаются.\nВведите выражение состоящее из 2-х членов и знака отделенного " +
                "пробелами.");
        sign = elements[1].charAt(0);
        try {
            arg1 = Integer.parseInt(elements[0]);
            arg2 = Integer.parseInt(elements[2]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Ошибка: недопустимый формат чисел.\nИспользуйте целые числа.");
        }
        if (arg2 == 0 && (sign == '/' || sign == '%')) {
            throw new RuntimeException("Ошибка: деление на ноль запрещено");
        }
    }
}