public class Calculator {
    public static void main(String[] args) {
        // первый операнд
        int a = 5;

        // второй операнд
        int b = 0;

        // оператор
        char sign = '^';

        // результат
        int result = 0;

        if (sign == '+') {
            result = a + b;
            System.out.println(a + " " + sign + " " + b + " = " + result);
        } else if (sign == '-') {
            result = a - b;
            System.out.println(a + " " + sign + " " + b + " = " + result);
        } else if (sign == '*') {
            result = a * b;
            System.out.println(a + " " + sign + " " + b + " = " + result);
        } else if (sign == '/') {
            result = a / b;
            System.out.println(a + " " + sign + " " + b + " = " + result);
        } else if (sign == '^') {
            result = 1;
            for (int i = 1; i <= b; i++) {
                result *= a;
            }
            System.out.println(a + " " + sign + " " + b + " = " + result);
        } else if (sign == '%') {
            result = a % b;
            System.out.println(a + " " + sign + " " + b + " = " + result);
        } else {
            System.out.println("Неизвестная операция");
        }
    }
}