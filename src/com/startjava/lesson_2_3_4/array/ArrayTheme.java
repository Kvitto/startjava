package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ArrayTheme {
    public static void main(String[] args) throws InterruptedException {
        reversArray();
        calcFactorial();
        removeArrayElements();
        printAlphabet();
        generateUniqueArray();
        playGallows();
        typeEffect("Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n- James Gosling");
        typeEffect("Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                "- Robert Martin");
        typeEffect(null);
        typeEffect("");
    }

    public static void reversArray() {
        System.out.println("\n1. Реверс значений массива");
        int[] numbers = {5, 2, 3, 1, 6, 4, 7};
        int len = numbers.length;
        int swap;
        System.out.printf("%14s  %-21s %n", "До реверса:", Arrays.toString(numbers));
        for (int i = 0; i < (len / 2); i++) {
            swap = numbers[i];
            numbers[i] = numbers[len - 1 - i];
            numbers[len - 1 - i] = swap;
        }
        System.out.printf("%14s  %-21s %n", "После реверса:", Arrays.toString(numbers));
    }

    public static void calcFactorial() {
        System.out.println("\n2. Вычисление факториала");
        int[] numbers = new int[10];
        int result = 1;
        for (int i = 0; i < 10; i++) {
            numbers[i] = i;
        }
        for (int i = 1; i <= 8; i++) {
            result *= i;
            System.out.print(i < 8 ? i + " * " : "8 = " + result + "\n");
        }
    }

    public static void removeArrayElements() {
        System.out.println("\n3. Удаление элементов массива");
        double[] randNumbs = new double[15];
        for (int i = 0; i < 15; i++) {
            randNumbs[i] = Math.random();
        }
        int len = randNumbs.length;
        int midIndex = len / 2;
        int clearedCell = 0;
        StringBuilder srcArrayView = new StringBuilder();
        StringBuilder modArrayView = new StringBuilder();
        for (int i = 0; i < len; i++) {
            srcArrayView.append(String.format("%.3f ", randNumbs[i]));
            if (randNumbs[i] > randNumbs[midIndex]) {
                randNumbs[i] = 0;
                clearedCell++;
            }
            modArrayView.append(String.format("%.3f ", randNumbs[i]));
            if (i == midIndex) {
                srcArrayView.append("\n");
                modArrayView.append("\n");
            }
        }
        System.out.println("Исходный массив:");
        System.out.println(srcArrayView);
        System.out.println("Измененный массив:");
        System.out.println(modArrayView);
        System.out.println("Количество обнуленных ячеек = " + clearedCell);
    }

    public static void printAlphabet() {
        System.out.println("\n4. Вывод алфавита лесенкой");
        char[] alphabet = new char[26];
        int index = 0;
        int len = alphabet.length;
        for (char i = 'A'; i <= 'Z' ; i++) {
            alphabet[index] = i;
            index++;
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = len - 1; j >= i; j--) {
                System.out.print(alphabet[j]);
            }
            System.out.println();
        }
    }

    public static void generateUniqueArray()
    {
        System.out.println("\n5. Заполнение массива уникальными числами");
        int[] uniqueSq = new int[30];
        int rndNumb;
        boolean isUnique;
        for (int i = 0; i < uniqueSq.length; i++) {
            do {
                rndNumb = (int) (60 + Math.random() * 40);
                isUnique = true;
                for (int numb : uniqueSq) {
                    if (rndNumb == numb) {
                        isUnique = false;
                        break;
                    }
                }
            } while (!isUnique);
            uniqueSq[i] = rndNumb;
        }
        Arrays.sort(uniqueSq);
        int split = 0;
        for (int numb : uniqueSq) {
            System.out.print(numb + " ");
            if (++split % 10 == 0) System.out.println();
        }
    }

    public static void playGallows() {
        System.out.println("\n6. Игра “Виселица”");
        Scanner scan = new Scanner(System.in);
        String[] words = {"ЛУК", "ТОПОР", "ВЕДРО", "САНИ", "ПЕЧКА"};
        String[] gallows = {"\n\n/", "\n\n/ \\", "\n |\n/ \\", "_\n |\n/ \\",
                "_ _\n |\n/ \\", "_0_\n |\n/ \\", " |\n_О_\n |\n/ \\"};
        StringBuilder userChars = new StringBuilder();
        StringBuilder userWord = new StringBuilder();
        String secretWord = words[(int) (Math.random() * 5)];
        String userChar;
        int life = 7;
        do {
            System.out.println("У Вас " + life + " попыток.");
            if (userChars.isEmpty()) {
                for (int i = 0; i < secretWord.length(); i++) System.out.print("_");
            }
            System.out.println("\nВведите одну букву: ");
            userChar = scan.nextLine().toUpperCase();
            if (userChar.isBlank()) continue;
            if (Character.UnicodeBlock.of(userChar.toCharArray()[0]) != Character.UnicodeBlock.CYRILLIC) {
                System.out.println(userChar + " это не русская буква! Попробуйте снова.");
                continue;
            }
            if (userChars.toString().contains(userChar)) {
                System.out.println("Буква " + userChar + " уже проверялась!");
                continue;
            }
            userChars.append(userChar);
            if (secretWord.contains(userChar)){
                userWord = new StringBuilder();
                for (int i = 0; i < secretWord.length(); i++) {
                    if (userChars.toString().contains(secretWord.substring(i, i + 1))) {
                        userWord.append(secretWord.charAt(i));
                    } else {
                        userWord.append("_");
                    }
                }
                System.out.println(userWord);
                if (life < 7) life++;
            } else {
                System.out.println(gallows[gallows.length - life]);
                life--;
            }
        } while (life > 0 && !secretWord.contentEquals(userWord));
        System.out.println("Вы " + (life > 0 ? "выиграли!" : "проиграли!"));
    }

    public static void typeEffect(String s) throws InterruptedException {
        System.out.println("\n7. Вывод текста с эффектом пишущей машинки");
        if (s == null) {
            System.out.println("null");
            return;
        }
        if (s.isBlank()) {
            System.out.println("пустая строка");
            return;
        }
        String[] words;
        words = s.split(" ");
        String shortWord = "длинное_слово_которое_нужно_заменить";
        String longWord = "";
        for (String word : words) {
            if (Pattern.matches("[a-zA-Zа-яА-Я]+", word)) {
                if (word.length() < shortWord.length()) shortWord = word;
                if (word.length() > longWord.length()) longWord = word;
            }
        }
        int fromUpCase = Arrays.asList(words).indexOf(shortWord);
        int toUpCase = Arrays.asList(words).indexOf(longWord);
        if (fromUpCase > toUpCase) {
            fromUpCase += toUpCase;
            toUpCase = fromUpCase - toUpCase;
            fromUpCase -= toUpCase;
        }
        for (int i = fromUpCase; i <= toUpCase; i++) {
            words[i] = words[i].toUpperCase();
        }
        for (String word : words) {
            for (char letter : word.toCharArray()){
                System.out.print(letter);
                Thread.sleep(100);
            }
            System.out.print(" ");
        }
        System.out.println();
    }
}
