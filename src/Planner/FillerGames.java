package Planner;
import java.io.IOException;
import java.util.*;

public class FillerGames {
   
    	static void passwordGame() throws IOException {
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

            if (guess.equals(password) && PartyPlannerHandle.Progress == 1) {
                System.out.println("Congratulations! You cracked the password in " + attempts + " attempts.");
                PartyPlannerHandle.planPoints = 60;
                System.out.print( PartyPlannerHandle.planPoints);
                guessedCorrectly = true;  
                PartyPlannerHandle.filler();
            } else if(guess.equals(password) && PartyPlannerHandle.Progress == 2) {
            	System.out.println("Congratulations! You cracked the password in " + attempts + " attempts.");
                PartyPlannerHandle.planPoints = 120;
                System.out.print( PartyPlannerHandle.planPoints);
                guessedCorrectly = true;  
                PartyPlannerHandle.filler();

            }
            		else {
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
    
    
    static void ticTacToeGame() throws IOException {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        char[] board = {'1','2','3','4','5','6','7','8','9'};
        int moves = 0;

        System.out.println("\nWelcome to Tic Tac Toe! Try your luck to move onto the next round!");
        printSimpleBoard(board);

        while (true) {
            // Player move
            System.out.print("Your move! Pick a spot (1-9): ");
            int playerSpot;
            try {
                playerSpot = Integer.parseInt(scan.nextLine()) - 1;
            } catch (Exception e) {
                System.out.println("Please enter a number from 1 to 9.");
                continue;
            }

            if (playerSpot < 0 || playerSpot > 8 || board[playerSpot] == 'x' || board[playerSpot] == 'o') {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            board[playerSpot] = 'x';
            moves++;
            printSimpleBoard(board);

            if (checkSimpleWin(board, 'x')) {
                System.out.println("You win!");

                if (PartyPlannerHandle.Progress == 1) {
                    PartyPlannerHandle.planPoints = 60;
                } else if (PartyPlannerHandle.Progress == 2) {
                    PartyPlannerHandle.planPoints = 120;
                }

                System.out.println("Points: " + PartyPlannerHandle.planPoints);
                PartyPlannerHandle.filler();
                break;
            }

            if (moves == 9) {
                System.out.println("It's a tie!");
                PartyPlannerHandle.filler();
                break;
            }

            // Computer move
            System.out.println("Computer's turn...");
            int compSpot;
            while (true) {
                compSpot = rand.nextInt(9);
                if (board[compSpot] != 'x' && board[compSpot] != 'o') {
                    board[compSpot] = 'o';
                    moves++;
                    break;
                }
            }

            printSimpleBoard(board);

            if (checkSimpleWin(board, 'o')) {
                System.out.println("Computer wins!");
                PartyPlannerHandle.filler();
                break;
            }
        }
    }

    private static void printSimpleBoard(char[] board) {
        System.out.println("\n" + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("--+---+--");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("--+---+--");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
    }

    private static boolean checkSimpleWin(char[] board, char player) {
        return (board[0] == player && board[1] == player && board[2] == player) ||
               (board[3] == player && board[4] == player && board[5] == player) ||
               (board[6] == player && board[7] == player && board[8] == player) ||
               (board[0] == player && board[3] == player && board[6] == player) ||
               (board[1] == player && board[4] == player && board[7] == player) ||
               (board[2] == player && board[5] == player && board[8] == player) ||
               (board[0] == player && board[4] == player && board[8] == player) ||
               (board[2] == player && board[4] == player && board[6] == player);
    }
}
    
    
    



 