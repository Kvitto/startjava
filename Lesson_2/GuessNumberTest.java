import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Введите имя первого игрока: ");
        var player1 = new Player(scanner.nextLine());
        System.out.println("Введите имя второго игрока: ");
        var player2 = new Player(scanner.nextLine());
        var guessNumber = new GuessNumber(player1, player2);
        String choice;
        do {
            guessNumber.play();
            do {
                System.out.println("Хотите продолжить игру? [yes/no]:");
                choice = scanner.next().toLowerCase();
            } while (!"yes".equals(choice) && !"no".equals(choice));
        } while (choice.equals("yes"));
        scanner.close();
    }
}
