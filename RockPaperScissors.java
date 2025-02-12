package Planner;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;
        do {
            int playerWins = 0;
            int computerWins = 0;
            int ties = 0;
            int rounds = 5; // best of 5 rounds
            System.out.println("Welcome, you mist play Rock-Paper-Scissors! You'll play " + rounds + " rounds.");
            for (int i = 1; i <= rounds; i++) {
                System.out.println("\nRound " + i + " of " + rounds);
                String result = playRound(scanner);
                
                // updates the scores
                if (result.equals("win")) {
                    playerWins++;
                } else if (result.equals("lose")) {
                    computerWins++;
                } else {
                    ties++;
                }}

            // final results
            System.out.println("\nGame Over! Here are the results:");
            System.out.println("Player Wins: " + playerWins);
            System.out.println("Computer Wins: " + computerWins);
            System.out.println("Ties: " + ties);

            if (playerWins > computerWins) {
                System.out.println("Congratulations! You won the game!");
            } else if (computerWins > playerWins) {
                System.out.println("The computer wins this time!");
            } else {
                System.out.println("It's a tie!");
            }

            // asks if user wants to play again; will restart game
            System.out.print("\nDo you want to play again? (yes/no): ");
            playAgain = scanner.nextLine().trim().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("\nThanks for playing! Goodbye.");
        scanner.close();
    }

    static String playRound(Scanner scanner) {
        String playerMove = getPlayerMove(scanner);
        String computerMove = getComputerMove();

        System.out.println("Computer chose " + computerMove + "!");

        if (playerMove.equals(computerMove)) {
            System.out.println("It's a draw!");
            return "tie";
        } else if (playerWins(playerMove, computerMove)) {
            System.out.println("Congrats, you won this round!");
            return "win";
        } else {
            System.out.println("The computer has won this round!");
            return "lose";
        }
    }

    
    // accept user input, makes everything lowercase incase the user typed w capitals
    // if invalid input, execute an error!!!
    static String getPlayerMove(Scanner scanner) {
        while (true) {
            System.out.print("Make a move! Enter one of the following (rock/paper/scissors): ");
            String move = scanner.nextLine().trim().toLowerCase();
            if (move.equals("rock") || move.equals("paper") || move.equals("scissors")) {
                return move;
            }
            System.out.println("Invalid input. Please type 'rock', 'paper', or 'scissors'."); }}

   // computer move, randomized
    static String getComputerMove() {
        String[] moves = {"rock", "paper", "scissors"};
        return moves[new Random().nextInt(3)];
    }

    // how to determine winner... classic rock paper scissor rules!
    static boolean playerWins(String playerMove, String computerMove) {
        return (playerMove.equals("rock") && computerMove.equals("scissors")) ||
               (playerMove.equals("paper") && computerMove.equals("rock")) ||
               (playerMove.equals("scissors") && computerMove.equals("paper"));
    }
}

// include additional points to the life bar...











