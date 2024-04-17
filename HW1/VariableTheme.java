public class VariableTheme {
    public static void main(String[] args) {
        // битность процессора
        byte bitSize = 64;

        // МБайт оперативной памяти
        short operatingMemorySize = 16384;

        // МБайт флеш памяти
        int flashMemorySize = 2097152;

        // Гц частота процессора
        long cpuFrequency = 2080385124;

        // коэффициент производительности
        float performanceFactor = 8.3F;

        // % ресурс аккумулятора
        double batteryLife = 96.25;

        // Класс энергоэффективности процессора
        char efficiencyClass = 'A';

        // Процессор AMD
        boolean isAmd = true;

        // 1. Вывод характеристик компьютера
        System.out.println("1. Вывод характеристик компьютера");
        System.out.println(isAmd + " производитель AMD");
        System.out.println(bitSize + "-х битный процессор");
        System.out.println(cpuFrequency + " Гц частота процессора");
        System.out.println(efficiencyClass + "-класс энергоэффективности процесора");
        System.out.println(operatingMemorySize + " МБайт оперативной памяти");
        System.out.println(flashMemorySize + " МБайт флеш памяти");
        System.out.println(performanceFactor + " коэффициент производительности");
        System.out.println(batteryLife + "% ресурс аккумулятора");

        // стоимость ручки, руб.
        double penPrice = 100;

        // стоимость книги, руб.
        double bookPrice = 200;

        // размер скидки, %
        double discount = 11;

        // 2. Расчет стоимости товара со скидкой
        System.out.println("\n2. Расчет стоимости товара со скидкой");
        System.out.println(penPrice + bookPrice + " руб., общая стоимость товаров без скидки");
        System.out.println((penPrice + bookPrice) * discount / 100 + " руб., сумма скидки");
        System.out.println((penPrice + bookPrice) * (100 - discount) / 100 +
                " руб., общая стоимость товаров со скидкой");

        // 3. Вывод слова JAVA
        System.out.println("\n3. Вывод слова JAVA");
        System.out.println("   J    a  v     v  a");
        System.out.println("   J   a a  v   v  a a");
        System.out.println("J  J  aaaaa  V V  aaaaa");
        System.out.println(" JJ  a     a  V  a     a");

        // максимальное значение для типа byte
        byte byteMinMax = 127;

        // максимальное значение для типа short
        short shortMinMax = 32767;

        // максимальное значение для типа int
        int intMinMax = 2147483647;

        // максимальное значение для типа long
        long longMinMax = 9223372036854775807L;

        // 4. Вывод min и max значений целых числовых типов
        System.out.println("\n4. Вывод min и max значений целых числовых типов");
        System.out.println(byteMinMax);
        System.out.println(++byteMinMax);
        System.out.println(--byteMinMax);
        System.out.println(shortMinMax);
        System.out.println(++shortMinMax);
        System.out.println(--shortMinMax);
        System.out.println(intMinMax);
        System.out.println(++intMinMax);
        System.out.println(--intMinMax);
        System.out.println(longMinMax);
        System.out.println(++longMinMax);
        System.out.println(--longMinMax);

        // первое число 2
        int firstNumber = 2;

        // второе число 5
        int secondNumber = 5;

        // буфер
        int buffer;

        // 5. Перестановка значений переменных
        System.out.println("\n5. Перестановка значений переменных");
        System.out.println("Первое число = " + firstNumber + "\t Второе число = " + secondNumber);
        System.out.println("Перестановка с помощью третьей переменной");
        buffer = firstNumber;
        firstNumber = secondNumber;
        secondNumber = buffer;
        System.out.println("Первое число = " + firstNumber + "\t Второе число = " + secondNumber);
        System.out.println("Перестановка с помощью арифметических операций");
        firstNumber = firstNumber + secondNumber;
        secondNumber = firstNumber - secondNumber;
        firstNumber -= secondNumber;
        System.out.println("Первое число = " + firstNumber + "\t Второе число = " + secondNumber);
        System.out.println("Перестановка с помощью побитовой операции ^");
        firstNumber = firstNumber ^ secondNumber;
        secondNumber = firstNumber ^ secondNumber;
        firstNumber ^= secondNumber;
        System.out.println("Первое число = " + firstNumber + "\t Второе число = " + secondNumber);

        // символ '$'
        char dollar = '$';

        // символ '*'
        char asterisk = '*';

        // символ '@'
        char atSign = '@';

        // символ '|'
        char verticaBar = '|';

        // символ '~'
        char tilde = '~';

        // 6. Вывод символов и их кодов
        System.out.println("\n6. Вывод символов и их кодов");
        System.out.println((int) dollar + " " + dollar);
        System.out.println((int) asterisk + " " + asterisk);
        System.out.println((int) atSign + " " + atSign);
        System.out.println((int) verticaBar + " " + verticaBar);
        System.out.println((int) tilde + " " + tilde);

        // символ '('
        char parenthesisLeft = '(';

        // символ ')'
        char parenthesisRight = ')';

        // символ '/'
        char slash = '/';

        // символ '\'
        char backSlash = '\\';

        // символ '_'
        char underscore = '_';

        // 7. Вывод в консоль ASCII-арт Дюка
        System.out.println("\n7. Вывод в консоль ASCII-арт Дюка");
        System.out.println("    " + slash + backSlash);
        System.out.println("   " + slash + "  " + backSlash);
        System.out.println("  " + slash + underscore + parenthesisLeft + " " + parenthesisRight + backSlash);
        System.out.println(" " + slash + "      " + backSlash);
        System.out.println("" + slash + underscore + underscore + underscore + underscore + slash + 
                backSlash + underscore + underscore + backSlash);

        // сотни
        int hundreds;

        // десятки
        int tens;

        // еденицы
        int units;
        
        // сумма
        int sum;

        // произведение
        int product;

        // число
        int number = 123;

        hundreds = number / 100;
        tens = (number / 10) % 10;
        units = number % 10;
        sum = hundreds + tens + units;
        product = hundreds * tens * units;

        // 8. Вывод количества сотен, десятков и единиц числа
        System.out.println("\n8. Вывод количества сотен, десятков и единиц числа");
        System.out.println("Число N содержит:");
        System.out.println("  сотен - " + hundreds);
        System.out.println("  десятоков - " + tens);
        System.out.println("  единиц - " + units);
        System.out.println("Сумма его цифр = " + sum);
        System.out.println("Произведение = " + product);

        // часы
        int hours;

        // минуты
        int minutes;

        // секунды
        int seconds;

        // время
        int time = 86399;

        hours = time / 3600;
        time %= 3600;
        minutes = time / 60;
        seconds = time % 60;

        // 9. Вывод времени
        System.out.println("\n9. Вывод времени");
        System.out.println(hours + ":" + minutes + ":" + seconds);
    }
}