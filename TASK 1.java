import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    private static final int MAX_ATTEMPTS = 10; 
    private static final int LOWER_BOUND = 1;    
    private static final int UPPER_BOUND = 100;   
    private static int score = 0;                

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain;

        do {
            playRound(scanner);
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next();
        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing! Your final score is: " + score);
    }

    private static void playRound(Scanner scanner) {
        int randomNumber = generateRandomNumber();
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("A random number between " + LOWER_BOUND + " and " + UPPER_BOUND + " has been generated.");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it.");

        while (attempts < MAX_ATTEMPTS && !hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < LOWER_BOUND || userGuess > UPPER_BOUND) {
                System.out.println("Please guess a number within the range " + LOWER_BOUND + " to " + UPPER_BOUND + ".");
            } else if (userGuess == randomNumber) {
                hasGuessedCorrectly = true;
                System.out.println("Congratulations! You've guessed the correct number: " + randomNumber);
                score += (MAX_ATTEMPTS - attempts + 1);
            } else if (userGuess < randomNumber) {
                System.out.println("Your guess is too low. Try again.");
            } else {
                System.out.println("Your guess is too high. Try again.");
            }
        }

        if (!hasGuessedCorrectly) {
            System.out.println("Sorry! You've used all your attempts. The correct number was: " + randomNumber);
        }
    }

    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND; 
    }
}