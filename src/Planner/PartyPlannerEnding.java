package Planner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PartyPlannerEnding {
	static Scanner scan = new Scanner(System.in);
	static int FinalScore;
	static ArrayList<String> LeaderBoard = new ArrayList<String>();
	static String playername;
	static int playerscore;

	public static void main(String[] args) throws IOException {
		
	}

	
	

	public static void CloseGame() throws IOException {
		
	    System.out.println("\nThe party is over, " + PartyPlannerHandle.Name + "!");
	    System.out.println("\nYou finished with " + PartyPlannerHandle.planPoints);
	    if ( ( PartyPlannerHandle.planPoints) == 180) { 
	        System.out.println("\nAmazing job! You're one of our top-tier party planner's!");
	    } else if (( PartyPlannerHandle.planPoints) == 120) {
	        System.out.println("\nGood job! You did well managing the party.");
	    } else {
	        System.out.println("\nYou may need to brush up on your party planning skills! "
	        		+ "\nI'd suggest starting over to plan some events once more.");
	    }
	    System.out.println("\nThank you for playing Party Planner! Hope to see you next time!");
	   
	  
	    
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter("scoreboard.txt", true))) {
            writer.write(PartyPlannerHandle.Name + ":" + PartyPlannerHandle.planPoints);
            writer.newLine();  // Move to the next line after writing
	   
	       // Reading from the file and displaying the scores to the user
            try (BufferedReader reader = new BufferedReader(new FileReader("scoreboard.txt"))) {
               String line;
            while ((line = reader.readLine()) != null) {
               String[] parts = line.split(":");
               if (parts.length == 2) {
            	    playername = parts[0];
            	    playerscore = Integer.parseInt(parts[1]);
            	   LeaderBoard.add(playername + ":" + playerscore);
               }
             }
            
         //Sort the leaderboard in descending order based on the score
            LeaderBoard.sort((a, b) -> {
                int scoreA = Integer.parseInt(a.split(":")[1]);
                int scoreB = Integer.parseInt(b.split(":")[1]);
                return Integer.compare(scoreB, scoreA);  // Sorting in descending order
            });

            // Write the sorted leaderboard back to the file
            try (BufferedWriter writer1 = new BufferedWriter(new FileWriter("scoreboard.txt"))) {
                for (String entry : LeaderBoard) {
                    writer1.write(entry);
                    writer1.newLine();  // Move to the next line after writing
                }
	    }
            }
	    }

	       // Reading from the file and displaying the scores to the user
         try (BufferedReader reader = new BufferedReader(new FileReader("scoreboard.txt"))) {
            String line;
         while ((line = reader.readLine()) != null) {
            String[] parts = line.split(":");
            if (parts.length == 2) {
         	    playername = parts[0];
         	    playerscore = Integer.parseInt(parts[1]);
         	   LeaderBoard.add(playername + ":" + playerscore);
            }
          }
         
	    System.out.println("\n------LeaderBoard------" + LeaderBoard);
         }
	    
	   
	            while (!LeaderBoard.isEmpty()) {
	            	 System.out.println("\nWould you like to restart the game?" +
	         	    	"\nOr would you like to exit the game? (yes to restart /no to exit)");
	         	          String restart = scan.nextLine().trim();
	            if(restart.equals("yes")) {
	            	System.out.println("\nYour username and password is still the same.");
	            	restartgame();}
	            else if(restart.equals("no")) {
	            	System.out.println("\nNo problem! Thanks again for playing. Bye!");
	            	System.exit(0);
	            }else if (!restart.equals("yes") || !restart.equals("no")) {
	            	System.out.println("\nWrong response lets try again");
	            	continue;
	            
	            }
	            }
	}
	            
	
	
	            
	
	
	public static void restartgame() throws IOException {
		 
		  File file = new File("progress.txt");
		 List<String> Changedprogress = new ArrayList<>();
		
		    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
		         String line;

		        
		         while ((line = reader.readLine()) != null) {
		             if (!line.startsWith(PartyPlannerHandle.username + ", " + PartyPlannerHandle.password)) {
		                    Changedprogress.add(line);
		                }
		            }

		       
		        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
		            for (String remainingLine : Changedprogress) {
		                 writer.write(remainingLine);
		                 writer.newLine(); }
		            }
		           }
		    PartyPlannerHandle.Progress = 1;
		    PartyPlannerHandle.planPoints = 0;
		    PartyPlannerHandle.miniplayed.clear();
		    PartyPlannerHandle.mini.clear();
		    PartyPlannerHandle.login();
	              }
}

		            
		 

		
	
	    
