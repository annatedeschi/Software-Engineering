package Planner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PartyPlannerLevel2 {
	static String username;
	static String nameofficial;
	static String password;
	static String Name;
	static String input;
	static int Game;
	static int Level;
	static int planPoints;
	static Scanner scan = new Scanner(System.in);

public static void main(String[] args) throws IOException {
	
}
public static void diceGame() {
	String answer = "";
	int i = 0;
	System.out.println("Your client's Husband, Tom wants help planning his bachelor after party!");
	System.out.println("Tom and his six closest friends have decided to celebrate at the local casino.");
	System.out.println("To keep the fun going, They will play a special dice gambling game! But its up to yo uto test it first.");
	System.out.println("Are you ready to roll the dice and test your luck?");
	
	answer = scan.nextLine().toLowerCase();
	
 while (i != 1){
	if (!answer.equals("yes")) {
		System.out.println("Are you ready to roll the dice and test your luck?");
		answer = scan.nextLine().toLowerCase();
	}else if(answer.equals("yes")) {
		i++;
		play();
}
}
}


public static void play() {
int i = 1;
Scanner scanner = new Scanner(System.in);
Random random = new Random();

	System.out.println("\nYou and the dealer will each roll one dice. If you roll the same number as the dealer, you win!");
	System.out.println("\nOtherwise, you lose 10 planning points.");
	
while (i != 4) {
	System.out.println("\nRound: " + i);
	System.out.println("\nContinue and press enter to roll the dice and test your luck!");
	scanner.nextLine();
	
	int playerRoll = random.nextInt(6) + 1;
	int dealerRoll = random.nextInt(6) + 1;
	
	System.out.println("You rolled: " + playerRoll);
	printDie(playerRoll);
	System.out.println("The dealer rolled: " + dealerRoll);
	printDie(dealerRoll);
	
	if (playerRoll == dealerRoll) {
	System.out.println("Congratulations! You won the round!");
	PartyPlannerIntros.planPoints += 10;
	} else {
	PartyPlannerIntros.planPoints -= 10;
	System.out.println("You lost this round. 10 planning points deducted.");
	
		}	i++;}
	System.out.println("Alright, good work. you have done a great job of tackling all these wedding tasks." );
	System.out.println("I think you are ready to handle a new challenge... " );
	System.out.println(PartyPlannerHandle.Name + "You now have "  + PartyPlannerIntros.planPoints + " points:");}

private static void printDie(int roll) {
	String[] diceFaces = {
	" -------\n | |\n | ● |\n | |\n -------",
	" -------\n | ● |\n | |\n | ● |\n -------",
	" -------\n | ● |\n | ● |\n | ● |\n -------",
	" -------\n | ● ● |\n | |\n | ● ● |\n -------",
	" -------\n | ● ● |\n | ● |\n | ● ● |\n -------",
	" -------\n | ● ● |\n | ● ● |\n | ● ● |\n -------"
	};
	System.out.println(diceFaces[roll - 1]);
	}



//rachenza
//game 1 of level 2
public static void Bartender( ) throws FileNotFoundException {
	String Base = "";
	String Topping = "";
	String Sweetner = "";
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
	String [] eachingredient = correctingredients.split("\\s+");
	
	
			
	//create array to hold file info for guest feedback when drinks are going badly
	ArrayList<String> feedback = new ArrayList<String>();
	File O3 = new File("Guestfeedback.txt");
	
	Scanner read3 = new Scanner(O3);
	
	while (read3.hasNextLine()) {
	String data3 = read3.nextLine();
	feedback.add(data3);
	}
	int randommm = (int)(Math.random() * feedback.size());
	String guestfeedback = feedback.get(randommm);
	
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
	Base = scan2.nextLine().trim().toLowerCase();
	if (Base.equals(eachingredient[0])){
	System.out.println("\nYou got the Base right!");
	PartyPlannerIntros.planPoints +=2;
	}else {
    randommm = (int)(Math.random() * feedback.size()); // range of random numbers from 0 to the size of my array
    guestfeedback = feedback.get(randommm);
	System.out.println("\nGuest: " + guestfeedback);
	System.out.println("\nYou got the Base wrong you are down 1 point lets move on ");
	PartyPlannerIntros.planPoints -=1;}
	Scanner scan3 = new Scanner(System.in);
	System.out.println("\nPick Your Sweetner: Honey, Cane sugar, caramel, pineapple juice\n");
	Sweetner = scan3.nextLine().trim().toLowerCase();
	if (Sweetner.equals(eachingredient[1])){
	System.out.println("\nYou got the Sweetner right!");
	PartyPlannerIntros.planPoints +=2;
	}else {
	//create a variable to hold the randomly picked guest feedback
	randommm = (int)(Math.random() * feedback.size()); // range of random numbers from 0 to the size of my array
	guestfeedback = feedback.get(randommm);
	System.out.println("\nGuest: " + guestfeedback);
	System.out.println("\nYou got the Sweetner wrong you are down 1 point lets move on");
	PartyPlannerIntros.planPoints -=1;}
	Scanner scan4 = new Scanner(System.in);
	System.out.println("\nPick Your Topping: Strawberries, Oranges, Lime, Pineapple Chunks, Mint Leaves, Cherries, Apple Slices, Candy Cane\n");
	Topping = scan4.nextLine().trim().toLowerCase();
	if (Topping.equals(eachingredient[2])){
	System.out.println("\nYou got the Topping right!");
	PartyPlannerIntros.planPoints +=2;
	}else {
	//create a variable to hold the randomly picked guest feedback
	randommm = (int)(Math.random() * feedback.size()); // range of random numbers from 0 to the size of my array
	guestfeedback = feedback.get(randommm);
	System.out.println("\nGuest: " + guestfeedback);
	System.out.println("\nYou got the Topping wrong you are down 1 point lets move on ");
	PartyPlannerIntros.planPoints -=1;}
	
	
	random = (int)(Math.random() * fileorders.size()); // range of random numbers from 0 to the size of my array
	order = fileorders.get(random);
	randomm = (int)(Math.random() * ingredients.size()); // range of random numbers from 0 to the size of my array
	correctingredients = ingredients.get(randomm);
	eachingredient = correctingredients.split("\\s+");
	i+=1;}
	System.out.println("\nNice game " + PartyPlannerHandle.Name + " The status of your points are: " + PartyPlannerIntros.planPoints);
	}
	



	public static void GuestSeatingGame() {
	// Game description + intro
	System.out.println("\nWelcome, " + PartyPlannerHandle.Name + "!");
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
	PartyPlannerIntros.planPoints += 3; // Award points for correct seating
	} else {
	System.out.println(selectedGuest + " is not happy with their seating arrangement.");
	PartyPlannerIntros.planPoints -= 2; // Deduct points for incorrect seating
	}
	
	remainingSeating--; // Reduce the number of unseated guests
	break; // Exit table assignment loop
	}}
	
	// End of game summary
	System.out.println("\nCongratulations " + PartyPlannerHandle.Name + ", the seating arrangement is complete!");
	System.out.println("You have earned a total of " + PartyPlannerIntros.planPoints + " planning points.");}
	
	// public static void GamblingGame(Scanner scan, String playerName, int planPoints) {
	// making dice roller game, "dealer" asks what number the user think they will roll, the user guesses, then
	// the dealer then rolls the dice and we see if the number matches it, and if it does,
	// user makes money (2x, 3x, etc), and if they lose, then they lose the money they bet}



}
