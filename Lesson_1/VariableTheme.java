import java.math.BigDecimal;
import java.math.RoundingMode;

public class VariableTheme {
    public static void main(String[] args) {
        // 1. Вывод характеристик компьютера
        System.out.println("1. Вывод характеристик компьютера");

        byte bitSize = 64;
        short ramSize = 16384;
        int flashMemorySize = 2097152;
        long cpuFrequency = 2080385124;
        float performanceFactor = 8.3F;
        double batteryLife = 96.25;
        char efficiencyClass = 'A';
        boolean isAmd = true;

        System.out.println(isAmd + " производитель AMD");
        System.out.println(bitSize + "-х битный процессор");
        System.out.println(cpuFrequency + " Гц частота процессора");
        System.out.println(efficiencyClass + "-класс энерго-эффективности процессора");
        System.out.println(ramSize + " Мбайт оперативной памяти");
        System.out.println(flashMemorySize + " Мбайт флэш памяти");
        System.out.println(performanceFactor + " коэффициент производительности");
        System.out.println(batteryLife + "% ресурс аккумулятора");

        // 2. Расчет стоимости товара со скидкой
        System.out.println("\n2. Расчет стоимости товара со скидкой");

        var penPrice = new BigDecimal("105.5");
        var bookPrice = new BigDecimal("235.83");
        var discount = new BigDecimal("0.11");
        var totalPrice = penPrice.add(bookPrice);

        System.out.println(totalPrice + " руб., общая стоимость товаров без скидки");
        System.out.println(totalPrice
                .multiply(discount)
                .setScale(2, RoundingMode.HALF_UP) + " руб., сумма скидки");
        System.out.println(totalPrice
                .multiply(BigDecimal.ONE.subtract(discount))
                .setScale(2, RoundingMode.HALF_UP) + " руб., общая стоимость товаров со скидкой");

        // 3. Вывод слова JAVA
        System.out.println("\n3. Вывод слова JAVA");
        System.out.println("   J    a  v     v  a");
        System.out.println("   J   a a  v   v  a a");
        System.out.println("J  J  aaaaa  V V  aaaaa");
        System.out.println(" JJ  a     a  V  a     a");

        // 4. Вывод min и max значений целых числовых типов
        System.out.println("\n4. Вывод min и max значений целых числовых типов");

        byte byteMinMax = 127;
        short shortMinMax = 32767;
        int intMinMax = 2147483647;
        long longMinMax = 9223372036854775807L;

        System.out.println(byteMinMax + "\n" + ++byteMinMax + "\n" + --byteMinMax + "\n");
        System.out.println(shortMinMax + "\n" + ++shortMinMax + "\n" + --shortMinMax + "\n");
        System.out.println(intMinMax + "\n" + ++intMinMax + "\n" + --intMinMax + "\n");
        System.out.println(longMinMax + "\n" + ++longMinMax + "\n" + --longMinMax + "\n");

        // 5. Перестановка значений переменных
        System.out.println("\n5. Перестановка значений переменных");

        int a = 2;
        int b = 5;
        int swap;

        System.out.println("Первое число = " + a + "\t Второе число = " + b);
        System.out.println("Перестановка с помощью третьей переменной");
        swap = a;
        a = b;
        b = swap;
        System.out.println("Первое число = " + a + "\t Второе число = " + b);
        System.out.println("Перестановка с помощью арифметических операций");
        a += b;
        b = a - b;
        a -= b;
        System.out.println("Первое число = " + a + "\t Второе число = " + b);
        System.out.println("Перестановка с помощью побитовой операции ^");
        a ^= b;
        b = a ^ b;
        a ^= b;
        System.out.println("Первое число = " + a + "\t Второе число = " + b);

        // 6. Вывод символов и их кодов
        System.out.println("\n6. Вывод символов и их кодов");

        char dollar = '$';
        char asterisk = '*';
        char atSign = '@';
        char verticaBar = '|';
        char tilde = '~';

        System.out.println((int) dollar + " " + dollar);
        System.out.println((int) asterisk + " " + asterisk);
        System.out.println((int) atSign + " " + atSign);
        System.out.println((int) verticaBar + " " + verticaBar);
        System.out.println((int) tilde + " " + tilde);

        // 7. Вывод в консоль ASCII-арт Дюка
        System.out.println("\n7. Вывод в консоль ASCII-арт Дюка");

        char parenthesisLeft = '(';
        char parenthesisRight = ')';
        char slash = '/';
        char backSlash = '\\';
        char underscore = '_';

        System.out.println("    " + slash + backSlash);
        System.out.println("   " + slash + "  " + backSlash);
        System.out.println("  " + slash + underscore + parenthesisLeft + " " + parenthesisRight + backSlash);
        System.out.println(" " + slash + "      " + backSlash);
        System.out.println("" + slash + underscore + underscore + underscore + underscore + slash + 
                backSlash + underscore + underscore + backSlash);

        // 8. Вывод количества сотен, десятков и единиц числа
        System.out.println("\n8. Вывод количества сотен, десятков и единиц числа");

        int number = 123;
        int hundreds = number / 100;
        int tens = (number / 10) % 10;
        int units = number % 10;
        int sum = hundreds + tens + units;
        int product = hundreds * tens * units;

        System.out.println("Число N содержит:");
        System.out.println("  сотен - " + hundreds);
        System.out.println("  десятков - " + tens);
        System.out.println("  единиц - " + units);
        System.out.println("Сумма его цифр = " + sum);
        System.out.println("Произведение = " + product);

        // 9. Вывод времени
        System.out.println("\n9. Вывод времени");

        int time = 86399;
        int hours = time / 3600;
        int minutes = time % 3600 / 60;
        int seconds = time % 60;

        System.out.println(hours + ":" + minutes + ":" + seconds);
    }
}