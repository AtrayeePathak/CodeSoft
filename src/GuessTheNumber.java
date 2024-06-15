import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a number between 1 and 100");
            int guess = scanner.nextInt();

            if (number == guess) {
                System.out.println("You win!!");
                break;
            } else if (number > guess) {
                System.out.println("Number is low");
            } else {
                System.out.println("Number is high");
            }
        }

        scanner.close();
    }
}
