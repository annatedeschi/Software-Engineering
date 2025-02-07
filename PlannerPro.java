import java.util.HashMap;
import java.util.Scanner;
public class PlannerPro {

   public static void Lvl1BabyShower(){
     System.out.println("\nhd");

   }
    public static void main(String[] args) {
        HashMap<String, String> UserInfo = new HashMap<>();//create a hashmap to store username and password
        Scanner scan2 = new Scanner(System.in);//create a scanner
        System.out.println("Welcome to PlannerPro\nAre you a returning user?\nPlease type 'yes' or 'no'");
        String intro = scan2.nextLine();//store users answer into variable intro
        while (intro.equals("yes")){//while intro equals yes 
          Scanner scan = new Scanner(System.in);//create a new scanner
          System.out.println("Please pass in your first name which will now be your username:\n");
          String key = scan.nextLine();//store username from user into variable key
          System.out.println("Please create and pass in your password:\n");
          String value = scan.nextLine();//store username from user into variable value
          UserInfo.put(key, value);//add in both variables from user input into the hash map
          System.out.println(UserInfo);//print the hash map for us to see remove this when code is finalized 

          System.out.println("Do you want to add another account? Please type 'yes' or 'no'");//see if user possibly wants to create another account
          intro = scan.nextLine();//use the intro variable to store this input which repeats or exits the loop

        }
        System.out.println("Your're all set setting up your account, lets go play!");//loop is over!
        Lvl1BabyShower();
        }



        
        
       

       }



        
    
    
