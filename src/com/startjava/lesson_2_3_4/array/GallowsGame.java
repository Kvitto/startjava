package com.startjava.lesson_2_3_4.array;

import java.util.Scanner;

public class GallowsGame {
    private static String[] dictionary = {"ЛУК", "ТОПОР", "ВЕДРО", "САНИ", "ПЕЧКА"};
    private static String[] gallows = {
            "_______",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"
    };
    private static int attempts = gallows.length;

    public static void main(String[] args) {
        play();
    }

    public static void play() {
        String secretWord = dictionary[(int) (Math.random() * dictionary.length)];
        StringBuilder mask = new StringBuilder("_".repeat(secretWord.length()));
        StringBuilder letters = new StringBuilder();
        Scanner scan = new Scanner(System.in);
        System.out.println("\nИгра - ВИСЕЛИЦА\n");
        do {
            System.out.println(mask);
            char letter = inputLetter(scan, letters);
            if (secretWord.indexOf(letter) >= 0) {
                if (attempts < gallows.length) attempts++;
                addToMask(mask, secretWord, letter);
            } else {
                attempts--;
                letters.append(letter);
                showGallows();
            }
            System.out.println("Текущее кол-во попыток: " + attempts);
            System.out.println("Все ошибочные буквы: " + letters);
        } while (attempts > 0 && !secretWord.contentEquals(mask));
        System.out.println(secretWord);
        System.out.println("Вы " + (attempts > 0 ? "выиграли!" : "проиграли!"));
        scan.close();
    }

    private static char inputLetter(Scanner scan, StringBuilder letters) {
        while (true) {
            System.out.println("\nВведите одну букву: ");
            char letter = scan.next().toUpperCase().charAt(0);
            if ((!String.valueOf(letter).matches("[а-яА-Я]"))) {
                System.out.println(letter + " это не русская буква! Попробуйте снова.");
                continue;
            }
            if (letters.toString().indexOf(letter) >= 0) {
                System.out.println("Вы уже вводили букву " + letter + ". Попробуйте еще раз.");
                continue;
            }
            return letter;
        }
    }

    private static void addToMask(StringBuilder mask, String secretWord, char letter) {
        for (int i = 0; i < secretWord.length(); i++) {
            if (mask.charAt(i) != '_') continue;
            if (secretWord.charAt(i) == letter) mask.setCharAt(i, letter);
        }
    }

    private static void showGallows() {
        for (int i = 0; i < gallows.length - attempts; i++) {
            System.out.println(gallows[i]);
        }
    }
}
