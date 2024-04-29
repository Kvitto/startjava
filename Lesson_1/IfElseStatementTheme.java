public class IfElseStatementTheme {
    public static void main(String[] args) {
        // 1. Перевод псевдокода на язык Java
        System.out.println("\n1. Перевод псевдокода на язык Java");

        boolean male = false;
        int age = 12;
        double height = 2.05;
        char firstLetterName = "Gary".charAt(0);

        if (!male) {
            System.out.println("Hi Darling!");
        } else {
            System.out.println("Hi Man!");
        }

        if (age > 18) {
            System.out.println("Access permitted! 8)");
        } else {
            System.out.println("Access denied! 8(");
        }

        if (height < 1.8) {
            System.out.println("Go ahead brave!");
        } else {
            System.out.println("WTF");
        }

        if (firstLetterName == 'M') {
            System.out.println("Hello Mary!");
        } else if (firstLetterName == 'I') {
            System.out.println("Hello Ivan!");
        } else {
            System.out.println("Who are you?");
        }

        // 2. Поиск большего числа
        System.out.println("\n2. Поиск большего числа");

        int a = 5;
        int b = 5;

        if (a > b) {
            System.out.println("Число " + a + " больше " + b);
        } else if (a < b) {
            System.out.println("Число " + b + " больше " + a);
        } else {
            System.out.println("Число " + a + " равно " + b);
        }

        // 3. Проверка числа
        System.out.println("\n3. Проверка числа");

        int testNumber = 0;

        if (testNumber == 0) {
            System.out.println("число равно нулю");
        } else {
            if (testNumber < 0) {
                System.out.print(testNumber + " является отрицательным и ");
            } else {
                System.out.print(testNumber + " является положительным и ");
            }
            if (testNumber % 2 == 0) {
                System.out.println("четным");
            } else {
                System.out.println("нечетным");
            }
        }

        // 4. Поиск одинаковых цифр в числах
        System.out.println("\n4. Поиск одинаковых цифр в числах");

        int digits = 0;
        int ranks = 0;
        testNumber = a - b;

        a = 123;
        b = 223;

        if (testNumber / 100 == 0 || (testNumber % 100) / 10 == 0 || testNumber % 10 == 0) {
            if (testNumber / 100 == 0) {
                ranks = 3;
                digits = a / 100;
            }
            if ((testNumber % 100) / 10 == 0) {
                ranks = ranks * 10 + 2;
                digits = digits * 10 + (a % 100) / 10;
            }
            if (testNumber % 10 == 0) {
                ranks = ranks * 10 + 1;
                digits = digits * 10 + a % 10;
            }
            System.out.println("исходные числа: " + a + " " + b);
            System.out.println("одинаковые числа: " + digits);
            System.out.println("номера разрядов: " + ranks);
        } else {
            System.out.println("Равных цифр нет");
        }

        // 5. Определение символа по его коду
        System.out.println("\n5. Определение символа по его коду");

        char code = '\u005E';

        if ((int) '0' <= (int) code && (int) code <= (int) '9') {
            System.out.println("Символ \"" + code + "\" является цифрой");
        } else if ((int) 'A' <= (int) code && (int) code <= (int) 'Z') {
            System.out.println("Символ \"" + code + "\" является большой буквой");
        } else if ((int) 'a' <= (int) code && (int) code <= (int) 'z') {
            System.out.println("Символ \"" + code + "\" является маленькой буквой");
        } else {
            System.out.println("Символ \"" + code + "\" является ни цифрой, ни буквой");
        }

        // 6. Подсчет суммы вклада и начисленных банком %
        System.out.println("\n6. Подсчет суммы вклада и начисленных банком %");

        // депозит
        double deposit = 301000;

        if (deposit < 100000) {
            System.out.println("Сумма вклада: " + deposit);
            System.out.println("Сумма начисленного %: " + deposit * 0.05);
            System.out.println("Итоговая сумма с %: " + deposit * 1.05);
        } else if (100000 <= deposit && deposit <= 300000) {
            System.out.println("Сумма вклада: " + deposit);
            System.out.println("Сумма начисленного %: " + deposit * 0.07);
            System.out.println("Итоговая сумма с %: " + deposit * 1.07);
        } else if (300000 < deposit) {
            System.out.println("Сумма вклада: " + deposit);
            System.out.println("Сумма начисленного %: " + deposit * 0.1);
            System.out.println("Итоговая сумма с %: " + deposit * 1.1);
        }

        // 7. Определение оценки по предметам
        System.out.println("\n7. Определение оценки по предметам");

        int historyPercent = 59;
        int historyGrade = 0;
        int programmingPercent = 92;
        int programmingGrade = 0;

        if (historyPercent <= 60) {
            historyGrade = 2;
        } else if (historyPercent <= 73) {
            historyGrade = 3;
        } else if (historyPercent <= 91) {
            historyGrade = 4;
        } else if (historyPercent <= 100) {
            historyGrade = 5;
        }

        if (programmingPercent <= 60) {
            programmingGrade = 2;
        } else if (programmingPercent <= 73) {
            programmingGrade = 3;
        } else if (programmingPercent <= 91) {
            programmingGrade = 4;
        } else if (programmingPercent <= 100) {
            programmingGrade = 5;
        }

        System.out.println("История - " + historyGrade);
        System.out.println("Программирование - " + programmingGrade);
        System.out.println("Средний балл оценок по предметам - " + (double) (historyGrade +
                programmingGrade) / 2);
        System.out.println("Средний процент по предметам - " + (double) (historyPercent +
                programmingPercent) / 2);

        // 8. Расчет годовой прибыли
        System.out.println("\n8. Расчет годовой прибыли");

        int incomeMonth = 13000;
        int rentMonth = 5000;
        int netCost = 9000;
        int sum = (incomeMonth - rentMonth - netCost) * 12;

        if (sum > 0) {
            System.out.println("Прибыль за год: +" + sum + " руб.");
        } else if (sum < 0) {
            System.out.println("Прибыль за год: " + sum + " руб.");
        } else {
            System.out.println("Прибыль за год: " + sum + " руб.");
        }
    }
}