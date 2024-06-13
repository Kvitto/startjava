package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    private static final String YES = "yes";
    private static final String NO = "no";

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        do {
            String expression = inputExpression(console);
            try {
                printResult(expression, Calculator.calculate(expression));
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } while (shouldContinue(console));
        console.close();
    }

    private static String inputExpression(Scanner console) {
        System.out.print("\nВведите математическое выражение: ");
        return console.nextLine().trim().replaceAll("\\s+", " ");
    }

    private static void printResult(String expression, double result) {
        System.out.println(expression + " = " +
                new DecimalFormat("#.###").format(result));
    }

    private static boolean shouldContinue(Scanner console) {
        System.out.print("\nХотите продолжить вычисления? [yes / no]: ");
        String option = console.nextLine().toLowerCase();
        if (!YES.equals(option) && !NO.equals(option)) {
            System.out.print("Введите корректный ответ [yes / no]: ");
            return shouldContinue(console);
        }
        return YES.equals(option);
    }
}