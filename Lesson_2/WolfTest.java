public class WolfTest {
    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        wolf.sex = "Male";
        wolf.name = "Kevin";
        wolf.age = 4;
        wolf.weight = 28;
        wolf.color = "Gray";

        System.out.println(wolf.name);
        System.out.println(wolf.sex);
        System.out.println(wolf.age);
        System.out.println(wolf.weight);
        System.out.println(wolf.color);

        wolf.howl();
        wolf.hunt();
        wolf.move();
        wolf.run();
        wolf.sit();
    }
}