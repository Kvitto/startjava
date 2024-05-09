import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var calculator = new Calculator();
        char choice;

        do {
            System.out.println("Введите первое число: ");
            calculator.setA(scanner.nextInt());
            System.out.println("Введите знак математической операции: ");
            calculator.setSign(scanner.next().charAt(0));
            System.out.println("Введите второе число: ");
            calculator.setB(scanner.nextInt());
            calculator.calculate();
            System.out.println("Хотите продолжить вычисления? [yes/no]:");
            choice = scanner.next().toLowerCase().charAt(0);
        } while (choice == 'y');
        scanner.close();
    }
}