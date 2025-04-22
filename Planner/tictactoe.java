package Planner;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Random;
//main class for tic tac toe
public class tictactoe extends Frame implements ActionListener {
// setting the buttons
	static tictactoe newgame = new tictactoe();
    public  Button[] buttons = new Button[9];
    public char[] board = {'1','2','3','4','5','6','7','8','9'};
    public int moves = 0;
    public Label statusLabel;
    public Random rand = new Random();
    public int playerWins = 0;
    public int computerWins = 0;
    public static String win;
// the title, squares , and layout specs
    public void tictactoe() {
        setTitle("Tic Tac Toe - Best of 3");
        setLayout(new BorderLayout());
// setting the panel board, fonts and buttons
        Panel boardPanel = new Panel();
        boardPanel.setLayout(new GridLayout(3, 3));
        Font font = new Font("Arial", Font.BOLD, 40);

        for (int i = 0; i < 9; i++) {
            buttons[i] = new Button("");
            buttons[i].setFont(font);
            buttons[i].addActionListener(this);
            boardPanel.add(buttons[i]);
        }

        statusLabel = new Label("Your move!", Label.CENTER);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        add(boardPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        setSize(300, 350);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }
// this is button getting pressed and marking it on the board
    @Override
    public void actionPerformed(ActionEvent e) {
        Button clicked = (Button) e.getSource();
        int index = -1;

        for (int i = 0; i < 9; i++) {
            if (clicked == buttons[i]) {
                index = i;
                break;
            }
        }

        if (index == -1 || !buttons[index].getLabel().equals("")) return;

        buttons[index].setLabel("X");
        board[index] = 'x';
        moves++;
// checking the wins , best of three and then reset
        if (checkWin('x')) {
            playerWins++;
            statusLabel.setText("You win this round!");
            if (playerWins == 2) {
                statusLabel.setText("You win best of 3!");
                awardPoints();
            } else {
                resetBoard("You won this round! Score: You " + playerWins + " - " + computerWins);
            }
            return;
        }

        if (moves == 9) {
            statusLabel.setText("It's a tie!");
            resetBoard("It's a tie! Score: You " + playerWins + " - " + computerWins);
            return;
        }

        try {
            computerMove();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
// this is the computers turn , honest havent been beaten by the computer yet sooo might have to go back 
    private void computerMove() throws IOException {
        statusLabel.setText("Computer's turn...");
        int compSpot;
        while (true) {
            compSpot = rand.nextInt(9);
            if (board[compSpot] != 'x' && board[compSpot] != 'o') {
                board[compSpot] = 'o';
                buttons[compSpot].setLabel("O");
                moves++;
                break;
            }
        }
        // checking if the computer wins , computer ALWAYS O and User is always x (maybe change this?)
        if (checkWin('o')) {
            computerWins++;
            statusLabel.setText("Computer wins this round!");
            if (computerWins == 2) {
                statusLabel.setText("Computer wins best of 3!");
                newgame.tictactoe();
            } else {
                resetBoard("Computer won this round! Score: You " + playerWins + " - " + computerWins);
            }
        } else if (moves == 9) {
            statusLabel.setText("It's a tie!");
            resetBoard("It's a tie! Score: You " + playerWins + " - " + computerWins);
        } else {
            statusLabel.setText("Your move!");
        }
    }
// resetting the board so we can play best of 3
    private void resetBoard(String message) {
        for (int i = 0; i < 9; i++) {
            board[i] = (char) ('1' + i);
            buttons[i].setLabel("");
            buttons[i].setEnabled(true);
        }
        moves = 0;
        statusLabel.setText(message);
    }

// closing out of the board
    private void disableBoard() {
        for (Button b : buttons) {
            b.setEnabled(false);
        }
    }
// checking the win
    private boolean checkWin(char p) {
        return (board[0] == p && board[1] == p && board[2] == p) ||
               (board[3] == p && board[4] == p && board[5] == p) ||
               (board[6] == p && board[7] == p && board[8] == p) ||
               (board[0] == p && board[3] == p && board[6] == p) ||
               (board[1] == p && board[4] == p && board[7] == p) ||
               (board[2] == p && board[5] == p && board[8] == p) ||
               (board[0] == p && board[4] == p && board[8] == p) ||
               (board[2] == p && board[4] == p && board[6] == p);
    }
// awarding the points to the user
    private void awardPoints() {
        if (PartyPlannerHandle.Progress == 1) {
            PartyPlannerHandle.planPoints = 60;
            
        disableBoard();}
        else if (PartyPlannerHandle.Progress == 2) {
            PartyPlannerHandle.planPoints = 120;
            disableBoard();
        }
        System.out.println("Points: " + PartyPlannerHandle.planPoints);
    }
//launching the gamee
    public static void launch() {
    	newgame.tictactoe();
    }
    public static void main(String[] args) {
    	 launch();
          
    }
}