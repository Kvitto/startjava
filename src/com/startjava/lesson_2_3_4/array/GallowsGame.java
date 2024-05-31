package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Scanner;

public class GallowsGame {
    private static final char[] userChars = new char[33];
    private static final String[] dictionary = {"ЛУК", "ТОПОР", "ВЕДРО", "САНИ", "ПЕЧКА"};
    private static final String[] gallows = new String[]{" |\n_О_\n |\n/ \\", "_0_\n |\n/ \\", "_ _\n |\n/ \\", "_\n |\n/ \\", "\n |\n/ \\", "\n\n/ \\", "\n\n/"};
    private static StringBuilder userWord;
    private static String secretWord;
    private static char userChar;
    private static int life;

    public static void main(String[] args) {
        GallowsGame.play();
    }

    public static void play() {
        Scanner scan = new Scanner(System.in);
        secretWord = dictionary[(int) (Math.random() * dictionary.length)];
        userWord = new StringBuilder("_".repeat(secretWord.length()));
        life = 7;
        System.out.println("\nИгра - ВИСИЛИЦА\n");
        do {
            System.out.println(userWord);
            inputChar(scan);
            if (!checkChar()) showGallows();
        } while (life > 0 && !secretWord.contentEquals(userWord));
        System.out.println(secretWord);
        System.out.println("Вы " + (life > 0 ? "выиграли!" : secretWord + "проиграли!"));
        scan.close();
    }

    private static void inputChar(Scanner scan) {
        while (true) {
            System.out.println("\nВведите одну букву: ");
            userChar = scan.next().toUpperCase().charAt(0);
            if (Character.UnicodeBlock.of(userChar) != Character.UnicodeBlock.CYRILLIC) {
                System.out.println(userChar + " это не русская буква! Попробуйте снова.");
                continue;
            }
            boolean isContain = false;
            for (char sign : userChars)
                if (sign == userChar) {
                    isContain = true;
                    break;
                }
            if (isContain) {
                System.out.println("Буква " + userChar + " уже проверялась!");
                continue;
            }
            for (int i = 0; i < userChars.length; i++) {
                if (userChars[i] == '\u0000') {
                    userChars[i] = userChar;
                    return;
                }
            }
            break;
        }
    }

    private static boolean checkChar() {
        if (secretWord.contains(String.valueOf(userChar))){
            userWord = new StringBuilder();
            for (int i = 0; i < secretWord.length(); i++) {
                if (Arrays.toString(userChars).contains(secretWord.substring(i, i + 1))) {
                    userWord.append(secretWord.charAt(i));
                } else {
                    userWord.append("_");
                }
            }
            if (life < 7) life++;
            return true;
        } else {
            life--;
            return false;
        }
    }

    private static void showGallows() {
        System.out.println(gallows[life]);
    }
}
