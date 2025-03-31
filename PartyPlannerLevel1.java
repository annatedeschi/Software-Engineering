package Planner;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PartyPlannerLevel1 {
	static String username;
	static String password;
	static String Name;
	static String input;
	static int Game;
	static int Level;
	static int planPoints;
	static Scanner scan = new Scanner(System.in);
     
	public static void main(String[] args) throws IOException {
	}
	
	
	
	//minigame #1 - rock paper scissors
	public static void RockPaperScissors() {
			// okay the next line i tried to somehow tie in a baby shower and rock paper scissors...we can workshop the storyline part
			System.out.println("Your first task is to help plan a baby shower! Lets play rock, paper, scissors to who will go first to give the first present!"
			+ " It will help you earn some planning points.");
			System.out.println("here we go!");
			//tallies player and computer wins to see who wins more
			int playerWins = 0;
			int computerWins = 0;
			int rounds = 5; // i set best of 5 rounds, but we can always make more or less
			
			System.out.println("You'll have 5 rounds to try and win");
			
			for (int i = 1; i <= rounds; i++) {
			System.out.println("\nRound " + i + " / " + rounds);
			String result = playRound(scan);
			if (result.equals("win")) {
			playerWins+=1;
			} else if (result.equals("lose")) {
			computerWins+=1;}}
			
			// final results!
			System.out.println("\nHere are the final results!");
			System.out.println("You won " + playerWins + " rounds");
			System.out.println("The computer won " + computerWins + " rounds");
			
			// i had it award points based on each round... but we can change this - maybe based on overall winner or not
			if (playerWins > computerWins) {
			System.out.println("Congratulations! You won!");
			planPoints+=10; // award 10 planning points for a win
			} else if (computerWins > playerWins) {
			System.out.println("The computer wins this round.");
			planPoints+=5; // award 5 planning points for trying
			} else {
			System.out.println("It's a tie!");
			planPoints+= 7; // award 7 planning points for a tie
			}}
			
			//results of the round
			private static String playRound(Scanner scanner) {
			String playerMove = getPlayerMove(scanner);
			String computerMove = getComputerMove();
			
			System.out.println("Computer chose " + computerMove + "!");
			if (playerMove.equals(computerMove)) {
			System.out.println("It's a draw! you'll get 7 planning points for this one");
			return "tie";
			} else if (playerWins(playerMove, computerMove)) {
			System.out.println("Congrats, you won this round!");
			return "win";
			} else {
			System.out.println("The computer has won this round! you have been awarded only 5 planning points");
			return "lose";}}
			
			
			private static String getPlayerMove(Scanner scanner) {
			while (true) {
			System.out.print("Make a move! Enter one of the following - rock/paper/scissors - : ");
			String move = scan.nextLine().trim().toLowerCase();
			if (move.equals("rock") || move.equals("paper") || move.equals("scissors")) {
			return move;}
			System.out.println("Invalid input. Please type 'rock', 'paper', or 'scissors'.");}}
			
			// randomly assgin move from computer
			private static String getComputerMove() {
			String[] moves = {"rock", "paper", "scissors"};
			return moves[new Random().nextInt(3)];}
			
			private static boolean playerWins(String playerMove, String computerMove) {
			return (playerMove.equals("rock") && computerMove.equals("scissors")) ||
			(playerMove.equals("paper") && computerMove.equals("rock")) ||
			(playerMove.equals("scissors") && computerMove.equals("paper"));}



	//mini game #2 - unscramble the baby name
	public static void UnscrambleBabyName() {
			System.out.println("\n Nice job playing the rock paper scissors game! It seems you're ready to get this baby shower going. \n ");
			System.out.println("\n To start off we need to make a banner for the celebrating couple.. but it seems the computer got the name messed up when it was sent to us. ");
			System.out.println("\n Can you help us figure it out? ");
			Random random = new Random();
			
			// Lists of names (we can add more.. i was thinking gender neutral to make it easier?)
			String[] babyFirstNames = {"Erika", "Robin", "Kathryn", "Julia", "Justin", "Ollie", "Dylan", "Emerson"};
			String[] babyMiddleNames = {"Elizabeth", "Katherine", "Juliette", "Rosemary", "James", "Harvey", "Allie"};
			String[] babyLastNames = {"Douglas", "Jones", "Smith", "Harter", "Parker", "Wynn"};
			
			// program selects rando names
			String firstName = babyFirstNames[random.nextInt(babyFirstNames.length)];
			String middleName = babyMiddleNames[random.nextInt(babyMiddleNames.length)];
			String lastName = babyLastNames[random.nextInt(babyLastNames.length)];
			
			// prog scrambles the names
			String scrambledFirst = scramble(firstName);
			String scrambledMiddle = scramble(middleName);
			String scrambledLast = scramble(lastName);
			
			System.out.println("It's time to guess the baby's name!");
			System.out.println("You will need to unscramble a first, middle, and last name.");
			System.out.println("You have 3 attempts for each name. Good luck!");
			
			boolean guessedFirst = guessName( "First Name", scrambledFirst, firstName);
			boolean guessedMiddle = guessedFirst && guessName("Middle Name", scrambledMiddle, middleName);
			boolean guessedLast = guessedMiddle && guessName("Last Name", scrambledLast, lastName);
			
			if (guessedLast) {
			System.out.println("Congratulations! You unscrambled the full name: "
			+ firstName + " " + middleName + " " + lastName);
			planPoints+= 15; // planing points
			} else {
			System.out.println("Game over! The correct full name was: "
			+ firstName + " " + middleName + " " + lastName);
			planPoints+= 5; }}
			
			// scramble method
			public static String scramble(String name) {
			// converting the string to a list of characters
			Character[] letters = new Character[name.length()];
			for (int i = 0; i < name.length(); i++) {
			letters[i] = name.charAt(i);}
			List<Character> lettersList = Arrays.asList(letters);
			//mix around
			Collections.shuffle(lettersList);
			StringBuilder scrambled = new StringBuilder();
			for (char letter : lettersList) {
			scrambled.append(letter);}
			return scrambled.toString();}



	// user now guesses using the scrambled name
	public static boolean guessName( String nameType, String scrambled, String correctName) {
		int attempts = 3;
		System.out.println(nameType + " to unscramble: " + scrambled);
		
		while (attempts > 0) {
		System.out.print("Your guessed: ");
		String userGuess = scan.nextLine().trim();
		if (userGuess.equalsIgnoreCase(correctName)) {
		System.out.println("You got it! The " + nameType.toLowerCase() + " was: " + correctName + "\n");
		return true;
		} else {
		attempts--;
		System.out.println("Wrong! attempts left: " + attempts);
		}} return false;}




	//minigame #3 - baby due date guess
	public static void DateGuesser(){
			System.out.println("\n Nice work with getting the baby name all squared away! ");
			System.out.println("\n Seems like thats not the only issue that had come thru... we still need to figure out the babys due date...");
			Random rand = new Random();
			
			// randomize due date .. month then day
			int correctMonth = 1 + rand.nextInt(12);
			int correctDay = 1 + rand.nextInt(31);
			
			int totalGuesses = 10;
			int remainingMonthGuess = totalGuesses;
			int userGuess;
			
			System.out.println("A baby is due on a mystery date.");
			System.out.println("Try to guess the due date (month/day). You'll have 15 attempts.");
			
			// month guess
			System.out.println("\nFirst, guess the month (1-12). Press enter to guess:");
			while (remainingMonthGuess > 0) {
			scan.nextLine();
			System.out.print("Enter your guess for the month. Press enter to guess: ");
			if (scan.hasNextInt()) {
			userGuess = scan.nextInt();
			scan.nextLine();
			} else {
			System.out.println("Invalid. Please make sure to enter a number between 1 and 12. Press enter to guess");
			scan.nextLine();
			continue;}
			remainingMonthGuess--;
			
			if (userGuess == correctMonth) {
			System.out.println("Correct! Now guess the day. Press enter to guess");
			break;
			} else if (userGuess < correctMonth) {
			System.out.println("The correct month is later. Press enter to try again");
			} else if(userGuess > correctMonth) {
			System.out.println("The correct month is earlier. Press enter to try again");}
			else if(userGuess >= 13) {
			System.out.println("Invalid input. Press enter to guess");}
			else if (userGuess <=0) {
			System.out.println("Invalid input. Press enter to guess");}
			
			if (remainingMonthGuess == 0) {
			System.out.println("You're out of guesses! The correct date was " +
			correctMonth + "/" + correctDay);
			planPoints+= 5; }}
			//guessing the day
			int remainingDayGuess = totalGuesses;
			System.out.println("\nNow, guess the day (1-31). Press enter to guess:");
			while (remainingDayGuess > 0) {
			scan.nextLine();
			System.out.print("Enter your guess for the day. Press enter to guess: ");
			if (scan.hasNextInt()) {
			userGuess = scan.nextInt();
			scan.nextLine();
			} else {
			System.out.println("Invalid input. Please enter a number between 1 and 31. Press enter to guess");
			scan.nextLine();
			continue;}
			remainingDayGuess-=1;
			if (userGuess == correctDay) {
			System.out.println("Congratulations! You guessed the correct due date: " +
			correctMonth + "/" + correctDay);
			planPoints+= 20; // +20 plan pts
			break;
			} else if (userGuess < correctDay) {
			System.out.println("The correct day is later. Press enter to try again");
			} else if (userGuess > correctDay){
			System.out.println("The correct day is earlier. Press enter to try again");}
			else if (userGuess >=32) {
			System.out.println("Invalid input. Press enter to guess");}
			else if (userGuess <= 0) {
			System.out.println("Invalid input. Press enter to guess");}
			if (remainingDayGuess == 0) {
			System.out.println("You're out of guesses! The correct date was " +
			correctMonth + "/" + correctDay);
			System.out.println("You have earned 5 planning points");
			planPoints+= 5; // award 5 points even if user fails... rip
			}}
			planPoints+= 5; }


}
