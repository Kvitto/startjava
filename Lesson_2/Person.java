package ru.topjava.lesson2;

public class Person {
    char sex = 'M';
    String name = "Alex";
    float height = 185f;
    float weight = 87f;
    int age = 28;

    void move() {
        System.out.println("иду");
    }

    void sit() {
        System.out.println("сижу");
    }

    void run() {
        System.out.println("бегу");
    }

    void voice() {
        System.out.println("говорю");
    }

    void learnJava() {
        System.out.println("Учу Java");
    }
}