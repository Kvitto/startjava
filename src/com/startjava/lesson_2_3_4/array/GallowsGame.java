package com.startjava.lesson_2_3_4.array;

import java.util.Scanner;

public class GallowsGame {
    private static char[] letters = new char[33];
    private static String[] dictionary = {"ЛУК", "ТОПОР", "ВЕДРО", "САНИ", "ПЕЧКА"};
    private static String[] gallows = {"_______",
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
        Scanner scan = new Scanner(System.in);
        System.out.println("\nИгра - ВИСЕЛИЦА\n");
        do {
            System.out.println(mask);
            char input = inputChar(scan);
            if (!checkLetters(secretWord, input)) showGallows();
            makeMask(mask, secretWord);
        } while (attempts > 0 && !secretWord.contentEquals(mask));
        System.out.println(secretWord);
        System.out.println("Вы " + (attempts > 0 ? "выиграли!" : "проиграли!"));
        scan.close();
    }

    private static char inputChar(Scanner scan) {
        while (true) {
            System.out.println("\nВведите одну букву: ");
            char input = scan.next().toUpperCase().charAt(0);
            if ((!String.valueOf(input).matches("[а-яА-Я]"))) {
                System.out.println(input + " это не русская буква! Попробуйте снова.");
                continue;
            }
            boolean isContains = false;
            for (char letter : letters)
                if (input == letter) {
                    isContains = true;
                    break;
                }
            if (isContains) {
                System.out.println("Буква " + input + " уже проверялась!");
                continue;
            }
            for (int i = 0; i < letters.length; i++) {
                if (letters[i] == 0) {
                    letters[i] = input;
                    return input;
                }
            }
        }
    }

    private static boolean checkLetters(String secretWord, char input) {
        if (secretWord.contains(Character.toString(input))) {
            if (attempts < gallows.length) attempts++;
            return true;
        }
        attempts--;
        return false;
    }

    private static void makeMask(StringBuilder mask, String secretWord) {
        mask.setLength(0);
        for (char character : secretWord.toCharArray()) {
            boolean isContains = false;
            for (char letter : letters) {
                if (letter == 0) break;
                if (character == letter) {
                    isContains = true;
                    break;
                }
            }
            mask.append(isContains ? character : "_");
        }
    }

    private static void showGallows() {
        for (int i = 0; i < gallows.length - attempts; i++) {
            System.out.println(gallows[i]);
        }
    }
}
