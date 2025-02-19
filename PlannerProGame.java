package Planner;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class PlannerProGame {

    // Hashmap for usernames(keys) and passwords(values)
    private static HashMap<String, String> usersInfo = new HashMap<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Event Planner Pro the game!");
        System.out.println("Are you a returning user? (yes/no)");
        // trim whitespaces and make lowerscases to account for the users input
        String intro = scan.nextLine().trim().toLowerCase();
        if (intro.equals("yes")) {
            login(scan);
        } else if (intro.equals("no")) {
            register(scan);
        } else {
            System.out.println("ERROR: Invalid input. Please restart, adn try again!");
            scan.close();
            return;}

        // Game INtro -- in future: can change this to reading in from TXT file...
        System.out.println("Welcome to your event planning adventure!");
        System.out.println("We need your help to plan a variety of events happening around town.");
        System.out.print("First off, what is your name? ");
        String playerName = scan.nextLine(); //user inputs their name
        System.out.println("Welcome, " + playerName + "! Let's begin your event planning journey.");
        System.out.println("You are tasked with planning events for your local neighborhood!");
        System.out.println("Let's start easy, " + playerName + ". First you will begin by planning a baby shower.");
        System.out.println("As you go along and complete challenges, you will earn 'Planning points'. Earn enough and you will become the ultimate planner pro!");
        
        // planning points earned, gets added to thru the course of the game, user is trying to earn as many as possible
        int planPoints = 0;
        // minigames
        planPoints += RockPaperScissors(scan);
        planPoints += UnscrambleBabyName(scan);
        planPoints += DateGuesser(scan);
        System.out.println(playerName + ", great job so far! You've earned a total of " + planPoints + " planning points! Let's move on to level 2...");
        scan.close();}

    // loggin method 
    private static void login(Scanner scan) {
        System.out.println("Let's log into your account!");
        System.out.print("Enter your username: ");
        String username = scan.nextLine();

        if (usersInfo.containsKey(username)) { // Check if the username exists in hashmap
            System.out.print("Enter your password: ");
            String password = scan.nextLine();
            if (usersInfo.get(username).equals(password)) { //check for pass in the users key / value
                System.out.println("Login successful! Let's get going on your event planning journey!\n");
            } else {
                System.out.println("Incorrect password, restart the game!");
                System.exit(0);}
        } else {
            System.out.println("Username not found... enter your username again or create a new account.");
            System.exit(0);
        }}

    // create new acc method
    private static void register(Scanner scan) {
        System.out.println("Create a New Account!");
        System.out.print("Create a username: ");
        String username = scan.nextLine().trim();
        // sees if username is not already in hash map
        while (usersInfo.containsKey(username)) {
            System.out.println("That username already exists... try using a different one.");
            System.out.print("Create a username: ");
            username = scan.nextLine().trim();}
        
        System.out.print("Create a password: ");
        String password = scan.nextLine().trim();
        usersInfo.put(username, password);
        System.out.println("Account created successfully!");
        System.out.println("You're all set! Now it's time to begin your life as an event planner!");}
    
    
    // minigame #1 - rock paper scissors 
    public static int RockPaperScissors(Scanner scanner) {
    	// okay the next line i tried to somehow tie in a baby shower and rock paper scissors... we can workshop the storyline part
        System.out.println("Your first task is to help plan a baby shower! Lets play rock, paper, scissors to warm you up! "
        					+ "It will help you earn some planning points.");
        System.out.println("here we go!");
        // tallies player and computer wins to see who wins more
        int playerWins = 0;
        int computerWins = 0;
        int rounds = 5; // i set best of 5 rounds, but we can always make more or less
        System.out.println("You'll have 5 rounds to try and win.");

        for (int i = 1; i <= rounds; i+=1) {
            System.out.println("Round " + i + " / " + rounds);
            String result = playRound(scanner);
            if (result.equals("win")) {
                playerWins+=1;
            } else if (result.equals("lose")) {
                computerWins+=1;}}
        // final results
        System.out.println("Here are the final results!");
        System.out.println("You won " + playerWins +" rounds");
        System.out.println("The computer won " + computerWins +" rounds");
        
        
        // i had it award points based on each round... but we can change this - maybe based on overall winner or not
        if (playerWins > computerWins) {
            System.out.println("Congratulations! You won!");
            return 10; // award 10 planning points for a win
        } else if (computerWins > playerWins) {
            System.out.println("The computer wins this round.");
            return 5; // award 5 planning points for trying
        } else {
            System.out.println("It's a tie!");
            return 7; // award 7 planning points for a tie
            }}

    private static String getPlayerMove(Scanner scanner) {
        while (true) {
            System.out.print("Make a move! Enter one of the following  - rock/paper/scissors - : ");
            String move = scanner.nextLine().trim().toLowerCase();
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
    
    // results of the round
    private static String playRound(Scanner scanner) {
        String playerMove = getPlayerMove(scanner);
        String computerMove = getComputerMove();
        System.out.println("Computer chose " + computerMove + "!");
        if (playerMove.equals(computerMove)) {
            System.out.println("It's a draw! you'll get 7 planning points for this one.");
            return "tie";
        } else if (playerWins(playerMove, computerMove)) {
            System.out.println("Congrats, you won this round! you have been awarded 10 planning points. ");
            return "win";
        } else {
            System.out.println("The computer has won this round! you have been awarded only 5 planning points.");
            return "lose";}}

    //mini game #2 - unscramble baby name
    public static int UnscrambleBabyName(Scanner scanner) {
        System.out.println("Good work preparing so far. It seems you're ready to get this baby shower going. ");
        System.out.println("To start off we need to make a banner for the celebrating couple.. but it seems the computer got the name messed up when it was sent to us. ");
        System.out.println(" Can you help us figure it out?  ");
        Random random = new Random();

        // Lists of names (we can add more.. i was thinking gender neutral to make it easier?)
        String[] babyFirstNames = {"Erika", "Robin", "Kathryn", "Julia", "Justin", "Ollie", "Dylan", "Emerson"};
        String[] babyMiddleNames = {"Elizabeth", "Katherine", "Juliette", "Rosemary", "James", "Harvey", "Allie"};
        String[] babyLastNames = {"Douglas", "Jones", "Smith", "Harter", "Parker", "Wynn", "Wooten", "White"};
        // program selects random names
        String firstName = babyFirstNames[random.nextInt(babyFirstNames.length)];
        String middleName = babyMiddleNames[random.nextInt(babyMiddleNames.length)];
        String lastName = babyLastNames[random.nextInt(babyLastNames.length)];
        // program scrambles the names
        String scrambledFirst = scramble(firstName);
        String scrambledMiddle = scramble(middleName);
        String scrambledLast = scramble(lastName);

        System.out.println("It's time to guess the baby's name!");
        System.out.println("You will need to unscramble a first, middle, and last name.");
        System.out.println("You have 3 attempts for each name. Good luck!");
        boolean guessedFirst = guessName(scanner, "First Name", scrambledFirst, firstName);
        boolean guessedMiddle = guessedFirst && guessName(scanner, "Middle Name", scrambledMiddle, middleName);
        boolean guessedLast = guessedMiddle && guessName(scanner, "Last Name", scrambledLast, lastName);
        	if (guessedLast) {
        	System.out.println("Congratulations! You unscrambled the full name: " + firstName + " " + middleName + " " + lastName);
            return 15; // planing points
        	} else {
            System.out.println("Game over! The correct full name was: " + firstName + " " + middleName + " " + lastName);
            return 5;  }}

    // scramble method
    public static String scramble(String name) {
        // converting the string to a list of characters
        Character[] letters = new Character[name.length()];
        for (int i = 0; i < name.length(); i+=1) {
            letters[i] = name.charAt(i);}
        List<Character> lettersList = Arrays.asList(letters);
        // mix around
        Collections.shuffle(lettersList);
        StringBuilder scrambled = new StringBuilder();
        for (char letter: lettersList) {
            scrambled.append(letter);}
        return scrambled.toString();}

    // user guesses using the scrambled name
    public static boolean guessName(Scanner scanner, String nameType, String scrambled, String correctName) { // nametype means the first, middle, or last name
       // 3 tries but we can make it more if needed
    	int attempts = 3;
        System.out.println(nameType + " to unscramble is: " + scrambled);
        while (attempts > 0) {
            System.out.print("You guessed: ");
            String userGuess = scanner.nextLine().trim();
            if (userGuess.equals(correctName)) {
                System.out.println("You got it! The " + nameType.toLowerCase() + " was: " + correctName );
                return true;
            } else {
            	attempts -= 1;
                System.out.println("Wrong! attempts left: " + attempts);
            }}return false; }

    //minigame #3 - baby due date guess
    public static int DateGuesser(Scanner scanner) {
        System.out.println("Nice work with getting the baby name all squared away! ");
        System.out.println("Seems like thats not the only issue that had come thru... we still need to figure out the babys due date...");
        Random rand = new Random();
        // randomize due date .. month then day
        int correctMonth = 1 + rand.nextInt(12);  
        int correctDay = 1 + rand.nextInt(31);
        int totalGuesses = 15;
        int remainingGuess = totalGuesses;
        int userGuess;
        System.out.println("The baby is due on a mystery date.");
        System.out.println("Try to guess the due date (month/day). You'll have 15 attempts.");

        // month guess
        System.out.println("First, guess the month (1-12):");
        while (remainingGuess > 0) {
            System.out.print("Enter your guess for the month: ");
            if (scanner.hasNextInt()) {
             userGuess = scanner.nextInt();
                scanner.nextLine(); 
                } else {
           System.out.println("Invalid. Please make sure to enter a number between 1 and 12.");
                scanner.nextLine(); 
                continue;}
            remainingGuess-=1;
            if (userGuess == correctMonth) {
                System.out.println("Correct! Now guess the day.");
                break;
            } else if (userGuess < correctMonth) { System.out.println("The correct month is later.");} 
            else if (userGuess > correctMonth){ System.out.println("The correct month is earlier.");}
            else if (userGuess >= 13) {
                System.out.println("Invalid input");}
            else if (userGuess <= 0) {
                System.out.println("Invalid input");}
            if (remainingGuess == 0) {
                System.out.println("You're out of guesses! The correct date was " + correctMonth + "/" + correctDay);
                return 5; }}
 
        // guessing the day
        System.out.println("Now, guess the day (1-31):");
        while (remainingGuess > 0) {
            System.out.print("Enter your guess for the day: ");
            if (scanner.hasNextInt()) {
                userGuess = scanner.nextInt();
                scanner.nextLine();  
            } else {
                System.out.println("Invalid. Please make sure to enter a number between 1 and 31.");
                scanner.nextLine(); 
                continue;}
            remainingGuess -= 1;
            if (userGuess == correctDay) {
                System.out.println("Congratulations! You guessed the correct due date: " +correctMonth + "/" + correctDay);
                System.out.println("You have earned 20 planning points");
                return 20; // +20 plan pts
            } else if (userGuess < correctDay) {
                System.out.println("The correct day is later.");
            } else if (userGuess > correctDay){
                System.out.println("The correct day is earlier.");}
            else if (userGuess >= 32) {
                System.out.println("Invalid input");}
            else if (userGuess <= 0) {
                System.out.println("Invalid input");}
            if (remainingGuess == 0) {
                System.out.println("You're out of guesses! The correct date was " +correctMonth + "/" + correctDay);
                System.out.println("You have earned 5 planning points");
                return 5; // award 5 points even if user fails... rip
                }}
        return 5;}
    }




