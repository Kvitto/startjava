public class GuessNumber {
    public static void main(String[] args) {
        // загаданное число компьютером
        int numberPc = 35;

        // число игрока
        int numberUser = 50;

        System.out.println("Угадай число\n");
        while (numberUser != numberPc) {
            if (numberUser > numberPc) {
                System.out.printf("Число %3d больше того, что загадал компьютер\n", numberUser);
                numberUser--;
            } else if (numberUser < numberPc) {
                System.out.printf("Число %3d меньше того, что загадал компьютер\n", numberUser);
                numberUser++;
            }
        }
        System.out.println("Вы победили!");
    }
}