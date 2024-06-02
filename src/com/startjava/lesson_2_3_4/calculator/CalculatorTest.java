package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Calculator calc = new Calculator();

        do {
            System.out.print("Введите математическое выражение: ");
            String[] expressions = console.nextLine().split(" ");

            calc.setArg1(Integer.parseInt(expressions[0]));
            calc.setSign(expressions[1].charAt(0));
            calc.setArg2(Integer.parseInt(expressions[2]));

            double result = calc.calculate();
            System.out.println(expressions[0] + " " + expressions[1] + " " + expressions[2] + " = " +
                    new DecimalFormat("#.###").format(result));

            System.out.print("Хотите продолжить вычисления? [yes / no]: ");
        } while (repeat(console));
        console.close();
    }

    static boolean repeat(Scanner console) {
        String option = console.nextLine().toLowerCase();
        if (!"yes".equals(option) && !"no".equals(option)) {
            System.out.print("Введите корректный ответ [yes / no]: ");
            return repeat(console);
        } else return "yes".equals(option);
    }
}