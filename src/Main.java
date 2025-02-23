import java.util.Random;
import java.util.Scanner;

public class Main {

    private boolean playGame = true;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.runGameLoop();
    }

    private void runGameLoop() {
        while (playGame) {
            playGameRound();
        }
    }

    private void playGameRound() {
        System.out.println("*************************************************\n" +
                "*** Higher! Lower!                            ***\n" +
                "*************************************************");

        int turns = 1;
        int answer = new Random().nextInt(1, 11); // 0 < x < 11

        int guess = getUserGuess();
        while (guess != answer) {
            turns++;
            provideFeedback(guess, answer);
            guess = getUserGuess();
        }

        System.out.println("\nGood job! The correct answer was " + answer + "!");
        System.out.println("You needed " + turns + " turn(s) to guess the correct answer.");

        if (!askPlayAgain()) {
            scanner.close();
            playGame = false;
        }
    }

    private int getUserGuess() {
        System.out.print("Please guess a number: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a valid number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void provideFeedback(int guess, int answer) {
        if (guess > answer) {
            System.out.println("Too high!");
        } else {
            System.out.println("Too low!");
        }
    }

    private boolean askPlayAgain() {
        System.out.print("\nDo you want to play again? (y/n): ");
        String prompt = scanner.nextLine().trim();

        while (!prompt.equalsIgnoreCase("y") && !prompt.equalsIgnoreCase("n")) {
            System.out.print("\nInvalid input. Please enter 'y' or 'n': ");
            prompt = scanner.nextLine().trim();
        }

        return prompt.equalsIgnoreCase("y");
    }
}
