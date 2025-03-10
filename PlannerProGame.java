package Planner;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class PlannerProGame {

    // hash map for usernames and passwords
    private static HashMap<String, String> userInfo = new HashMap<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to Event Planner Pro the game!");
        System.out.println("Are you a returning user? (yes/no)");
       // make all lowercase for easier usability and less errors
        String intro = scan.nextLine().trim().toLowerCase();

        if (intro.equals("yes")) {
            login(scan);
        } else if (intro.equals("no")) {
            register(scan);
        } else {
            System.out.println("ERROR: Invalid input. Please restart.");
            scan.close();
            return;
        }

        // Game INtro
        System.out.println("\nWelcome to your event planning adventure!");
        System.out.print("What is your name? ");
        String playerName = scan.nextLine();
        System.out.println("Welcome, " + playerName + "! Let's begin your event planning journey.\n");
        System.out.println("You are tasked with planning events for your local neighborhood!\n");
        System.out.println("Lets start easy," + playerName + ". First you will begin by planning a baby shower.\n");
        System.out.println("As you go along and complete challenges, you will earn 'Planning points', earn enough and you will become the ultimate planner pro!\n");

        //  planning points earned
        int planPoints = 0;
        //minigames 
        planPoints += RockPaperScissors(scan);
        planPoints += UnscrambleBabyName(scan);
        planPoints += DateGuesser(scan);

        System.out.println("\n" + playerName + ", great job so far! You have earned a total of " + planPoints + " planning points! Lets move on to level 2...");
        scan.close();}

    // User Login method 
    private static void login(Scanner scan) {
        System.out.println("\nLogin to Your Account");
        System.out.print("Enter your username: ");
        String username = scan.nextLine();

        if (userInfo.containsKey(username)) { // see if user name exists
            System.out.print("Enter your password: ");
            String password = scan.nextLine();

            if (userInfo.get(username).equals(password)) {
                System.out.println("Login successful! Let's start your event planning journey!\n");
            } else {
                System.out.println("Incorrect password. Please restart and try again.");
                System.exit(0);
            }}
        	else {
            System.out.println("Username not found. Try again or create a new account.");
            System.exit(0);}}

    private static void register(Scanner scan) {
        System.out.println("\nCreate a New Account!");
        while (true) {
            System.out.print("Create a username: ");
            String username = scan.nextLine();

            if (userInfo.containsKey(username)) {
                System.out.println("Username already exists. Try a different one.");
                continue;
            }

            System.out.print("Create a password: ");
            String password = scan.nextLine();

            userInfo.put(username, password);
            System.out.println("Account created successfully!");

            System.out.print("Would you like to add another account? (yes/no): ");
            String response = scan.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) {
                break;
            }
        }
        System.out.println("\nYou're all set! Now its time to begin your life as an event planner!");}

    // Mini Game #1 (rock paper scissors) 
    public static int RockPaperScissors(Scanner scanner) {
    	// okay the next line i tried to somehow tie in a baby shower and rock paper scissors... but its kinda rough LOL
        System.out.println("Your first task is to help plan a baby shower! Lets play rock, paper, scissors to warm you up! It will help you earn some planning points.");
        System.out.println("here we go!");
        int playerWins = 0;
        int computerWins = 0;
        int rounds = 5; // i set best of 5 rounds, but we can always make more or less

        System.out.println("You'll play " + rounds + " rounds.");

        for (int i = 1; i <= rounds; i++) {
            System.out.println("\nRound " + i + " of " + rounds);
            String result = playRound(scanner);
            if (result.equals("win")) {
                playerWins++;
            } else if (result.equals("lose")) {
                computerWins++;}}

        // winner results!
        System.out.println("\nRock-Paper-Scissors Game Results:");
        System.out.println("Player Wins: " + playerWins);
        System.out.println("Computer Wins: " + computerWins);

        // i had it award points based on each round... but we can change this
        if (playerWins > computerWins) {
            System.out.println("Congratulations! You won the Rock-Paper-Scissors game!");
            return 10; // award 10 planning points for a win
        } else if (computerWins > playerWins) {
            System.out.println("The computer wins this round.");
            return 5; // award 5 planning points for trying
        } else {
            System.out.println("It's a tie!");
            return 7; // award 7 planning points for a tie
        }}

    private static String playRound(Scanner scanner) {
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
            return "lose";}}

    private static String getPlayerMove(Scanner scanner) {
        while (true) {
            System.out.print("Make a move! Enter one of the following (rock/paper/scissors): ");
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

    //mini game 2: unscramble the baby name
    public static int UnscrambleBabyName(Scanner scanner) {
        System.out.println("\n NIce job playing the rock paper scissors game! It seems you're ready to get this baby shower going. \n ");
        System.out.println("\n To start off we need to make a banner for the celebrating couple.. but it seems the computer got the name messed up when it was sent to us. ");
        System.out.println("\n Can you help us figure it out?  ");
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

        boolean guessedFirst = guessName(scanner, "First Name", scrambledFirst, firstName);
        boolean guessedMiddle = guessedFirst && guessName(scanner, "Middle Name", scrambledMiddle, middleName);
        boolean guessedLast = guessedMiddle && guessName(scanner, "Last Name", scrambledLast, lastName);

        if (guessedLast) {
            System.out.println("Congratulations! You unscrambled the full name: " 
                                + firstName + " " + middleName + " " + lastName);
            return 15; // planing points
        } else {
            System.out.println("Game over! The correct full name was: " 
                                + firstName + " " + middleName + " " + lastName);
            return 5;  }}

    // defining scramble
    public static String scramble(String name) {
        // converting the string to a list of characters
        Character[] letters = new Character[name.length()];
        for (int i = 0; i < name.length(); i++) {
            letters[i] = name.charAt(i);}
        List<Character> lettersList = Arrays.asList(letters);
        Collections.shuffle(lettersList);

        StringBuilder scrambled = new StringBuilder();
        for (char letter : lettersList) {
            scrambled.append(letter);}
        return scrambled.toString();}

    // user now guesses using the scrambled name
    public static boolean guessName(Scanner scanner, String nameType, String scrambled, String correctName) {
        int attempts = 3;
        System.out.println(nameType + " to unscramble: " + scrambled);

        while (attempts > 0) {
            System.out.print("Your guess: ");
            String userGuess = scanner.nextLine().trim();
            if (userGuess.equalsIgnoreCase(correctName)) {
                System.out.println("Correct! The " + nameType.toLowerCase() + " was: " + correctName + "\n");
                return true;
            } else {
                attempts--;
                System.out.println("Wrong! attempts left: " + attempts);
            }
        }
        return false; 
        }

    //minigame 3: baby due date guess
    public static int DateGuesser(Scanner scanner) {
        System.out.println("\n Nice work with getting the baby name all squared away! ");
        System.out.println("\n Last but not least lets figure out the babys due date...");
        Random rand = new Random();

        // randomize due date .. month then day
        int correctMonth = 1 + rand.nextInt(12);  
        int correctDay = 1 + rand.nextInt(31);

        int totalGuesses = 10;
        int remainingGuess = totalGuesses;
        int userGuess;

        System.out.println("A baby is due on a mystery date...");
        System.out.println("Try to guess the due date (MM/DD). You have " + totalGuesses + " attempts.");

        // month guess
        System.out.println("\nFirst, guess the month (1-12):");
        while (remainingGuess > 0) {
            System.out.print("Enter your guess for the month: ");
            if (scanner.hasNextInt()) {
                userGuess = scanner.nextInt();
                scanner.nextLine(); 
                } else {
                System.out.println("Invalid input. Please enter a number between 1 and 12.");
                scanner.nextLine(); 
                continue;}
            remainingGuess--;

            if (userGuess == correctMonth) {
                System.out.println("Correct! Now guess the day.");
                break;
            } else if (userGuess < correctMonth) {
                System.out.println("The correct month is later.");
            } else {
                System.out.println("The correct month is earlier.");}

            if (remainingGuess == 0) {
                System.out.println("You're out of guesses! The correct date was " + 
                    String.format("%02d", correctMonth) + "/" + String.format("%02d", correctDay));
                return 5; }}

        // guessing the day
        System.out.println("\nNow, guess the day (1-31):");
        while (remainingGuess > 0) {
            System.out.print("Enter your guess for the day: ");
            if (scanner.hasNextInt()) {
                userGuess = scanner.nextInt();
                scanner.nextLine(); // consume the newline
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 31.");
                scanner.nextLine(); // consume the invalid input
                continue;
            }
            remainingGuess--;

            if (userGuess == correctDay) {
                System.out.println("Congratulations! You guessed the correct due date: " +
                    String.format("%02d", correctMonth) + "/" + String.format("%02d", correctDay));
                return 20; // +20 for correct guess
            } else if (userGuess < correctDay) {
                System.out.println("The correct day is later.");
            } else {
                System.out.println("The correct day is earlier.");}

            if (remainingGuess == 0) {
                System.out.println("You're out of guesses! The correct date was " +
                    String.format("%02d", correctMonth) + "/" + String.format("%02d", correctDay));
                return 5; // award 5 points even if user fails... rip
                }}
        return 5;
        }}
