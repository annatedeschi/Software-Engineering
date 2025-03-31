package Planner;

import java.util.Scanner;

public class PartyPlannerEnding {
	static String Name;
	static Scanner scan = new Scanner(System.in);
	static int planPoints;

	public static void CloseGame() {
	    System.out.println("\nThe party is over, " + Name + "!");
	    System.out.println("You finished with " + planPoints + " points.");

	    if (planPoints >= 120) { //idk have to change values to like the actual value scale 
	        System.out.println("\nAmazing job! You're a top-tier party planner!");
	    } else if (planPoints >= 75) {
	        System.out.println("\nGood job! You did well managing the party.");
	    } else {
	        System.out.println("\nYou may need to brush up on your party planning skills!");
	    }
	    System.out.println("\nThank you for playing Party Planner! Hope to see you next time!");
	}

	}

