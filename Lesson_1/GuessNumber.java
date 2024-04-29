public class GuessNumber {
    public static void main(String[] args) {
        int hiddenNum = 35;
        int playerNum = 50;

        System.out.println("Угадай число\n");
        while (playerNum != hiddenNum) {
            if (playerNum > hiddenNum) {
                System.out.printf("Число %3d больше того, что загадал компьютер\n", playerNum);
                playerNum--;
            } else if (playerNum < hiddenNum) {
                System.out.printf("Число %3d меньше того, что загадал компьютер\n", playerNum);
                playerNum++;
            }
        }
        System.out.println("Вы победили!");
    }
}