package com.startjava.lesson_2_3_4.animal;

public class WolfTest {
    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        wolf.setSex("Male");
        wolf.setName("Kevin");
        wolf.setAge(4);
        wolf.setWeight(28);
        wolf.setColor("Gray");

        System.out.println(wolf.getName());
        System.out.println(wolf.getSex());
        System.out.println(wolf.getAge());
        System.out.println(wolf.getWeight());
        System.out.println(wolf.getColor());

        wolf.howl();
        wolf.hunt();
        wolf.move();
        wolf.run();
        wolf.sit();
    }
}