import java.util.*;
public class NumberGuessingGame {
    public static int generateGuess(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
    public static String getFeedback(Scanner scanner) {
        System.out.print("Enter feedback (high / low / correct): ");
        return scanner.nextLine();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = 1;
        int max = 100;
        boolean guessedCorrectly = false;
        System.out.println("Think of a number between 1 and 100.");
        System.out.println("I will try to guess it!");
        while (!guessedCorrectly) {
            int guess = generateGuess(min, max);
            System.out.println("My guess is: " + guess);
            String feedback = getFeedback(scanner);
            if (feedback.equals("high")) {
                max = guess - 1;
            }
            else if (feedback.equals("low")) {
                min = guess + 1;
            }
            else if (feedback.equals("correct")) {
                System.out.println("I guessed your number correctly ");
                guessedCorrectly = true;
            }
            else {
                System.out.println("Invalid feedback! Please type high, low, or correct.");
            }
        }
    }
}
