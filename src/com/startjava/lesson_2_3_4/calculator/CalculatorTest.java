package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        do {
            System.out.print("\nВведите математическое выражение: ");
            try {
                String expression = console.nextLine().trim().replaceAll("\\s+", " ");
                System.out.println(expression + " = " +
                        new DecimalFormat("#.###").format(Calculator.calculate(expression)));
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
            System.out.print("\nХотите продолжить вычисления? [yes / no]: ");
        } while (repeat(console));
        console.close();
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