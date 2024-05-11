import java.util.Scanner;

public class GuessNumber {
    private Player player1;
    private Player player2;
    private boolean nextPlayerFlag = false;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    private Player nextPlayer() {
        nextPlayerFlag = !nextPlayerFlag;
        return nextPlayerFlag ? player1 : player2;
    }

    public void play() {
        int secretNum = (int) (Math.random() * 100 + 1);
        var scanner = new Scanner(System.in);
        Player player;
        do {
            player = nextPlayer();
            System.out.printf("Игрок %s введите число от 1 до 100: ", player.getName());
            player.setNumber(scanner.nextInt());
            if (secretNum < player.getNumber()) {
                System.out.printf("Число %d больше того, что загадал компьютер\n", player.getNumber());
            } else if (secretNum > player.getNumber()) {
                System.out.printf("Число %d меньше того, что загадал компьютер\n", player.getNumber());
            }
        } while (secretNum != player.getNumber());
        System.out.printf("Игрок %s победил(а)!\n", player.getName());
    }
}