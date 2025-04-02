package Planner;
import java.util.*;

public class passwordGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        Map<String, List<String>> categories = new HashMap<>();
        categories.put("COLORS", Arrays.asList("WHITE", "BLACK", "GREEN"));
        categories.put("ANIMALS", Arrays.asList("PANDA", "CAMEL", "SLOTH", "ZEBRA", "TIGER"));
        categories.put("SPORTS", Arrays.asList("RUGBY", "DARTS", "BOCCE", "DOGE"));
        
        String chosenCategory = "";
        List<String> passwordList = null;
        
        while (passwordList == null) {
        	System.out.println("Today you are going to put your skills to the test and try to guess a secret password");
            System.out.println("To begin, choose a category: COLORS, ANIMALS, or SPORTS");
            chosenCategory = scanner.next().toUpperCase();
            passwordList = categories.get(chosenCategory);
            if (passwordList == null) {
                System.out.println("Invalid category. Please choose again.");
            }
        }
        
        String password = passwordList.get(rand.nextInt(passwordList.size())); 
        int attempts = 0;
        boolean guessedCorrectly = false;
        Set<Integer> revealedHints = new HashSet<>();

        System.out.println("Time to crack the code, you chose " + chosenCategory + ".");
        System.out.println("Guess the 5-letter password.");

        while (!guessedCorrectly) {  
            System.out.print("Enter your guess: ");
            String guess = scanner.next().toUpperCase(); 

            if (guess.length() != 5) {
                System.out.println("Password must be 5 letters long. Try again.");
                continue;
            }

            attempts++;

            if (guess.equals(password)) {
                System.out.println("Congratulations! You cracked the password in " + attempts + " attempts.");
                guessedCorrectly = true;  
            } else {
                System.out.println("Incorrect. Here's what you got right:");
                boolean anyCorrect = false;

                for (int i = 0; i < 4; i++) {
                    if (guess.charAt(i) == password.charAt(i)) {
                        System.out.println("There is a '" + guess.charAt(i) + "' at position " + (i + 1));
                        anyCorrect = true;
                    }
                }

                if (!anyCorrect) {
                    System.out.println("No letters are in the correct position.");
                }

                if (attempts % 5 == 0) {
                    giveHint(password, revealedHints);
                }
                
                if (attempts == 20) {
                    System.out.println("You have maxed out your attempts. We are going to give you another password, try again!");
                    password = passwordList.get(rand.nextInt(passwordList.size()));
                    attempts = 0;
                    revealedHints.clear();
                }
            }
        }

        scanner.close();
    }

    private static void giveHint(String password, Set<Integer> revealedHints) {
        for (int i = 0; i < 5; i++) {
            if (!revealedHints.contains(i)) {
                System.out.println("Hint... The letter at position " + (i + 1) + " is '" + password.charAt(i) + "'");
                revealedHints.add(i);
                break; 
            }
        }
    }
}
