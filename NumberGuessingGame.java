package javaDSA;
import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
        private static final int MAX_ATTEMPTS = 10;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            int totalScore = 0;
            int roundsPlayed = 0;

            while (true) {
                roundsPlayed++;
                int numberToGuess = random.nextInt(100) + 1; // Generates a number between 1 and 100
                int attemptsTaken = playRound(scanner, numberToGuess);
                totalScore += (MAX_ATTEMPTS - attemptsTaken); // Scoring system: 10 points - attempts used

                System.out.print("Would you like to play again? (yes/no): ");
                String playAgain = scanner.next().trim().toLowerCase();
                if (!playAgain.equals("yes")) {
                    break;
                }
            }

            System.out.printf("Game Over! You played %d rounds and your total score is: %d%n", roundsPlayed, totalScore);
            scanner.close();
        }

        private static int playRound(Scanner scanner, int numberToGuess) {
            int attempts = 0;

            System.out.println("I've picked a number between 1 and 100. You have 10 attempts to guess it!");

            while (attempts < MAX_ATTEMPTS) {
                System.out.printf("Attempt %d: Enter your guess: ", attempts + 1);
                int guess = scanner.nextInt();
                attempts++;

                if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.printf("Congratulations! You've guessed the number %d in %d attempts.%n", numberToGuess, attempts);
                    return attempts; // Return attempts for scoring
                }
            }

            System.out.printf("Sorry, you've used all your attempts. The number was %d.%n", numberToGuess);
            return attempts; // Return attempts for scoring
        }
    }

