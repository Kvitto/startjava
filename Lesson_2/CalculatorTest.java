import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var calculator = new Calculator();
        String choice;

        do {
            System.out.println("Введите первое число: ");
            calculator.setArg1(scanner.nextInt());
            System.out.println("Введите знак математической операции: ");
            calculator.setSign(scanner.next().charAt(0));
            System.out.println("Введите второе число: ");
            calculator.setArg2(scanner.nextInt());
            System.out.println(calculator.calculate());
            do {
                System.out.println("Хотите продолжить вычисления? [yes/no]:");
                choice = scanner.next().toLowerCase();
            } while (!"yes".equals(choice) && !"no".equals(choice));
        } while (choice.equals("yes"));
        scanner.close();
    }
}