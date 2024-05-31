package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
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
        if (!checkValidString(string)) return;
        printSlowly(prepareString(string));
    }

    private static String[] prepareString(String string) {
        String[] words;
        words = string.split(" ");
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

    private static boolean checkValidString(String string) {
        if (string == null) {
            System.out.println("\nnull");
            return false;
        }
        if (string.isBlank()) {
            System.out.println("\nпустая строка");
            return false;
        }
        return true;
    }
}
