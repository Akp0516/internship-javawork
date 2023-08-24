
// import java.io.BufferedReader;
// import java.io.FileReader;
import java.io.*;
import java.util.*;
// import java.util.Map;

public class WordCounter {
     public static void main(String[] args) {
          // Step 1: Prompt user for input
          System.out.println("WORD COUNTER\n");
          System.out.println("1. Enter '1' to input text");
          System.out.println("2. Enter '2' to provide a file path");
          System.out.print("Choice: ");

          int choice = getUserChoice();

          String input = "";

          if (choice == 1) {
               // Input text directly
               System.out.print("Enter the text: ");
               input = readInputFromUser();
          } else if (choice == 2) {
               // Provide file path
               System.out.print("Enter the file path: ");
               String filePath = readInputFromUser();
               input = readInputFromFile(filePath);
          } else {
               System.out.println("Invalid choice. Exiting...");
               return;
          }

          // Step 3: Split string into words
          String[] words = input.split("[\\s\\p{Punct}]+");

          // Step 4: Initialize counter variable
          int wordCount = 0;

          // Step 5: Iterate through words and increment counter
          for (String word : words) {
               if (!word.isEmpty()) {
                    wordCount++;
               }
          }

          // Step 6: Display word count
          System.out.println("Total word count: " + wordCount);

          // Additional features (steps 7, 8):
          // You can add code here to ignore common words, calculate unique word count,
          // and display word frequency statistics.

          // For step 10, implementing a GUI is beyond the scope of this text-based
          // example.
     }

     private static int getUserChoice() {
          int choice = 0;
          try {
               choice = Integer.parseInt(readInputFromUser());
          } catch (NumberFormatException e) {
               // Handle invalid input
          }
          return choice;
     }

     private static String readInputFromUser() {
          String input = "";
          try {
               BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
               input = reader.readLine();
          } catch (IOException e) {
               e.printStackTrace();
          }
          return input;
     }

     private static String readInputFromFile(String filePath) {
          StringBuilder sb = new StringBuilder();
          try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
               String line;
               while ((line = reader.readLine()) != null) {
                    sb.append(line).append(" ");
               }
          } catch (IOException e) {
               e.printStackTrace();
          }
          return sb.toString().trim();
     }
}
