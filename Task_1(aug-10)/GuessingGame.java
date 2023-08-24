import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
     public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input
          Random random = new Random(); // Create a Random object for generating random numbers

          int lowerBound = 1;
          int upperBound = 50;
          int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound; // Generate a random number
                                                                                       // within the specified range

          int maxAttempts = 10; // Maximum number of guessing attempts allowed

          int rounds = 0; // Initialize rounds counter
          int score = 0; // Initialize score counter

          while (true) { // Loop to allow multiple rounds
               System.out.println("=== Guessing Game ===");
               boolean isCorrect = playGuessingGame(scanner, secretNumber, maxAttempts); // Play a round of the guessing
                                                                                         // game
               if (isCorrect) {
                    score++; // Increment score if the guess was correct
               }
               rounds++; // Increment rounds counter

               System.out.print("Do you want to play again? (yes/no): ");
               String playAgain = scanner.next().toLowerCase(); // Ask the user if they want to play again
               if (!playAgain.equals("yes")) {
                    break; // If user doesn't want to play again, exit the loop
               }

               secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound; // Generate a new secret number
                                                                                        // for the next round
          }

          System.out.println("Game over! You played " + rounds + " rounds and your score is " + score + ".");
          scanner.close(); // Close the scanner to free up resources
     }

     public static boolean playGuessingGame(Scanner scanner, int secretNumber, int maxAttempts) {
          int attempts = 0; // Initialize attempts counter
          while (attempts < maxAttempts) { // Loop for the guessing attempts
               System.out.print("Guess the number: ");
               int guess = scanner.nextInt(); // Read the user's guess

               if (guess < secretNumber) {
                    System.out.println("Low!"); // Provide feedback if the guess is too low
               } else if (guess > secretNumber) {
                    System.out.println("High!"); // Provide feedback if the guess is too high
               } else {
                    System.out.println("Congratulations! You guessed the number " + secretNumber + " correctly in "
                              + (attempts + 1) + " attempts.");
                    return true; // If the guess is correct, provide feedback and return true
               }

               attempts++; // Increment attempts counter
               int remainingAttempts = maxAttempts - attempts;
               System.out.println("You have " + remainingAttempts + " attempts remaining.");
          }

          System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The correct number was "
                    + secretNumber + ".");
          return false; // If all attempts are used, provide feedback and return false
     }
}
