import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int totalScore = 0;
        int roundsPlayed = 0;

        System.out.println("==========================================");
        System.out.println("       WELCOME TO NUMBER GUESSING GAME    ");
        System.out.println("==========================================");
        System.out.println("Guess the number between " + minRange + " and " + maxRange);
        System.out.println("You have " + maxAttempts + " attempts per round.");
        System.out.println("==========================================");

        boolean playAgain = true;

        while (playAgain) {
            int secretNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attemptsLeft = maxAttempts;
            boolean guessedCorrectly = false;

            roundsPlayed++;
            System.out.println("\n--- Round " + roundsPlayed + " ---");
            System.out.println("A new number has been selected. Start guessing!");

            while (attemptsLeft > 0) {
                System.out.println("\nAttempts left: " + attemptsLeft);
                System.out.print("Enter your guess: ");

                int userGuess;
                try {
                    userGuess = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid number.");
                    continue;
                }

                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("Out of range! Please guess between " + minRange + " and " + maxRange + ".");
                    continue;
                }

                if (userGuess == secretNumber) {
                    guessedCorrectly = true;
                    int pointsEarned = attemptsLeft * 10;
                    totalScore += pointsEarned;
                    System.out.println("\n*** Correct! The number was " + secretNumber + " ***");
                    System.out.println("You earned " + pointsEarned + " points!");
                    System.out.println("Total Score: " + totalScore);
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too Low! Try a higher number.");
                } else {
                    System.out.println("Too High! Try a lower number.");
                }

                attemptsLeft--;
            }

            if (!guessedCorrectly) {
                System.out.println("\nGame Over! You ran out of attempts.");
                System.out.println("The correct number was: " + secretNumber);
                System.out.println("Total Score: " + totalScore);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes") && !response.equals("y")) {
                playAgain = false;
            }
        }

        System.out.println("\n==========================================");
        System.out.println("          GAME OVER - FINAL RESULTS       ");
        System.out.println("==========================================");
        System.out.println("Rounds Played : " + roundsPlayed);
        System.out.println("Final Score   : " + totalScore);
        System.out.println("Thank you for playing! Goodbye.");
        System.out.println("==========================================");

        scanner.close();
    }
}
