package com.startjava.lesson_2_3_4.array;

public class TypewriterEffect {
    public static void main(String[] args) throws InterruptedException {
        showTypewriterEffect("Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "- James Gosling");
        showTypewriterEffect("Чтобы написать чистый код, мы сначала пишем грязный код, " +
                "затем рефакторим его.\n- Robert Martin");
        showTypewriterEffect(null);
        showTypewriterEffect("");
    }

    public static void showTypewriterEffect(String inputString) throws InterruptedException {
        if (!isValid(inputString)) return;
        printSlowly(prepareString(inputString));
    }

    private static boolean isValid(String inputString) {
        if (inputString == null || inputString.isBlank()) {
            System.out.println("\nОшибка: текст не задан! Введите текст.");
            return false;
        }
        return true;
    }

    private static String[] prepareString(String string) {
        String[] words = string.split(" ");
        String shortWord = words[0];
        String longWord = words[0];
        int fromUpCase = 0;
        int toUpCase = 0;
        for (int i = 0; i < words.length; i++) {
            String noPunctuation = words[i].replaceAll("\\p{P}", "");
            if (noPunctuation.isEmpty()) continue;
            if (noPunctuation.length() < shortWord.length()) {
                shortWord = noPunctuation;
                fromUpCase = i;
            }
            if (noPunctuation.length() > longWord.length()) {
                longWord = noPunctuation;
                toUpCase = i;
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
