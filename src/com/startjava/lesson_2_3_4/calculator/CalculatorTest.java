package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Calculator calc = new Calculator();
        do {
            System.out.print("Введите математическое выражение: ");
            String expression = console.nextLine();
            printResult(expression, calc.calculate(expression));
            System.out.print("Хотите продолжить вычисления? [yes / no]: ");
        } while (repeat(console));
        console.close();
    }

    private static void printResult(String expression, double result) {
        if (Double.isNaN(result)) {
            System.out.println("Результат не определен!");
            return;
        }
        System.out.println(expression + " = " + new DecimalFormat("#.###").format(result));
    }

    private static boolean repeat(Scanner console) {
        String option = console.nextLine().toLowerCase();
        if (!"yes".equals(option) && !"no".equals(option)) {
            System.out.print("Введите корректный ответ [yes / no]: ");
            return repeat(console);
        }
        return "yes".equals(option);
    }
}