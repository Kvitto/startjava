package com.startjava.lesson_2_3_4.array;

import java.util.regex.Pattern;

public class TypewriterEffect {
    public static void main(String[] args) throws InterruptedException {
        typeEffect("Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "- James Gosling");
        typeEffect("Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                "- Robert Martin");
        typeEffect(null);
        typeEffect("");
    }

    public static void typeEffect(String string) throws InterruptedException {
        if (!isValid(string)) return;
        printSlowly(prepareString(string));
    }

    private static boolean isValid(String string) {
        if (string == null || string.isBlank()) {
            System.out.println("\nОшибка: текста для печати отсутствует.");
            return false;
        }
        return true;
    }

    private static String[] prepareString(String string) {
        String[] words = string.split(" ");
        String shortWord = "     ";
        String longWord = "";
        int fromUpCase = 0;
        int toUpCase = 0;
        for (int i = 0; i < words.length; i++) {
            if (Pattern.matches("[a-zA-Zа-яА-Я]+", words[i])) {
                if (words[i].length() < shortWord.length()) {
                    shortWord = words[i];
                    fromUpCase = i;
                }
                if (words[i].length() > longWord.length()) {
                    longWord = words[i];
                    toUpCase = i;
                }
            }
        }
        if (fromUpCase > toUpCase) {
            fromUpCase += toUpCase;
            toUpCase = fromUpCase - toUpCase;
            fromUpCase -= toUpCase;
        }
        for (int i = fromUpCase; i <= toUpCase; i++) {
            words[i] = words[i].toUpperCase();
        }
        return words;
    }

    private static void printSlowly(String[] words) throws InterruptedException {
        System.out.println();
        for (String word : words) {
            for (char letter : word.toCharArray()) {
                System.out.print(letter);
                Thread.sleep(100);
            }
            System.out.print(" ");
        }
        System.out.println();
    }
}
