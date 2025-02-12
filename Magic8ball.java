import java.io.File;  //  all things related with working with files 
import java.io.FileNotFoundException;  // exception for when the file is not found 
import java.util.ArrayList;//resizeable array 
import java.util.Scanner; // reading input from user and from files 



public class Magic8ball {//declaring my class same name as my file 
  public static void main(String[] args) {//entry point for where the program starts 
   
    try {//catches errors during excution 

        System.out.println("Magic 8 Ball\n");//Prints a opening message to the user

        ArrayList<String> answers = new ArrayList<String>();//creating my array list

        File O = new File("magic8ballresponses.txt");//a file object called O pointing to the file with the responses

        Scanner read = new Scanner(O);//Scanner object called read to read from file called O

      while (read.hasNextLine()) {//loops through each line in the file and checks if next line exist 
       
        String data = read.nextLine();//reads the current line one by one from the file 

        answers.add(data);// add the line to my array 

      
       
      
      
       
       
      }
      read.close();  // close file reader

      //testers!! Prof Caroll
      System.out.println(answers);//prints all of the array called answers to the console 

      System.out.println(answers.size());//prints the size of my array called answers (the number of lines)
       // testers over!!

      int random = (int)(Math.random()* answers.size());//range of random numbers from 0-the size of my array set it to a variable called randomn 
     
      
      Scanner scan = new Scanner(System.in);//read input from user in console
      
  

      

      System.out.println("Ask a yes or no question and i will give you the answer:\n ");

      String input = scan.nextLine();//reads user input as a string and store in variable input 

      if (!input.equals("")){//if the user did not leave the console blank
        //can use !input.isEmpty()){} as well
        System.out.println(answers.get(random));//generate a random response from the file using my random variable
      }
       
       

      System.out.println("Would you like to ask another question or quit? Type lower yes or no");

       String input2 = scan.nextLine();//reads user input as a string and store in variable input2 due to it being a different group of responses from user
      

      while (!input2.equals("no")) { //while input 2 does not equal no
              System.out.println("What is your next yes or no question?");//ask what the next question is
              input2 = scan.nextLine();//read the user input and store it in variable input2
              System.out.println(answers.get(random));  // Print the random answer
             // System.out.println("Would you like to ask another question or quit? Type 'yes' or 'no'");
              //input = scan.nextLine();//read in the response

          } 

            
          
          scan.close();
        
      
    

     
     
      
      
      

      
     //helps with errors
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

  }

}
     
      
      

  

