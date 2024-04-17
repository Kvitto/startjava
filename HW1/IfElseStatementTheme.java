public class IfElseStatementTheme {
    public static void main(String[] args) {
        // 1. Перевод псевдокода на язык Java
        System.out.println("\n1. Перевод псевдокода на язык Java");

        // Мужчина
        boolean man = false;

        if (!man) {
            System.out.println("Hi Darling!");
        } else {
            System.out.println("Hi Man!");
        }

        // Возраст
        int age = 12;
        
        if (age > 18) {
            System.out.println("Access permitted! 8)");
        } else {
            System.out.println("Access denied! 8(");
        }

        // Рост
        double height = 1.75;
        
        if (height < 1.8) {
            System.out.println("Go ahead brave!");
        } else {
            System.out.println("Be careful!");
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

        // переменная 1
        int firstNumber = 3;

        // переменная 2
        int secondNumber = 8;

        if (firstNumber > secondNumber) {
            System.out.println("Число " + firstNumber + " больше " + secondNumber);
        } else if (firstNumber < secondNumber) {
            System.out.println("Число " + secondNumber + " больше " + firstNumber);
        } else {
            System.out.println("Число " + firstNumber + " равно " + secondNumber);
        }

        // 3. Проверка числа
        System.out.println("\n3. Проверка числа");

        // число для проверки
        int testNumber = 0;

        if (testNumber == 0) {
            System.out.println("число равно нулю");
        } else {
            if (testNumber < 0) {
                System.out.print(testNumber + " является отрицательным и ");
            } else {
                System.out.print(testNumber + " является положительным и ");
            }
            if (testNumber%2 == 0) {
                System.out.println("четным");
            } else {
                System.out.println("нечетным");
            }
        }

        // 4. Поиск одинаковых цифр в числах
        System.out.println("\n4. Поиск одинаковых цифр в числах");

        

    }
}