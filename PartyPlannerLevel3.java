package Planner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PartyPlannerLevel3 {
	static String nameofficial;
	static String Name;
	static int Game;
	static int Level;
	static String username;
	static String password;
	static Scanner scan = new Scanner(System.in);
	static int planPoints;
	static String guest;
	static String req;
	static String response;
	static Clip clip;
public static void main(String[] args) throws IOException {
		
	}
public static void Shopping() {
	        int satisfactionPoints = 0;
	        int cart = 0;
	        int total = 0;
	        int toInput = 0;
	        String input = "";
	      
	       
	        Scanner scan = new Scanner(System.in);

	        
	        System.out.println("\n"
	        		+ "\n"
	        		+ "\nIt's time for you to shop for the Quincenera.");
	        System.out.println("Be mindful of what you buy because " + nameofficial + "'s parents set the budget at $475.");
	        System.out.println("If you go over budget, you will lose points, but if you go under, you gain points. Let's go shopping!");

	        // Dresses selection
	        System.out.println("\n"
	        		+ "\n"
	        		+ "\nDresses:");
	        System.out.println("Pink Dress Ball Gown ($200), Blue Mermaid Dress ($120), Purple Frill Dress ($100)");
	        System.out.print("\nType in the price to buy your item: ");
	        
	        while (true) {
	            input = scan.nextLine().trim();
	            if (input.isEmpty()) {
	                System.out.println("\nPlease enter a valid price: ");
	                continue;
	            }

	            try {
	                toInput = Integer.parseInt(input);
	                if (toInput == 200) {
	                    satisfactionPoints += 20;
	                    cart++;
	                    total += toInput;
	                    System.out.println("\nItem added. Cart[" + cart + "]");
	                } else if (toInput == 120) {
	                    satisfactionPoints += 10;
	                    cart++;
	                    total += toInput;
	                    System.out.println("\nItem added. Cart[" + cart + "]");
	                } else if (toInput == 100) {
	                    satisfactionPoints += 5;
	                    cart++;
	                    total += toInput;
	                    System.out.println("\nItem added. Cart[" + cart + "]");
	                } else {
	                    System.out.println("\nThis item isn't ringing up. Please try again. Press enter to ring your item again");
	                    continue;
	                }
	                break;
	            } catch (NumberFormatException e) {
	                System.out.println("\nPlease enter a valid price: ");
	            }
	        }

	        // Decorations selection
	        System.out.println("\n"
	        		+ "\n"
	        		+ "\nDecorations:");
	        System.out.println("Pink Banner ($200), Floral Centerpiece ($30), LED Lights ($100)");
	        System.out.print("]nType in the price to buy your item: ");

	        while (true) {
	            input = scan.nextLine().trim();
	            if (input.isEmpty()) {
	                System.out.println("\nPlease enter a valid price: ");
	                continue;
	            }

	            try {
	                toInput = Integer.parseInt(input);
	                if (toInput == 200) {
	                    satisfactionPoints += 5;
	                    cart++;
	                    total += toInput;
	                    System.out.println("\nItem added. Cart[" + cart + "]");
	                } else if (toInput == 30) {
	                    satisfactionPoints += 20;
	                    cart++;
	                    total += toInput;
	                    System.out.println("\nItem added. Cart[" + cart + "]");
	                } else if (toInput == 100) {
	                    satisfactionPoints += 10;
	                    cart++;
	                    total += toInput;
	                    System.out.println("\nItem added. Cart[" + cart + "]");
	                } else {
	                    System.out.println("\nThis item isn't ringing up. Please try again. Press enter to ring your item again");
	                    continue;
	                }
	                break;
	            } catch (NumberFormatException e) {
	                System.out.println("\nPlease enter a valid price: ");
	            }
	        }

	        // Cakes selection
	        System.out.println("\n"
	        		+ "\n"
	        		+ "\nCakes:");
	        System.out.println("Marble Cake ($200), Vanilla Cake with Rainbow Frosting ($60), Red Velvet Cake ($100)");
	        System.out.print("\nType in the price to buy your item: ");
	        
	        while (true) {
	            input = scan.nextLine().trim();
	            if (input.isEmpty()) {
	                System.out.println("\nPlease enter a valid price: ");
	                continue;
	            }

	            try {
	                toInput = Integer.parseInt(input);
	                if (toInput == 200) {
	                    satisfactionPoints += 5;
	                    cart++;
	                    total += toInput;
	                    System.out.println("\nItem added. Cart[" + cart + "]");
	                } else if (toInput == 60) {
	                    satisfactionPoints += 10;
	                    cart++;
	                    total += toInput;
	                    System.out.println("\nItem added. Cart[" + cart + "]");
	                } else if (toInput == 100) {
	                    satisfactionPoints += 20;
	                    cart++;
	                    total += toInput;
	                    System.out.println("\nItem added. Cart[" + cart + "]");
	                } else {
	                    System.out.println("\nThis item isn't ringing up. Please try again. Press enter to ring your item again");
	                    continue;
	                }
	                break;
	            } catch (NumberFormatException e) {
	                System.out.println("\nPlease enter a valid price: ");
	            }
	        }

	        // Tiaras selection
	        System.out.println("\n"
	        		+ "\n"
	        		+ "\nTiaras:");
	        System.out.println("Simple Silver Tiara ($100), Gold Tiara with Diamonds ($300), Flower Crown ($50)");
	        System.out.print("\nType in the price to buy your item: ");
	        
	        while (true) {
	            input = scan.nextLine().trim();
	            if (input.isEmpty()) {
	                System.out.println("\nPlease enter a valid price: ");
	                continue;
	            }

	            try {
	                toInput = Integer.parseInt(input);
	                if (toInput == 100) {
	                    satisfactionPoints += 20;
	                    cart++;
	                    total += toInput;
	                    System.out.println("\nItem added. Cart[" + cart + "]");
	                } else if (toInput == 300) {
	                    satisfactionPoints += 10;
	                    cart++;
	                    total += toInput;
	                    System.out.println("\nItem added. Cart[" + cart + "]");
	                } else if (toInput == 50) {
	                    satisfactionPoints += 5;
	                    cart++;
	                    total += toInput;
	                    System.out.println("\nItem added. Cart[" + cart + "]");
	                } else {
	                    System.out.println("\nThis item isn't ringing up. Please try again. Press enter to ring your item again");
	                    continue;
	                }
	                break;
	            } catch (NumberFormatException e) {
	                System.out.println("\nPlease enter a valid price: ");
	            }
	        }

	        // Party Favors selection
	        System.out.println("\n"
	        		+ "\n"
	        		+ "\nParty Favors:");
	        System.out.println("Gift Cards ($300), Cotton Candy ($45), Tiara Bottle Openers ($40)");
	        System.out.print("\nType in the price to buy your item: ");

	        while (true) {
	            input = scan.nextLine().trim();
	            if (input.isEmpty()) {
	                System.out.println("\nPlease enter a valid price: ");
	                continue;
	            }

	            try {
	                toInput = Integer.parseInt(input);
	                if (toInput == 300) {
	                    satisfactionPoints += 20;
	                    cart++;
	                    total += toInput;
	                    System.out.println("\nItem added. Cart[" + cart + "]");
	                } else if (toInput == 45) {
	                    satisfactionPoints += 10;
	                    cart++;
	                    total += toInput;
	                    System.out.println("\nItem added. Cart[" + cart + "]");
	                } else if (toInput == 40) {
	                    satisfactionPoints += 5;
	                    cart++;
	                    total += toInput;
	                    System.out.println("\nItem added. Cart[" + cart + "]");
	                } else {
	                    System.out.println("\nThis item isn't ringing up. Please try again. Press enter to ring your item again");
	                    continue;
	                }
	                break;
	            } catch (NumberFormatException e) {
	                System.out.println("\nPlease enter a valid price: ");
	            }
	        }

	        // Print receipt
	        System.out.println("\nPrinting Your Receipt....."
	        		+ "\n....."
	        		+ "\n....."
	        		+ "\n.....");
	        LocalDate currentDate = LocalDate.now();
	        System.out.println("\n" +
	                "Card Owner: " + Name +
	                "\nDate: " + currentDate +
	                "\n-------------------------------------------------" +
	                "\nTotal Items: " + cart +
	                "\nTotal Amount: $" + total +
	                "\nBudget: $475  Difference: $" + (total - 475));

	        // Check if the user stayed within budget
	        if (total == 475) {
	            System.out.println("\nYou have purchased perfectly within the budget! Good job " + Name + ". You have earned 20 points.");
	        } else if (total > 475) {
	            System.out.println("\nYou did not purchase within the budget. You went over. You have lost 20 points.");
	        } else if (total < 475) {
	            System.out.println("\nYou did not purchase within the budget. You went under. You have gained 10 points.");
	        }

	        // Satisfaction Points check
	        if (satisfactionPoints == 100) {
	            System.out.println("\nYou have made " + nameofficial + " really happy! You will end this game with an extra 2 points.");
	        } else if (satisfactionPoints >= 60) {
	            System.out.println("\nYou have made " + nameofficial + " somewhat happy. You will end this game with an extra 1 point.");
	        } else {
	            System.out.println("\nYou have made " + nameofficial + " unsatisfied with the choices you picked.");
	        }

	        // Final Points
	        planPoints += satisfactionPoints;
	        System.out.println("\nCongrats on finishing the shopping spree. Your total points are now: " + planPoints);
	    }
	

   
	
//ball gown dress-200
   //floral centerpiecec-30
   //red velvet cake-100
   //cooton candy bags-45
	//simple silver tiraa-100
//475-perfect amount



public static void DJ() throws IOException {

	System.out.println("\n"
            + "\n"
            + "Hello " + "Name" + " The DJ is sick and we need you to fill in"
            + "\nThe party guests have song requests and you need to use your judgment"
            + "\nTo select based off the options you have for each request"
            + "\nChoose the right songs and earn points. Choose the wrong song and lose points"
            + "\nYou got this, if you mess up the only murder on the dancefloor will be your music.");

    ArrayList<String> GuestReq = new ArrayList<>();
    BufferedReader read = new BufferedReader(new FileReader("MusicRequest.txt"));
    String line;
    int g = 0;  
    int i = 0; 

   
    while ((line = read.readLine()) != null) {
        GuestReq.add(line);
    }

    while (g != 4) { 
       
    
        System.out.println("\nRound: " + (g + 1));

        // Choose a random request from the list
        int random = (int)(Math.random() * GuestReq.size());
        String randomline = GuestReq.get(random);
        String[] parts = randomline.split(":", 2);
        guest = parts[0].trim();  
        req = parts[1].trim();  
        System.out.println(guest + ": " + req); 
     

       
            System.out.println("\nYour options are: "
                    + "\nA. Espresso-Sabrina Carpenter "
                    + "\nB. Push 2 Start-Tyla "
                    + "\nC. On The Floor-Jennifer Lopez ft Pitbull"
                    + "\nD. Feel This Moment-Pitbull ft Christina Aguilera"
                    + "\nE. BIRDS OF A FEATHER-Billie Eilish"
                    + "\nF. Until I Found You-Stephen Sanchez");

            System.out.println("\nType 'Yes' to listen to the samples of these songs."
             		+ "\nOr type 'No' to pick which song to play for the guest?");
                  
            response = scan.next().toLowerCase();
            
            while (response.equals("yes")){
            	System.out.println("\nWhich sample did you want to hear:");
            	 response = scan.next().toLowerCase();
            	 if(response.equals("a")) {
                     stopSong();
                     playSong("Espresso-Sabrina Carpenter-cut.wav");
                 } else if (response.equals("b")) {
                     stopSong();
                     playSong("PUSH 2 START-Tyla-cut.wav");
                 } else if (response.equals("c")) {
                     stopSong();
                     playSong("On The Floor - Jennifer Lopez ft Pitbull-cut.wav");
                 } else if (response.equals("d")) {
                     stopSong();
                     playSong("Feel This Moment-Pitbull  ft. Christina Aguilera-cut.wav");
                 } else if (response.equals("e")) {
                     stopSong();
                     playSong("BIRDS OF A FEATHER-Billie Eilish-cut.wav");
                 } else if (response.equals("f")) {
                     stopSong();
                     playSong("Until I Found You-Stephen Sanchez-cut.wav");
                 }
                 }
            if (!response.equals("yes") && !response.equals("no")){
                    System.out.println("invalid response try again");
                                  continue;}
           
    
            
                 
              
            	 
               
            
            if (response.equals("no")){
            		 System.out.println("\nWhich sample suits the guest's request?");
                     response = scan.next().toLowerCase();
                     g++;  // Increment the round counter
                     

                  if ((response.equals("b") && guest.equals("Birthday Girl")) ||
                    	        (response.equals("c") && guest.equals("Dad")) ||
                    	        (response.equals("e") && guest.equals("Mom")) ||
                    	        (response.equals("f") && guest.equals("Grandma"))) {
                    	        stopSong();
                    	        System.out.println("\nYou're good at this.");
                    	        planPoints += 10;
                    	   } else {
                    	        stopSong();
                    	        System.out.println("\nNot the best choice.");
                    	        planPoints -= 5;
                    	    }
                  
                    	}
          
      
                     }
            
        
        
       
        
    
    

    System.out.println("\nGood job " + Name + " You have earned a total of " + planPoints + " points!");
}



//play the song using Clip
private static void playSong(String fileName) {
    try {
        File soundfile = new File(fileName);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundfile);
        clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
        System.err.println("Error with audio file or playback: " + e.getMessage());
    }
}

// stop the song
private static void stopSong() {
    if (clip != null) {
        clip.stop();
        clip.flush();
    }
}

}
