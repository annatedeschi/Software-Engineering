package Planner;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Jeopardy implements ActionListener  {
	JTextField TextField;
	String correcta;
	int acount=0;
	String currentq;
	Clip clip1;
	Clip clip2;
	Clip clip3;
	String useranswer;
	JFrame frame1;
	JFrame frame2;
	JFrame frame3;
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	
	
	static JButton button1;
	static JButton[] button2 = new JButton[9];
	static JButton button3;
	static int count = 0;
	static int money;
	static int payment;
	static String [] questions;
	static int a;
	static int i;
	static String access;
	static ArrayList<String> answered;
	JLabel questionlabel = new JLabel();
	
	String[] q100 = {"100 For Best Event Planner: If your client wants to do a firework show inside the venue. Type your answer below: (Firework Show/No Firework Show)","100 For Best Event Planner: Your client wants you to go big but their budget says go small. Type your answer below: (Drop Client/Go Big Charge Later)","100 For Best Event Planner: Your client is having cold feet on their big day they are contemplating being a runaway bride but need your support. Type answer below: (Runaway Bride/Convince Them So You Get Paid)","100 For Best Event Planner: Your client's water breaks at their babyshower. They need to go to the hospital in the middle of the party. Type your answer below: (Continue The Party/Shut It Down Send Everyone Home)"};
	String[] q200 = {"200 For Movies: A kid is left behind by his family during the holidays give this to.....? Type your answer below: (Kevin/James)","A teenage girl falls in love with two non-human beings and somehow one of them hates the sun. Type your answer below: (Twilight/Pitch Perfect)","200 For Movies: A group of girls who could never not wear pink on a wednesday but love to write in their burn book. Type your answer below: (Mean Girls/Clueless","200 For Movies: She's off shes a little psychotic and her uncle is a hand shes.... Type Your Answer Below: (Wednesday/Thursday)"};
	String[] q300 = {"300 For Tv Shows: A core childhood show where there are 104 days of summer vaction yet the summer never ends. Type your answer below: (Phineas and Ferb/Johnny10)","300 For Tv Shows: A show where two brothers fight over one girl all while fighting vervain. Type your answer below: (The Vampire Diaries/The Orignals","300 For Tv Shows: A hospital where evertghing that could go wrong goes wrong but at least we have McDreamy. Type answer below: (Greys Anatomy/The Good Doctor","300 For TV Show: This show loves stacking food on sticks from donuts to spaghetti its... Type Your Answer Below: (ICarly)/Victorious"};
	

	 public static void main(String[] args) {
		 enter();
	 }
	
	 public static void enter () {
		 System.out.println("You will be answering some questions based on your pick of the price you want."
		 		+ " You only will answer three questions.");
		 Jeopardy jeopardy = new Jeopardy();
			jeopardy.reset();
	 }
	 public void reset() {
		    count = 0;
		    money = 0;
		    payment = 0;
		    acount = 0;
		    useranswer = "";
		    currentq = "";
		    questions = null;
		    answered = new ArrayList<>();
		    

		    Intro(); 
		}
	 
	 public  void Intro () {
		 frame1 = new JFrame();
		 frame1.setSize(300,150);
		 frame1.setLayout(new BorderLayout(10, 10));
		 panel1 = new JPanel(new BorderLayout());
		 JLabel welcome = new JLabel("Welcome To Jeopardy", JLabel.CENTER);
		 panel1.add(welcome, BorderLayout.CENTER);
		 button1 =new JButton("Next");
		 button1.addActionListener(this);
		 panel1.add(button1, BorderLayout.SOUTH);
		 frame1.add(panel1, BorderLayout.CENTER);
		 frame1.setVisible(true);

		
	 }
	 public void test () {
		frame2 = new JFrame();
		frame2.setTitle("Jeopardy");
		frame2.setSize(800, 500);
		
		 panel2 = new JPanel(new GridLayout(3 , 3, 9, 9));
		
		for ( i = 0; i < 9; i++) {
			String price;
			if ( i < 3) {
		     price = "$100";
			}else if (i < 6) {
		      price = "$200";
			}else {
		      price = "$300";
			}
			button2[i] = new JButton(price);
			button2[i].addActionListener(this);
			panel2.add(button2[i]);
		}
		frame2.add(panel2);
		frame2.pack();
		frame2.setVisible(true);
		
		
		 
	 }
	 
	public void answer (String questionselected) {
		currentq = questionselected;
		frame3 = new JFrame();
		frame3.setSize(1500,1500);
		frame3.setLayout(new BorderLayout(10, 10));
		questionlabel = new JLabel(questionselected, JLabel.CENTER);
		frame3.add(questionlabel, BorderLayout.NORTH);
		panel3 = new JPanel();
		JLabel label = new JLabel("Enter your answer");
		TextField = new JTextField(20);
	    button3 = new JButton("Enter");
		button3.addActionListener(this);
		panel3.add(label);
		panel3.add(TextField);
		panel3.add(button3);
		frame3.add(panel3, BorderLayout.CENTER);
		frame3.setVisible(true);
		
		
	}
		
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object buttons = e.getSource();
		if(buttons == button1) {
			test();
			try {
				playsound();
				clip1.start();
			}catch (Exception ex) {
		        ex.printStackTrace();
		    }
		}else if (buttons == button3) {
		  useranswer = TextField.getText().toLowerCase();
		  check();
        }else {
        	for ( a = 0; a <button2.length; a++) {
        		if (buttons == button2[a]) {
        		if(clip1 != null && clip1.isRunning()) {
        			clip1.stop();
        			}
        			if (count < 3) {
        				button2[a].setEnabled(false);
        				count++;
        				
        				String questionselected = randomq(button2[a].getText());
        				answer(questionselected);
        			}else if (count == 3){
        				JOptionPane.showMessageDialog(null, "Game over You have earned " + "$" + money);
        				panel2.setVisible(false);
        				panel3.setVisible(false);
        				panel1.setVisible(false);
        				frame1.dispose();
        				frame2.dispose();
        				frame3.dispose();
        				
        				if (money > 200) {
        				    if (PartyPlannerHandle.Progress == 1) {
        				        PartyPlannerHandle.planPoints = 60;
        				        access = "yes";
        				        
        				        
        				    } else if (PartyPlannerHandle.Progress == 2) {
        				        PartyPlannerHandle.planPoints = 120;
        				        access = "yes";
        				        
        				   
        				    }
        				}	
        				if (money < 200) {
        					reset();
        				}
        		}
        	}
	    }
     }
  }
       



public String randomq(String price) {
    questions = null;
	switch (price) {
	case "$100":
		questions = q100;
		break;
	case "$200":
		questions = q200;
		break;
	case "$300":
		questions = q300;
		break;
	}
	int randomizer = (int)(Math.random() * questions.length);
	return questions[randomizer];
	}


	

	public void check() {
	       if (currentq.contains("Twilight") && !answered.contains(currentq)) {
		        correcta = "twilight";
		        payment = 200;
		        answered.add(currentq);
		    } else if (currentq.contains("No Firework Show") && !answered.contains(currentq)) {
		        correcta = "no firework show";
		        payment = 100;
		        answered.add(currentq);
		    } else if (currentq.contains("Phineas and Ferb") && !answered.contains(currentq)) {
		        correcta = "phineas and ferb";
		        payment = 300;
		        answered.add(currentq);
		    } else if (currentq.contains("Kevin") && !answered.contains(currentq)) {
		        correcta = "kevin";
		        payment = 200;
		        answered.add(currentq);
		    } else if (currentq.contains("The Vampire Diaries") && !answered.contains(currentq)) {
		        correcta = "the vampire diaries";
		        payment = 300;
		        answered.add(currentq);
		    }else if (currentq.contains("Greys Anatomy") && !answered.contains(currentq)) {
		    	correcta = "greys anatomy";
		    	payment = 300;
		    	answered.add(currentq);
		    }else if (currentq.contains("Mean Girls") && !answered.contains(currentq)) {
		    	correcta = "mean girls";
		    	payment = 200;
		    	answered.add(currentq);
		    }else if (currentq.contains("Drop Client") && !answered.contains(currentq)) {
		    	correcta = "drop client";
		    	payment = 100;	
		    	answered.add(currentq);
		    }else if (currentq.contains("Convince Them So You Get Paid") && !answered.contains(currentq)) {
		    	correcta = "convince them so you get paid";
	            payment = 100;
	            answered.add(currentq);
		    }else if (currentq.contains("Continue The Party") && !answered.contains(currentq)) {
			    correcta = "continue the party";
		        payment = 100;
		        answered.add(currentq);
		    }else if (currentq.contains("Wednesday") && !answered.contains(currentq)) {
				correcta = "wednesday";
			    payment = 200;
			    answered.add(currentq);
		    }else if (currentq.contains("ICarly") && !answered.contains(currentq)) {
					correcta = "icarly";
				    payment = 100;
				    answered.add(currentq);}
			    
		            
	      
	       

		    if (useranswer.equals(correcta)) {
		    	clip2.setFramePosition(0);
		        clip2.start();
		        JOptionPane.showMessageDialog(null, "That Is Correct!!");
		        money +=payment;
		        acount++;
		        panel3.setVisible(false);
		        clip1.setFramePosition(0);
		        clip1.start();
		    } 
		    if (!useranswer.equals(correcta)) {
		    	clip3.setFramePosition(0);
		        clip3.start();
		        JOptionPane.showMessageDialog(null, "That Is Incorrect!");
		        money -=payment;
		        panel3.setVisible(false);
		        clip1.setFramePosition(0);
		        clip1.start();
		    }

		    if (frame3 != null) {
		        frame3.dispose(); // Dispose after user clicks OK
		    }

		    // Stop clips after dialog is shown
		    if (clip2 != null && clip2.isRunning()) {
		        clip2.stop();
		    }
		    if (clip3 != null && clip3.isRunning()) {
		        clip3.stop();
		    }
		    JOptionPane.showMessageDialog(null, "Press ok and select the red exit button to choose your next question.");
		}

public void playsound () throws UnsupportedAudioFileException, IOException, LineUnavailableException {
	File sound1 = new File("themesong.wav");
	if (sound1.exists()) {
		AudioInputStream audio1 = AudioSystem.getAudioInputStream(sound1);
	    clip1 = AudioSystem.getClip();
		clip1.open(audio1);
	}else {
		System.out.println("File not found");
		
	}
	File sound2 = new File("Applause.wav");
	if (sound2.exists()) {
		AudioInputStream audio2 = AudioSystem.getAudioInputStream(sound2);
	    clip2 = AudioSystem.getClip();
		clip2.open(audio2);
	}else {
		System.out.println("File not found");
		
	}
	File sound3 = new File("Buzzer.wav");
	if (sound3.exists()) {
		AudioInputStream audio3 = AudioSystem.getAudioInputStream(sound3);
	    clip3 = AudioSystem.getClip();
		clip3.open(audio3);
	}else {
		System.out.println("File not found");
		
	}
}

}
	