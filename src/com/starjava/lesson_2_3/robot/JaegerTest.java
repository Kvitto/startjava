package com.starjava.lesson_2_3.robot;

public class JaegerTest {
    public static void main(String[] args) {
        var jaeger1 = new Jaeger();
        
        jaeger1.setModelName("Cherno Alpha");
        jaeger1.setMark("Mark-1");
        jaeger1.setOrigin("Russia");
        jaeger1.setHeight(85.34f);
        jaeger1.setWeight(54.487f);
        jaeger1.setStrength(10);
        jaeger1.setArmor(10);

        var jaeger2 = new Jaeger("Gipsy Danger", "Mark-3", "USA", 79.25F, 44.728F, 8, 6);

        jaeger2.move();
        System.out.println(jaeger1.scanKaiju());
        jaeger1.useVortexCannon();
        jaeger1.move();
        jaeger2.useVortexCannon();
        jaeger1.setStrength(jaeger1.getStrength() - 1);
        System.out.println(jaeger1.getStrength());
        jaeger2.setStrength(jaeger2.getStrength() - 1);
        System.out.println(jaeger2.getStrength());
        if (jaeger1.drift()) {
            System.out.println(jaeger1.scanKaiju());
        }
        jaeger2.move();
    }
}
