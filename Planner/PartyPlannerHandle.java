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
    static String Name;
    static String input;
    static String fillergame;
    static String endgame;
    static String levelchoice;
    static String yayresponse;
    static String gui;
    static int Level;
    static int Progress = 1;
    static  int lastgame;
    static int planPoints;
    static int points;
    static int fillerpoints;
    static Scanner scan = new Scanner(System.in);
    static PartyPlannerLevel1 Obj1 =  new PartyPlannerLevel1();
    static PartyPlannerIntros Obj3 =  new PartyPlannerIntros();
    static PartyPlannerLevel2 Obj4 = new PartyPlannerLevel2();
    static PartyPlannerLevel3 Obj5 = new PartyPlannerLevel3();
    static PartyPlannerEnding Obj6 = new PartyPlannerEnding();
    static FillerGames Obj7 = new FillerGames();
    public static HashMap<String, String> userInfo = new HashMap<>();

    public static void main(String[] args) throws IOException {

    }
    //login method
    public static void login() throws IOException {
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
        chooselevel();}
        else {
            continue;
        }

            }System.out.println("Invalid login. Please try again.");
            }}


        // create a new acc method
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
        System.out.println("\nWould you like to save your progress so far and log out ?");
        String userfeedprogress = scan0.nextLine().trim().toLowerCase();
        if (userfeedprogress.equals("yes")) {
        BufferedWriter writer = new BufferedWriter(new FileWriter("progress.txt",true));
        writer.write(username + ", " + password + ", " + Name + ", " + Level + ", " + lastgame + ", " + Progress + ", " + planPoints);

        writer.newLine();
        writer.close();
        System.out.println("\nall set");
        i++;
        System.exit(0);
        }else if(userfeedprogress.equals("no")){
        System.out.println("\nOkay lets keep going");
        chooselevel();
        }else {
            continue;
        }
    }
    }

    public static void filler() throws IOException {
        int random;
        ////

        ArrayList<String> mini = new ArrayList<>();
        mini.add("passwordgame");
        mini.add("jeopardy");
        mini.add("tic tac toe");

        random = (int)(Math.random() * mini.size()); // range of random numbers from 0 to the size of my array
        fillergame = mini.get(random);
        while ( Progress == 1 && planPoints < 50) {
            planPoints = 0;
          System.out.println("\nYou did not gain enough points in this level."
                  + "\nYou'll gain them back through a filler game");
              if (fillergame.equals("passwordgame")){
                  FillerGames.passwordGame();}
              else if (fillergame.equals("tic tac toe")) {
                    System.out.println("You picked Tic Tac Toe...starting game.");
                   gui= scan.nextLine().toLowerCase();
				if (gui.equals("yes")) {
					break;
				}

                }else if (fillergame.equals("jeopardy")) {
                      System.out.println( "Taking you to jeopardy type 'yay' to start.");
                      yayresponse = scan.nextLine().toLowerCase().trim();
                      if (yayresponse.equals("yay")){
                      Jeopardy.enter();
                      gui = scan.nextLine().toLowerCase();
                      if (gui.equals("yes") && planPoints == 60 && Jeopardy.access.equals("yes")) {
                          break;
                      }else {
                          continue;
                      }
                      }
                }
        }








        random = (int)(Math.random() * mini.size()); // range of random numbers from 0 to the size of my array
         fillergame = mini.get(random);
        while ( Progress == 2 && planPoints < 100) {
            planPoints = 0;
              System.out.println("\nYou did not gain enough points in this level."
                      + "\nYou'll gain them back through a filler game");
                  if (fillergame.equals("passwordgame")){
                      FillerGames.passwordGame();}
                  else if (fillergame.equals("tic tac toe")) {
                      System.out.println("You picked Tic Tac Toe...starting game.");
                       tictactoe.launch();
                      tictactoe.win = scan.nextLine();
                       if (tictactoe.win.equals("yes")) {
                           break;
                       }
                    }else if (fillergame.equals("jeopardy")) {
                          System.out.println( "Taking you to jeopardy type 'yay' to start.");
                          yayresponse = scan.nextLine().toLowerCase().trim();
                          if (yayresponse.equals("yay")){
                          Jeopardy.enter();
                          gui = scan.nextLine().toLowerCase();
                          if (gui.equals("yes") && planPoints == 60 && Jeopardy.access.equals("yes")) {
                              break;
                          }else {
                              continue;
                          }
                          }
                           }
                       }


        if (Progress == 1 && planPoints == 60) {
            Progress++;
            saveprogress();
        }
        if (Progress == 2 && planPoints == 120) {
            Progress++;
            saveprogress();
        }
        if( Progress == 3) {
            System.out.println("\nEnding the game!");
            endgame="yes";
            chooselevel();
        }
    }

















    public static void chooselevel() throws IOException {


        while (Progress == 1) {
            System.out.println("\nWhat level would you like to start with today pick from your options below"
                    +"\nGame:"
                    +"\nLevel 1: Babyshower"
                    +"\nLevel 2: Wedding"
                    +"\nLevel 3: Quincenera"
                    +"\nype in the number of the level of your choosing: ");
                     levelchoice = scan.nextLine();

               if (levelchoice.equals("1")) {
                   Level = 1;
                   PartyPlannerIntros.Babyshower();
                   PartyPlannerLevel1.RockPaperScissors();
                   PartyPlannerLevel1.UnscrambleBabyName();
                   PartyPlannerLevel1.DateGuesser();
                   System.out.println("The status of your points are now: " + planPoints);
                   filler();}

               else if (levelchoice.equals("2")) {
                   Level = 2;
                   PartyPlannerIntros.Wedding();
                   PartyPlannerLevel2.diceGame();
                   PartyPlannerLevel2.Bartender();
                   PartyPlannerLevel2.GuestSeatingGame();
                   filler();}

               else if (levelchoice.equals("3")) {
                   Level = 3;
                   PartyPlannerIntros.Quincenera();
                   PartyPlannerLevel3.Shopping();
                   PartyPlannerLevel3.DJ();
                   PartyPlannerLevel3.BouncerGame();
                   filler();}
              else if (levelchoice.equals("1") || levelchoice.equals("2") || levelchoice.equals("3")) {
                   System.out.println("lets try that again");
                   continue;
              }

        }




        while (Progress == 2 && Level == 1) {//already played level 1
            System.out.println("\nYou've already played Level 1 before."
                    + "\nSo now what level would you like to start with today pick from your options below."
                    +"\nGame:"
                    +"\nLevel 2: Wedding"
                    +"\nLevel 3: Quincenera"
                    +"\nType in the number of the level of your choosing: ");
                     levelchoice = scan.nextLine();

                 if (levelchoice.equals("2")) {

                       Level = 2;
                       PartyPlannerIntros.Wedding();
                       PartyPlannerLevel2.diceGame();
                       PartyPlannerLevel2.Bartender();
                       PartyPlannerLevel2.GuestSeatingGame();
                       lastgame = 3;
                       filler();}
             else if (levelchoice.equals("3")) {

                       Level = 3;
                       PartyPlannerIntros.Quincenera();
                       PartyPlannerLevel3.Shopping();
                       PartyPlannerLevel3.DJ();
                       PartyPlannerLevel3.BouncerGame();
                       lastgame = 2;
                       filler();}
             else if (!levelchoice.equals("2")|| !levelchoice.equals("3")) {
                  System.out.println("try again");
                  continue;

             }
        }



        while (Progress == 2 && Level == 2) {
            System.out.println("\nYou've already played Level 1 before."
                    + "\nSo now what level would you like to start with today pick from your options below."
                    +"\nGame:"
                    +"\nLevel 1: Babyshower"
                    +"\nLevel 3: Quincenera"
                    +"\nType in the number of the level of your choosing: ");
                    levelchoice = scan.nextLine();
                   if (levelchoice.equals("1")) {

                        Level = 1;
                        PartyPlannerIntros.Babyshower();
                         PartyPlannerLevel1.RockPaperScissors();
                         PartyPlannerLevel1.UnscrambleBabyName();
                         PartyPlannerLevel1.DateGuesser();
                         lastgame = 3;
                         filler();}
                    else if (levelchoice.equals("3")) {
                         Level = 3;
                        PartyPlannerIntros.Quincenera();
                        PartyPlannerLevel3.Shopping();
                        PartyPlannerLevel3.DJ();
                        PartyPlannerLevel3.BouncerGame();
                        lastgame = 1;
                        filler();}
                   else if (levelchoice.equals("1") || levelchoice.equals("3")) {
                       System.out.println("lets try that again");
                       continue;

                  }
        }



      while (Progress == 2 && Level == 3) {
            System.out.println("\nYou've already played Level 1 before."
                    + "\nSo now what level would you like to start with today pick from your options below."
                    +"\nGame:"
                    +"\nLevel 1: Babyshower"
                    +"\nLevel 2: Wedding"
                    +"\n You possibly may have already played Level 1 but in this instajnce its up to you to play it again"
                    +"\nType in the number of the level of your choosing: ");
             levelchoice = scan.nextLine();

                  if (levelchoice.equals("1")) {
                       Level = 1;
                       PartyPlannerIntros.Babyshower();
                          PartyPlannerLevel1.RockPaperScissors();
                          PartyPlannerLevel1.UnscrambleBabyName();
                          PartyPlannerLevel1.DateGuesser();
                          lastgame = 2;
                          filler();}
                 else if (levelchoice.equals("2")) {
                      Level = 2;
                      PartyPlannerIntros.Wedding();
                        PartyPlannerLevel2.diceGame();
                        PartyPlannerLevel2.Bartender();
                        PartyPlannerLevel2.GuestSeatingGame();
                      lastgame = 1;
                      filler();}
                 else if (!levelchoice.equals("1") || !levelchoice.equals("2")) {
                      System.out.println("lets try that again");
                      continue;

                 }
        }




      if (Progress == 3 && lastgame == 1) {
          System.out.println("\nYou are now playing your last level."
                  + "\nHere is the last level you have not interatced with yet.");
                    PartyPlannerIntros.Babyshower();
                    PartyPlannerLevel1.RockPaperScissors();
                    PartyPlannerLevel1.UnscrambleBabyName();
                    PartyPlannerLevel1.DateGuesser();
                    PartyPlannerEnding.CloseGame();
                    System.exit(0);}
     if (Progress == 3 && lastgame == 2) {
         System.out.println("\nYou are now playing your last level."
                   + "\nHere is the last level you have not interatced with yet.");
                    PartyPlannerIntros.Wedding();
                    PartyPlannerLevel2.diceGame();
                    PartyPlannerLevel2.Bartender();
                    PartyPlannerLevel2.GuestSeatingGame();
                    PartyPlannerEnding.CloseGame();
                    System.exit(0);}
     if (Progress == 3 && lastgame == 3) {
         System.out.println("\nYou are now playing your last level."
                   + "\nHere is the last level you have not interatced with yet.");
                    PartyPlannerIntros.Quincenera();
                    PartyPlannerLevel3.Shopping();
                    PartyPlannerLevel3.DJ();
                    PartyPlannerLevel3.BouncerGame();
                    PartyPlannerEnding.CloseGame();
                    System.exit(0);}



       if (endgame.equals("yes")) {
           System.out.println(planPoints);
          // FinalPoints =  Round1 + Round2 + Round3;
                PartyPlannerEnding.CloseGame();

        }
    }







    //rachenza
    //introduction to the overall game
    public static void startgames() throws IOException {
        // Game INtro == in future: can change this to reading in from TXT file...
        System.out.println("\nWelcome to your event planning adventure!");
        System.out.println("\nWe need help to plan a variety of events happening around town.");
        System.out.print("\nFirst off, What is your name?");
        String playerName = scan.nextLine(); //user inputs their name
        Name = playerName;
        System.out.println("\nWelcome, " + Name + "! Let's begin your event planning journey.");
        System.out.println("\nYou are tasked with planning events for your local neighborhood");
        System.out.println("\nAs you go along and complete challenges, you will earn 'Planning points'. "
                + "\nEarn enough and you will become the ultimate planner pro!\n");

        chooselevel();
        }


    //finds the users progress and information needed to move them through the game once they log back in
    public static void goingback() throws IOException {
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
        //ArrayList<String> namesf = new ArrayList<String>();

        //File O = new File("Femalenames.txt");

        //Scanner read = new Scanner(O);

        //while (read.hasNextLine()) {
        //String data1 = read.nextLine();
        //namesf.add(data1);
        //}
        //create a variable to hold the randomly picked female names

        String data1 = usersaveprogress.get(index);
        String[] parts = data1.split(", ");
        Name = parts[2];
        Level = Integer.parseInt(parts[3]);
        lastgame = Integer.parseInt(parts[4]);
        Progress = Integer.parseInt(parts[5]);
        planPoints = Integer.parseInt(parts[6]);
        System.out.println("\nWelcome back! " + Name +
        "\nYou left off at Level: " + Level +
        "\nYour Points are " + (planPoints) + "Let's get you back where you left off!");



        chooselevel();
        }else {
        System.out.println("error");}
        //scan.close();
    }



    }