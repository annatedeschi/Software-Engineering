package Port;

	import java.time.LocalDate;
	import java.util.Scanner;

	public class tester {
		public static void main(String[] args) {
			Shopping2();
		}
		public static void Shopping2() {
	        int satisfactionPoints = 0;
	        int cart = 0;
	        int total = 0;
	        int toInput = 0;
	        String input = "";
	       
	       String nameofficial = "b";
	       int planPoints = 1;
	       String Name ="c";
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
	        input = scan.nextLine().trim();
	               
	                	
	                
	            
	   
	       while(!input.isEmpty()) {
	    	   toInput = Integer.parseInt(input);
	                if (toInput == 200) {
	                    satisfactionPoints += 20;
	                    cart++;
	                    total += toInput;
	                    System.out.println("\nItem added. Cart[" + cart + "]");
	                    break;
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
	                    System.out.println("\nThis item isn't ringing up. Type in the price to buy your item:  ");
	                    input = scan.nextLine().trim();
	                    continue;
	                }
	       }
	       
	       // Decorations selection
	        System.out.println("\n"
	        		+ "\n"
	        		+ "\nDecorations:");
	        System.out.println("Pink Banner ($200), Floral Centerpiece ($30), LED Lights ($100)");
	        System.out.print("]nType in the price to buy your item: ");
	        input = scan.nextLine().trim();
            
        	
            
            
	 	   
		       while(!input.isEmpty()) {
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
	                	 System.out.println("\nThis item isn't ringing up. Type in the price to buy your item:  ");
		                 input = scan.nextLine().trim();
	                     continue;
	                }
		       }
	                

	        // Cakes selection
	        System.out.println("\n"
	        		+ "\n"
	        		+ "\nCakes:");
	        System.out.println("Marble Cake ($200), Vanilla Cake with Rainbow Frosting ($60), Red Velvet Cake ($100)");
	        System.out.print("\nType in the price to buy your item: ");
	        input = scan.nextLine().trim();
            
        	
            
            
	 	   
		       while(!input.isEmpty()) {
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
	                    cart++;//hdjfgkldndndm
	                    total += toInput;
	                    System.out.println("\nItem added. Cart[" + cart + "]");
	                } else {
	                	 System.out.println("\nThis item isn't ringing up. Type in the price to buy your item:  ");
		                 input = scan.nextLine().trim();
	                     continue;
	                }
		       }
	                
	        // Tiaras selection
	        System.out.println("\n"
	        		+ "\n"
	        		+ "\nTiaras:");
	        System.out.println("Simple Silver Tiara ($100), Gold Tiara with Diamonds ($300), Flower Crown ($50)");
	        System.out.print("\nType in the price to buy your item: ");
	        input = scan.nextLine().trim();
	        
	        
	        
	        
            while(!input.isEmpty()) {
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
	                	 System.out.println("\nThis item isn't ringing up. Type in the price to buy your item:  ");
		                 input = scan.nextLine().trim();
	                     continue;
	                }
            }
	               

	        // Party Favors selection
	        System.out.println("\n"
	        		+ "\n"
	        		+ "\nParty Favors:");
	        System.out.println("Gift Cards ($300), Cotton Candy ($45), Tiara Bottle Openers ($40)");
	        System.out.print("\nType in the price to buy your item: ");
	        input = scan.nextLine().trim();
            
        	
            
            
	 	   
		       while(!input.isEmpty()) {
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
	                	 System.out.println("\nThis item isn't ringing up. Type in the price to buy your item:  ");
		                 input = scan.nextLine().trim();
	                     continue;
	                }
		       }

	                  
	        
		 // Print receipt
	    System.out.println("\nPrinting Your Receipt"
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
	        System.out.println("\nYou have purchased perfectly within the budget! But you went under. You have gained 10 points.");
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


	}



