package Planner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PartyPlannerIntros {
	static String nameofficial;
	static String Name;
	static int Game;
	static int Level;
	static String username;
	static String password;
	static Scanner scan = new Scanner(System.in);
	static int planPoints;
	static PartyPlannerHandle Obj2 = new PartyPlannerHandle();
	public static HashMap<String, String> userInfo = new HashMap<>();

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Event Planner Pro the game!");
		System.out.println("Are you a returning user? (yes/no)");
		// trim whitespaces and make lowercases to account for users input
		String intro = scan.nextLine().trim().toLowerCase();
		if (intro.equals("yes")) {
		Obj2.login();
		} else if (intro.equals("no")) {
		PartyPlannerHandle.register(intro);
		} else {
		System.out.println("ERROR: Invalid input. Please restart, and try again!");
		scan.close();
		return;
		}
	}

	//rachenza
	//intro to level 1
	public static void Babyshower() {

		System.out.println("You are tasked with planning events for your local neighborhood!\n");
		System.out.println("Lets start easy," + Name + ". First you will begin by planning a baby shower for " + nameofficial + "\n.");
		}

	
	//rachenza
	//Lvl 2 Intro
	public static void Wedding(ArrayList<String> namesf)  {
		int random = (int)(Math.random() * namesf.size()); // range of random numbers from 0 to the size of my array
		nameofficial = namesf.get(random);

		
		System.out.println("\nCongrats on making it to Level 2 " + Name + "\nIn this level you will be planning a wedding");
		
		System.out.println("\n" + nameofficial + " wants a fairytale wedding she's been planning for this day since she was 10." +
		"\nHere is a dialogue about some of the things she wants you to keep in mind: " +
		"\nHer favorite colors are beige, blue, and gray. " +
		"\nShe has a very serious nut allergy." +
		"\nHer family and her inlaws do not get along very well." +
		"\nAnd she is expecting a decor of high class and elegance." +
		"\nHer motto is forget about the groom it's always about the bride");

	}
	


	//Intro Level 3 
	public static void Quincenera(ArrayList<String> namesf) {
		int random = (int)(Math.random() * namesf.size());
		nameofficial = namesf.get(random);
		System.out.println("\n"
				+ "\n"
				+ "Welccome " + Name + " To " + nameofficial + " Quincenera she has been looking foward to this day since she was 7. "
				+ "She wants the party to be Fairytale theme, very flashy with lots of flowers and vines. "
				+ "And she wants a really big dress something that sticks out. "
				+ "This is a really sopecial day for " + nameofficial );
		
		
		
	}
}
