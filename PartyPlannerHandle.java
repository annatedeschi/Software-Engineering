package Planner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PartyPlannerHandle {
	static String username;
	static String nameofficial;
	static String password;
	public static String Name;
	static String input;
	static String playerName;
	static int Game;
	static int Level;
	static int planPoints;
	static Scanner scan = new Scanner(System.in);
	static PartyPlannerLevel1 Obj1 =  new PartyPlannerLevel1(); 
	static PartyPlannerIntros Obj3 =  new PartyPlannerIntros(); 
	static PartyPlannerLevel2 Obj4 = new PartyPlannerLevel2();
	static PartyPlannerLevel3 Obj5 = new PartyPlannerLevel3();
	public static HashMap<String, String> userInfo = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		
	}
	//login method
	public static void login( ArrayList<String>namesf) throws IOException {
		
		System.out.println("\nLet's log into your account");
		
		 boolean Login = false;
		while(!Login) {
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
		Login = true;
		goingback(namesf);}
		else {
	        continue;
	    }

			}System.out.println("Invalid login. Please try again.");
			}}


		//create a new acc method
		public static void register(String intro) throws IOException {
		System.out.println("\nCreate a New Account!");
		while (intro.equals("no")) {
		System.out.print("Create a username: ");
		username = scan.nextLine().trim();
		System.out.println("Is this the username you would like to use for your account: " + username);
		input = scan.nextLine().trim().toLowerCase();
		if (input.equals("no")) {
		continue;
		} else if (input.equals("yes")) {
			boolean usernameExist = hashinfofromfile(userInfo);
			
			if (usernameExist) {
			System.out.println("Username is already taken. Please restart.");
			}else {
				break;
			}
			
	     }else {
	    	 System.out.println("Invalid response lets try again"); 
		 }
		 }
		
		
		
		while (intro.equals("no")) {
		System.out.print("Create a password: ");
		password = scan.nextLine().trim();
		System.out.println("Is this the password you would like to use for your account: " + password);
		input = scan.nextLine().trim();
		
		if (input.equals("no")) {
		continue;
		} else if (input.equals("yes")) {
			break;
		}else {
			 System.out.println("Invalid response lets try again");
		}
		}
		
		
		// Add username and password to the hashmap
		userInfo.put(username, password);
		
		// Add username and password to the file
		hashtofile(userInfo);
		
		System.out.println("\nAccount created successfully!");
		System.out.println("You're all set! Now it's time to begin your life as an event planner!");
		
		// Start the games
		startgames();
		
		
		
		

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
		
		String line;
		
		
		while ((line = reader.readLine()) != null){
		String[] parts = line.split(":");
		if (parts.length == 2) {
		String usernamefromfile = parts[0].trim();
		if(!username.isEmpty() && usernamefromfile.equals(username)){
		username = usernamefromfile;
		return true;}
		else{
			}}
		}

	reader.close();
	return false;}

	//rachenza
	//save the users progress once they say yes and add to a progress file
	public static void saveprogress() throws IOException {
		int i = 0;
	while (i != 1) {
		Scanner scan0 = new Scanner(System.in);
		System.out.println("Would you like to save your progress so far and log out ?");
		String userfeedprogress = scan0.nextLine().trim().toLowerCase();
		if (userfeedprogress.equals("yes")) {
		BufferedWriter writer = new BufferedWriter(new FileWriter("progress.txt",true));
		writer.write(username + ", " + password + ", " + Name + ", " + Level + ", " + Game + ", " + PartyPlannerIntros.planPoints);
		writer.newLine();
		writer.close();
		System.out.println("all set");
		i++;
		System.exit(0);
		}else if(userfeedprogress.equals("no")){
		System.out.println("Okay lets keep going");
		break;
		}else {
			continue;
		}
	}
	}

	//rachenza
	//sends the user to the correct game once they log back in
		public static void handlelevel( ArrayList<String>namesf) throws IOException {
			System.out.println("Let's get you back where you left off " + Name + " !");
		
		if (Game == 1 && Level == 1) {
		Obj1.UnscrambleBabyName();
		saveprogress();
		Obj1.DateGuesser();
		saveprogress();
		Obj3.Wedding();
		Obj4.diceGame();
		saveprogress();
		Obj4.Bartender();
		saveprogress();
		Obj4.GuestSeatingGame( );
		saveprogress();
		Obj3.Quincenera();
		Obj5.Shopping();
		saveprogress();
		Obj5.DJ();
		saveprogress();
		
		
		}else {
		}
		if (Game == 2 && Level == 1) {
		Obj1.DateGuesser();
		saveprogress();
		Obj3.Wedding();
		Obj4.diceGame();
		saveprogress();
		Obj4.Bartender();
		saveprogress();
		Obj4.GuestSeatingGame();
		saveprogress();
		Obj3.Quincenera();
		Obj5.Shopping();
		saveprogress();
		Obj5.DJ();
		saveprogress();
		}else {
		}
		
		if (Game == 3 && Level == 1) {
		Obj3.Wedding();
		Obj4.diceGame();
		saveprogress();
		Obj4.Bartender();
		saveprogress();
		Obj4.GuestSeatingGame();
		saveprogress();
		Obj3.Quincenera();
		Obj5.Shopping();
		saveprogress();
		Obj5.DJ();
		saveprogress();
		}else {
		}
		
		
		if (Game == 1 && Level == 2) {
		Obj4.Bartender();
		saveprogress();
		Obj4.GuestSeatingGame();
		saveprogress();
		Obj3.Quincenera();
		Obj5.Shopping();
		saveprogress();
		Obj5.DJ();
		saveprogress();
		}else {
		}
		
		if (Game == 2 && Level == 2) {
		Obj4.GuestSeatingGame();
		saveprogress();
		Obj3.Quincenera();
		Obj5.Shopping();
		saveprogress();
		Obj5.DJ();
		saveprogress();
		}else {
		}
		
		if (Game == 3 && Level == 2) {
		Obj3.Quincenera();
		Obj5.Shopping();
		saveprogress();
		Obj5.DJ();
		saveprogress();
		}else {
		}
		
		if (Game == 1 && Level == 3) {
		Obj5.DJ();
		saveprogress();
		}else {
		}
		
		if (Game == 2 && Level == 3) {
		//third game
			}else {
			}
		
	}


	//rachenza
	//introduction to the overall game
	public static void startgames() throws IOException {
		// Game INtro == in future: can change this to reading in from TXT file...
		System.out.println("\nWelcome to your event planning adventure!");
		System.out.println("We need help to plan a variety of events happening around town.");
		System.out.print("First off, What is your name?");
		 Name = scan.nextLine(); //user inputs their name
		
		System.out.println("Welcome, " + Name + "! Let's begin your event planning journey.\n");
		System.out.println("You are tasked with planning events for your local neighborhood");
		System.out.println("Let's start easy, " + Name + ". First you will begin by planning a baby shower.");
		System.out.println("As you go along and complete challenges, you will earn 'Planning points'. Earn enough and you will become the ultimate planner pro!\n");
	
		Level +=1;
		Obj3.Babyshower();
		//minigames
		Obj1.RockPaperScissors();
		Game +=1;
		saveprogress();
		Obj1.UnscrambleBabyName();
		Game +=1;
		saveprogress();
		Obj1.DateGuesser();
		Game +=1;
		saveprogress();
		
		//rachenza
		//calling intro to lvl 2
		
		Game = 0;
		Obj3.Wedding();
		Obj4.diceGame();
		Game+=1;
		saveprogress();
		Obj4.Bartender();
		Game+=1;
		saveprogress();
		Obj4.GuestSeatingGame();
		Game+=1;
		Level +=1;
		saveprogress();
		//rachenza
		//calling intro to lvl 3
		
		Game = 0;
		Obj3.Quincenera();
		Obj5.Shopping();
		Game+=1;
		saveprogress();
		Obj5.DJ();
		Game+=1;
		saveprogress();
		
		}
	//finds the users progress and information needed to move them through the game once they log back in
	public static void goingback( ArrayList<String>namesf) throws IOException {
		ArrayList<String> usersaveprogress = new ArrayList<>();
		File O4 = new File("progress.txt");
		Scanner scan = new Scanner(O4);
		while (scan.hasNextLine()) {
		String data = scan.nextLine();
		usersaveprogress.add(data);}
		int index = -1;
		for (int i = 0; i < usersaveprogress.size(); i++) {
		String data = usersaveprogress.get(i);
		String[] parts = data.split(", ");
		if (parts.length < 6) {
		continue;}
		String use = parts[0];
		String pass = parts[1];
		if (use.equals(username) && pass.equals(password)) {
		index = i;
		break;}}
		if (index != -1) {
		//create array to hold file info for female names
		
		//create a variable to hold the randomly picked female names
		int random = (int)(Math.random() * namesf.size()); // range of random numbers from 0 to the size of my array
		nameofficial = namesf.get(random);
		String data1 = usersaveprogress.get(index);
		String[] parts = data1.split(", ");
		Name = parts[2];
		Level = Integer.parseInt(parts[3]);
		Game = Integer.parseInt(parts[4]);
		PartyPlannerIntros.planPoints = Integer.parseInt(parts[5]);
		System.out.println("\nWelcome back! " + Name +
		"\nYou left off at Level: " + Level +
		"\nAnd Game: " + Game +
		"\nYour Plan Points are: " + PartyPlannerIntros.planPoints);
		//System.out.println("Debug: handlelevel called with Game = " + Game + ", Level = " + Level);
		
		handlelevel(namesf);
		}else {
		System.out.println("error");}
		//scan.close();
	}

	
		
	}

	


