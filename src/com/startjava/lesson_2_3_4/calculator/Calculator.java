package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    private int arg1;
    private char sign;
    private int arg2;

    public void setArg1(int arg1) {
        this.arg1 = arg1;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    public void setArg2(int arg2) {
        this.arg2 = arg2;
    }

    public double calculate() {
        if (arg2 == 0 && (sign == '/' || sign == '%')) {
            System.out.println("Ошибка: деление на ноль запрещено");
            return Double.NaN;
        }

        return switch (sign) {
            case '+' -> arg1 + arg2;
            case '-' -> arg1 - arg2;
            case '*' -> arg1 * arg2;
            case '/' -> (double) arg1 / arg2;
            case '^' -> Math.pow(arg1, arg2);
            case '%' -> Math.IEEEremainder(arg1, arg2);
            default -> {
                System.out.println("Ошибка: операция '" + sign + "' не поддерживается." +
                        " Доступны следующие операции: +, -, *, /, ^, %");
                yield Double.NaN;
            }
        };
    }
}