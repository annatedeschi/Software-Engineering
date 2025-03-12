package Planner;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;





public class PlannerProGame {
	//static variables that will be shared with all instances of the class - rachenza
	static String Name;
	static int planPoints = 0;
	static int Level = 0;
	static int Game = 0;
	static String nameofficial;
	static String username;
	static String password;
	static String input;


	//
	
	
	
	
    //Hashmap for the usernames(keys) and passwords(values)-emily
    private static HashMap<String, String> userInfo = new HashMap<>();
   

    public static void main(String[] args) throws IOException {
    	
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Event Planner Pro the game!");
        System.out.println("Are you a returning user? (yes/no)");
       // trim whitespaces and make lowercases to account for users input 
        String intro = scan.nextLine().trim().toLowerCase();
        if (intro.equals("yes")) {
            login(scan,nameofficial);
        } else if (intro.equals("no")) {
            register(scan,intro);
        } else {
            System.out.println("ERROR: Invalid input. Please restart, and try again!");
            scan.close();
            return;
        }
       
        }
     
    
    
  //login method 
    private static void login(Scanner scan, String nameofficial) throws IOException {
    	
    
         System.out.println("\nLet's log into your account");
         System.out.print("Enter your username: ");
         username = scan.nextLine().trim();
         System.out.print("Enter your password: ");
         password = scan.nextLine().trim();
         
         //check if username exist in hashmap-rachenza
         boolean usernameExist = hashinfofromfile(userInfo);
         
         if (usernameExist) {
        	 //check if password exists in hashmap-rachenza
        	 boolean passwordExists = hashinfofromfile(userInfo);
        	 if (passwordExists) {
        	  System.out.println("Login successful! Let's get going on your event planning journey!\n");
        	 //add username and password to the hashmap-rachenza
        	  userInfo.put(username, password);
        	  //send them back where they left off by calling the method which does so-rachenza
              goingback(username,password,nameofficial);}
              
        	 else {
            	  System.out.println("invalid log in. Please try again");
            	  System.exit(0);}
         }
         
    }
        	
    //create a new acc method
    private static void register(Scanner scan, String intro) throws IOException {
    	
   	
    	System.out.println("\nCreate a New Account!");
    	
    	  while (intro.equals("no")) {
    	            System.out.print("Create a username: ");
    	            username = scan.nextLine().trim();
    	            System.out.println("Is this the username you would like to use for your account: " + username);
    	            input = scan.nextLine().trim();
    	            
    	            if (input.equals("no")) {
    	            	 System.out.println("Please re-enter your desired username: ");
    	    	            username = scan.nextLine().trim();
    	            	 
    	            } else {
    	              
    	            

    	            boolean usernameExist = hashinfofromfile(userInfo);

    	            if (usernameExist) {
    	                System.out.println("Username is already taken. Please restart.");
    	                System.exit(0);
    	            }

    	           
    	 
    	       
    	            System.out.print("Create a password: ");
    	            password = scan.nextLine().trim();
    	            System.out.println("Is this the password you would like to use for your account: " + password);
    	            input = scan.nextLine().trim();

    	            if (input.equals("no")) {
    	            	System.out.println("Please re-enter your desired password: ");
    	    	            password = scan.nextLine().trim();
    	            } else {
    	               
    	        

    	        // Add username and password to the hashmap
    	        userInfo.put(username, password);

    	        // Add username and password to the file
    	        hashtofile(userInfo);

    	        System.out.println("Account created successfully!");
    	        System.out.println("You're all set! Now it's time to begin your life as an event planner!");

    	        // Start the games by calling the method
    	        startgames(username, password, scan);
    	    }
    	  }
    }
    }
            
          		 
          			 
    
    	  
    	  
           
    
    

            
        

        

       
    
    
 //rachenza
//writes username and password to file -rachenza
public static void hashtofile(HashMap<String, String> map ) throws IOException {
	BufferedWriter writer = new BufferedWriter(new FileWriter("Userinfo.txt",true));
	for (String key : map.keySet()) {
		writer.newLine();
		writer.write(key + ":" + map.get(key));
		writer.newLine();
	}
	writer.close();	
}



//rachenza
//read the username and password from the userinfo file-rachenza
public static boolean hashinfofromfile(HashMap<String, String> map) throws IOException{

BufferedReader reader = new BufferedReader(new FileReader("Userinfo.txt"));

String line;//creating a variable named line-rachenza
while ((line = reader.readLine()) != null){
	String[] parts = line.split(":");
	if (parts.length == 2) {
		String usernamefromfile = parts[0].trim();
	
	if(!username.isEmpty() && usernamefromfile.equals(username)){
		username = usernamefromfile;
			return true;
		
	}
	}
}
		
		reader.close();
		return false;


}

//rachenza
//save the users progress once they say yes and add to a progress file
public static void saveprogress(String username, String password, int Game, int Level, int planPoints) throws IOException {
	 Scanner scan0 = new Scanner(System.in);
	 System.out.println("Would you like to save your progress so far and log out ?");
	 String userfeedprogress = scan0.nextLine().trim().toLowerCase();
	 
	 if (userfeedprogress.equals("yes")) {
		 BufferedWriter writer = new BufferedWriter(new FileWriter("progress.txt",true));
		 writer.write(username + ", " + password + ", " + Name + ", " + Level + ", " + Game + ", " + planPoints);
		 writer.newLine();
		 writer.close();
		 System.out.println("all set");
		 System.exit(0);
		 
	 }else {
		   System.out.println("Okay lets keep going");
	 }
}

//rachenza
//sends the user to the correct game once they log back in
public static void handlelevel(int Game,int Level,Scanner scan, String password, String username, String nameofficial, ArrayList<String>namesf) throws IOException {
	System.out.println("Debug: handlelevel called with Game = " + Game + ", Level = " + Level);

	if (Game == 1 && Level == 1) {
		UnscrambleBabyName(scan);
		saveprogress(username,password,Game,Level,planPoints);
		DateGuesser(scan);
		saveprogress(username,password,Game,Level,planPoints);
		Wedding(scan, Name, nameofficial, planPoints,namesf);
		GuestSeatingGame(scan, Name, planPoints );
	    saveprogress(username,password,Game,Level,planPoints);

		
		
		
	}else {
		
	}
	
	if (Game == 2 && Level == 1) {
		DateGuesser(scan);
		saveprogress(username,password,Game,Level,planPoints);
		Wedding(scan,Name,nameofficial, planPoints,namesf);
	    saveprogress(username,password,Game,Level,planPoints);

	}else {
		
	}
	if (Game == 3 && Level == 1) {
		
		 Wedding(scan,Name,nameofficial, planPoints, namesf);
	}else {
		
	}
	if (Game == 1 && Level == 2) {
		saveprogress(username,password,Game,Level,planPoints);
	}else {
		
	}
	if (Game == 2 && Level == 2) {
		//game 2 of level 2
	}else {
		
	}
}


		  
	 
     
    



//rachenza  
//introduction to the overall game 
public static void startgames(String username, String password, Scanner scan) throws IOException {
	
	
	// Game INtro == in future: can change this to reading in from TXT file...
    System.out.println("\nWelcome to your event planning adventure!");
    System.out.println("We need help to plan a variety of events happening around town.");
    System.out.print("First off, What is your name?");
    String playerName = scan.nextLine(); //user inputs their name
    Name = playerName;
    System.out.println("Welcome, " + Name + "! Let's begin your event planning journey.\n");
    System.out.println("You are tasked with planning events for your local neighborhood");
    System.out.println("Let's start easy, " + Name + ". First you will begin by planning a baby shower.");
    System.out.println("As you go along and complete challenges, you will earn 'Planning points'. Earn enough and you will become the ultimate planner pro!\n");
    
    ArrayList<String> namesf = new ArrayList<String>();

    File O = new File("Femalenames.txt");

    Scanner read = new Scanner(O);

    while (read.hasNextLine()) {
        String data1 = read.nextLine();
        namesf.add(data1);
    }
    //create a variable to hold the randomly picked female names
    int random = (int)(Math.random() * namesf.size()); // range of random numbers from 0 to the size of my array
    nameofficial = namesf.get(random);
    Babyshower(Level, Name, nameofficial);
    
   
    //minigames 
    RockPaperScissors(scan);
    Game +=1;
    Level +=1;
    saveprogress(username,password,Game,Level,planPoints);
    UnscrambleBabyName(scan);
    Game +=1;
    saveprogress(username,password,Game,Level,planPoints);  
    DateGuesser(scan);
    Game +=1;
    saveprogress(username,password,Game,Level,planPoints);
    Level +=1;
    System.out.println("\n" + Name + ", great job so far! You have earned a total of " + planPoints + " planning points! Lets move on to level 2...");
    
    //rachenza
    //calling intro to lvl 2
    Wedding(scan,Name,nameofficial, planPoints,namesf);
    }

  //rachenza  
//intro to level 1 
public static void Babyshower(int Level, String Name, String nameofficial) {
	Level += 1;
	System.out.println("You are tasked with planning events for your local neighborhood!\n");
	System.out.println("Lets start easy," + Name + ". First you will begin by planning a baby shower for " + nameofficial + "\n.");
}



//minigame #1 - rock paper scissors
public static void RockPaperScissors(Scanner scanner) {
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
        String result = playRound(scanner);
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






//mini game #2 - unscramble the baby name
public static void UnscrambleBabyName(Scanner scanner) {
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
        planPoints+= 15; // planing points
    } else {
        System.out.println("Game over! The correct full name was: " 
                            + firstName + " " + middleName + " " + lastName);
        planPoints+= 5;  }}

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
public static boolean guessName(Scanner scanner, String nameType, String scrambled, String correctName) {
    int attempts = 3;
    System.out.println(nameType + " to unscramble: " + scrambled);

    while (attempts > 0) {
        scanner = new Scanner(System.in);//rachenza create a scanner for emily
        System.out.print("Your guessed: ");
        String userGuess = scanner.nextLine().trim();
        if (userGuess.equalsIgnoreCase(correctName)) {
            System.out.println("You got it! The " + nameType.toLowerCase() + " was: " + correctName + "\n");
            return true;
        } else {
            attempts--;
            System.out.println("Wrong! attempts left: " + attempts);
        }} return false;}




//minigame #3 - baby due date guess
public static void DateGuesser(Scanner scanner){
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
    System.out.println("\nFirst, guess the month (1-12):");
    while (remainingMonthGuess > 0) {
    	scanner = new Scanner(System.in);
        System.out.print("Enter your guess for the month: ");
        if (scanner.hasNextInt()) {
            userGuess = scanner.nextInt();
            scanner.nextLine(); 
            } else {
            System.out.println("Invalid. Please make sure to enter a number between 1 and 12.");
            scanner.nextLine(); 
            continue;}
        remainingMonthGuess--;

        if (userGuess == correctMonth) {
            System.out.println("Correct! Now guess the day.");
            break;
        } else if (userGuess < correctMonth) {
            System.out.println("The correct month is later.");
        } else if(userGuess > correctMonth) {
            System.out.println("The correct month is earlier.");}
        else if(userGuess >= 13) {
        	 System.out.println("Invalid input");}
        else if (userGuess <=0) {
        	System.out.println("Invalid input");}
        

        if (remainingMonthGuess == 0) {
            System.out.println("You're out of guesses! The correct date was " + 
         correctMonth + "/" + correctDay);
            planPoints+= 5; }}
    
    //guessing the day
  int remainingDayGuess = totalGuesses;
  System.out.println("\nNow, guess the day (1-31):");
  while (remainingDayGuess > 0) {
    	scanner = new Scanner(System.in);
        System.out.print("Enter your guess for the day: ");
        if (scanner.hasNextInt()) {
            userGuess = scanner.nextInt();
            scanner.nextLine(); 
        } else {
            System.out.println("Invalid input. Please enter a number between 1 and 31.");
            scanner.nextLine(); 
            continue;}
        remainingDayGuess-=1;
         if (userGuess == correctDay) {
            System.out.println("Congratulations! You guessed the correct due date: " +
             correctMonth + "/" + correctDay);
            planPoints+= 20; // +20 plan pts
            break;
            
        } else if (userGuess < correctDay) {
            System.out.println("The correct day is later.");
        } else if (userGuess > correctDay){
            System.out.println("The correct day is earlier.");}
         else if (userGuess >=32) {
        	 System.out.println("Invalid input");}
         else if (userGuess <= 0) {
        	 System.out.println("Invalid input");}
        if (remainingDayGuess == 0) {
            System.out.println("You're out of guesses! The correct date was " +
               correctMonth + "/" + correctDay);
            System.out.println("You have earned 5 planning points");
            planPoints+= 5; // award 5 points even if user fails... rip
            }}
planPoints+= 5; }

    


//rachenza
//Lvl 2 Intro 
public static void Wedding(Scanner scan, String Name, String nameofficial,int planPoints,ArrayList<String> namesf) throws FileNotFoundException {
	 int random = (int)(Math.random() * namesf.size()); // range of random numbers from 0 to the size of my array
	    nameofficial = namesf.get(random);
    	Game = 0;
       

        System.out.println("\nCongrats on making it to Level 2 " + Name + "\nIn this level you will be planning a wedding");

        System.out.println("\n" + nameofficial + " wants a fairytale wedding she's been planning for this day since she was 10." +
                "\nHere is a dialogue about some of the things she wants you to keep in mind: " +
                "\nHer favorite colors are beige, blue, and gray. " +
                "\nShe has a very serious nut allergy." +
                "\nHer family and her inlaws do not get along very well." +
                "\nAnd she is expecting a decor of high class and elegance." +
                "\nHer motto is forget about the groom it's always about the bride");

        Bartender(scan, Name, planPoints);
        GuestSeatingGame(scan, Name, planPoints);
        }




 //rachenza  
//game 1 of level 2
public static void Bartender(Scanner scan, String playerName, int planPoints) throws FileNotFoundException {
	   
        	
         //create array to hold file info for orders
         ArrayList<String> fileorders = new ArrayList<String>();
              
         File O1 = new File("Drinkorders.txt");

         Scanner read1 = new Scanner(O1);
   
         while (read1.hasNextLine()) {
               String data1 = read1.nextLine();
               fileorders.add(data1);
              }
         //create a variable to hold the randomly picked order 
         int random = (int)(Math.random() * fileorders.size()); // range of random numbers from 0 to the size of my array
         String order = fileorders.get(random);
          

            
              
              
              
              
              
         //create array to hold file info for ingredients
         ArrayList<String> ingredients = new ArrayList<String>();

         File O2 = new File("Correctingredients.txt");

         Scanner read2 = new Scanner(O2);

         while (read2.hasNextLine()) {
              String data2 = read2.nextLine();
              ingredients.add(data2);
              }
          //create a variable to hold the randomly picked ingredients
          int randomm = (int)(Math.random() * ingredients.size()); // range of random numbers from 0 to the size of my array
          String correctingredients = ingredients.get(randomm);

            
              
              
              
              
          //create array to hold file info for guest feedback when drinks are going badly 
          ArrayList<String> feedback = new ArrayList<String>();
              
          File O3 = new File("Guestfeedback.txt");

          Scanner read3 = new Scanner(O3);

          while (read3.hasNextLine()) {
                String data3 = read3.nextLine();
                feedback.add(data3);
              }
          int randommm = (int)(Math.random() * feedback.size()); // range of random numbers from 0 to the size of my array
          String  guestfeedback = feedback.get(randommm);
   	  

             
              
           
        
            // Welcome message for the bartender game as well as dialouge
            System.out.println("\nEMERGENCY!!" +
                    "\n One of the bartenders woke up with the flu" +
                    "\n We need an extra hand behind the bar" +
                    "\n Take orders and mix drinks the best you can" +
                    "\n Pay very close attention to the options you choose based on the order you get" +
                    "\n You will pick your base, your sweetener, and a topping\n");
               
            
           int i = 0;
           
           while (i != 3) {
             System.out.println("\nI would like to order a: " + order + " With: " + correctingredients);
             
             
             
             
             Scanner scan2 = new Scanner(System.in);
             System.out.println("\nPick Your Base: Espresso, Tonic Water, Club Soda, Rum, Tequila, Vodka, Gin, Whiskey, Ice Tea\n ");
             String Base = scan2.nextLine().trim().toLowerCase(); 
             
            
           
             
             if (correctingredients.contains(Base)){
            	 System.out.println("\nYou got the Base right!"); 
             }else {
            	 System.out.println("\nGuest: " + guestfeedback);
            	 System.out.println("\nYou got the Base wrong you are down 1 point lets move on ");
                 planPoints -=1;
            	 
             }
          
             
            
             Scanner scan3 = new Scanner(System.in);
             System.out.println("\nPick Your Sweetner: Honey, Cane sugar, caramel, pineapple juice\n");
             String Sweetner = scan3.nextLine().trim().toLowerCase(); 
             
             
             if (correctingredients.contains(Sweetner)){
            	 System.out.println("\nYou got the Sweetner right!"); 
             }else {
            	//create a variable to hold the randomly picked guest feedback 
                 randommm = (int)(Math.random() * feedback.size()); // range of random numbers from 0 to the size of my array
                 guestfeedback = feedback.get(randommm);
            	 System.out.println("\nGuest: " + guestfeedback);
            	 System.out.println("\nYou got the Sweetner wrong you are down 1 point lets move on");
            	  planPoints -=1;
            	
             }
             
         
             Scanner scan4 = new Scanner(System.in);
             System.out.println("\nPick Your Topping: Strawberries, Oranges, Lime, Pineapple Chunks, Mint Leaves, Cherries, Apple Slices, Candy Cane\n");
             String Topping = scan4.nextLine().trim().toLowerCase();
          
        
             if (correctingredients.contains(Topping)){
       	      System.out.println("\nYou got the Topping right!"); 
             }else {
             //create a variable to hold the randomly picked guest feedback 
             randommm = (int)(Math.random() * feedback.size()); // range of random numbers from 0 to the size of my array
             guestfeedback = feedback.get(randommm);
        	 System.out.println("\nGuest: " + guestfeedback);
       	     System.out.println("\nYou got the Topping wrong you are down 1 point lets move on ");
       	     planPoints -=1;
       	
     
            }
            random = (int)(Math.random() * fileorders.size()); // range of random numbers from 0 to the size of my array
            order = fileorders.get(random);
            randomm = (int)(Math.random() * ingredients.size()); // range of random numbers from 0 to the size of my array
            correctingredients = ingredients.get(randomm);
            i+=1;
            
           
           
      
           
            }
        
           System.out.println("\nNice game " + playerName + "The status of your points are: " + planPoints);
           Game+=1;
           
         
        
        
        
            }

public static void GuestSeatingGame(Scanner scan, String playerName, int planPoints) {
    // Game description + intro
    System.out.println("\nWelcome, " + playerName + "!");
    System.out.println("In this mini-game, you will be organizing the seating for the wedding guests.");
    System.out.println("Each guest has specific preferences for where they want to sit, which will affect their satisfaction with the seating.");
    System.out.println("Be strategic! Assign guests to tables according to their preferences to earn planning points.\n");

    // Define guests and their preferences
    String[] guests = {"John", "Sarah", "Alex", "Emily", "David"};
    String[] tables = {"Table 1 (Head Table)", "Table 2 (Quiet Table)", "Table 3 (Food & Drink Table)", 
                       "Table 4 (View Table)", "Table 5 (General Table)"};

    String[] preferences = {
        "John: Prefers to sit with old friends and has a loud personality. A table with plenty of conversation is ideal.",
        "Sarah: Prefers a quiet and peaceful environment, away from noise. Needs a calm, isolated space.",
        "Alex: Prefers to sit near food and drinks, loves to be close to the action and the snacks.",
        "Emily: Prefers a table with a great view of the ceremony, so a spot near the windows or outside is ideal.",
        "David: Prefers to sit at the head table with important guests, likes to feel like a VIP and be the center of attention."
    };

    int remainingSeating = guests.length;
    boolean[] tableOccupied = new boolean[tables.length]; // Track table assignments
    boolean[] guestAssigned = new boolean[guests.length]; // Track guest assignments

    while (remainingSeating > 0) {
        System.out.println("\nRemaining seating: " + remainingSeating);
        System.out.println("Choose a guest to assign (Enter name or number):");

        // Display guests who haven't been seated
        for (int i = 0; i < guests.length; i++) {
            if (!guestAssigned[i]) {
                System.out.println((i + 1) + ". " + guests[i] + " (Preference: " + preferences[i] + ")");
            }
        }

        // Get user input for guest selection (accepts both name and number)
        String guestChoiceInput = scan.nextLine().trim();
        int guestChoice = -1;

        // Check if the user entered a number or name
        for (int i = 0; i < guests.length; i++) {
            if (guestChoiceInput.equalsIgnoreCase(guests[i])) {
                guestChoice = i + 1;
                break;
            }
        }

        if (guestChoice == -1) { // If no name match, try parsing as a number
            try {
                guestChoice = Integer.parseInt(guestChoiceInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid guest name or number.");
                continue; // Re-prompt
            }
        }
        // reply if the input is invalid
        if (guestChoice < 1 || guestChoice > guests.length || guestAssigned[guestChoice - 1]) {
            System.out.println("Invalid choice! This guest has already been assigned a table or does not exist.");
            continue;
        }

        String selectedGuest = guests[guestChoice - 1];
        guestAssigned[guestChoice - 1] = true; // Mark guest as assigned
        System.out.println("You selected " + selectedGuest + ". Now, assign them to a table.");

        // Display available tables
        while (true) {
            System.out.println("\nChoose a table for " + selectedGuest + ":");
            for (int i = 0; i < tables.length; i++) {
                if (!tableOccupied[i]) {
                    System.out.println((i + 1) + ". " + tables[i]);
                }
            }

            String tableChoiceInput = scan.nextLine().trim();
            int tableChoice = -1;

            // Validate table choice (allow number input only)
            try {
                tableChoice = Integer.parseInt(tableChoiceInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid table number.");
                continue; // Re-prompt
            }

            if (tableChoice < 1 || tableChoice > tables.length) {
                System.out.println("Invalid choice! Please select a table from the list.");
                continue; // Re-prompt
            }

            if (tableOccupied[tableChoice - 1]) {
                System.out.println("This table is already full! Please select another.");
                continue; // Re-prompt
            }

            // Assign guest to table
            String assignedTable = tables[tableChoice - 1];
            tableOccupied[tableChoice - 1] = true;
            System.out.println(selectedGuest + " has been successfully assigned to " + assignedTable + ".");

            // Guest satisfaction based on preference
            if ((assignedTable.equals("Table 1 (Head Table)") && selectedGuest.equals("David")) ||
                (assignedTable.equals("Table 2 (Quiet Table)") && selectedGuest.equals("Sarah")) ||
                (assignedTable.equals("Table 3 (Food & Drink Table)") && selectedGuest.equals("Alex")) ||
                (assignedTable.equals("Table 4 (View Table)") && selectedGuest.equals("Emily")) ||
                (assignedTable.equals("Table 5 (General Table)") && selectedGuest.equals("John"))) {
                System.out.println(selectedGuest + " is happy with their seating!");
                planPoints += 3; // Award points for correct seating
            } else {
                System.out.println(selectedGuest + " is not happy with their seating arrangement.");
                planPoints -= 2; // Deduct points for incorrect seating
            }

            remainingSeating--; // Reduce the number of unseated guests
            break; // Exit table assignment loop
        }
    }

    // End of game summary
    System.out.println("\nCongratulations " + playerName + ", the seating arrangement is complete!");
    System.out.println("You have earned a total of " + planPoints + " planning points.");


}

    
  

 //finds the users progress and information needed to move them through the game once they log back in
 public static void goingback(String username,String password, String nameofficial) throws IOException {
	  ArrayList<String> usersaveprogress = new ArrayList<>();
	  File O4 = new File("progress.txt");
	  Scanner scan = new Scanner(O4);
	  
	  while (scan.hasNextLine()) {
		  String data = scan.nextLine();
		  usersaveprogress.add(data);
		  
	  }
	  
	  int index = -1;
	  for (int i = 0; i < usersaveprogress.size(); i++) {
		  String data = usersaveprogress.get(i);
		  String[] parts = data.split(", ");
		  
	   if (parts.length < 6) {
		   continue;
	   }
		   String use = parts[0];
		  String  pass = parts[1];
		  
		  if (use.equals(username) && pass.equals(password)) {
			  index = i;
			 break;
		  }
	  }
	 if (index != -1) {
		 //create array to hold file info for female names
		    ArrayList<String> namesf = new ArrayList<String>();

		    File O = new File("Femalenames.txt");

		    Scanner read = new Scanner(O);

		    while (read.hasNextLine()) {
		        String data1 = read.nextLine();
		        namesf.add(data1);
		    }
		    //create a variable to hold the randomly picked female names
		    int random = (int)(Math.random() * namesf.size()); // range of random numbers from 0 to the size of my array
		    nameofficial = namesf.get(random);
		   
		  String data1 = usersaveprogress.get(index);
		  String[] parts = data1.split(", ");
		  
		 Name = parts[2];
		 Level = Integer.parseInt(parts[3]);
		 Game = Integer.parseInt(parts[4]);
		 planPoints = Integer.parseInt(parts[5]);
		 
		   System.out.println("\nWelcome back! " + Name + 
					 "\nYou left off at Level: " + Level +
					 "\nAnd Game: " + Game + 
					 "\nYour Plan Points are " + planPoints + "Let's get you back where you left off!"); 
		   //System.out.println("Debug: handlelevel called with Game = " + Game + ", Level = " + Level);

		   handlelevel(Game, Level,scan, password, username, nameofficial,namesf);
		   
	 }else {
		 System.out.println("error");
	 }
	 //scan.close();
		 
		 
 }

}
	  
 
		  
			
			 
			  
		 
		  
