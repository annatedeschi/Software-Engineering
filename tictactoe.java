package Planner;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class tictactoe extends Frame implements ActionListener {

    private Button[] buttons = new Button[9];
    private char[] board = {'1','2','3','4','5','6','7','8','9'};
    private int moves = 0;
    private Label statusLabel;
    private Random rand = new Random();

    public tictactoe() {
        setTitle("Tic Tac Toe ");
        setLayout(new BorderLayout());

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

        if (checkWin('x')) {
            statusLabel.setText("You win!");
            awardPoints();
            PartyPlannerHandle.filler();
            disableBoard();
            return;
        }

        if (moves == 9) {
            statusLabel.setText("It's a tie!");
            PartyPlannerHandle.filler();
            disableBoard();
            return;
        }

        computerMove();
    }

    private void computerMove() {
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

        if (checkWin('o')) {
            statusLabel.setText("Computer wins!");
            PartyPlannerHandle.filler();
            disableBoard();
        } else if (moves == 9) {
            statusLabel.setText("It's a tie!");
            PartyPlannerHandle.filler();
            disableBoard();
        } else {
            statusLabel.setText("Your move!");
        }
    }

    private void disableBoard() {
        for (Button b : buttons) {
            b.setEnabled(false);
        }
    }

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

    private void awardPoints() {
        if (PartyPlannerHandle.Progress == 1) {
            PartyPlannerHandle.planPoints = 60;
        } else if (PartyPlannerHandle.Progress == 2) {
            PartyPlannerHandle.planPoints = 120;
        }
        System.out.println("Points: " + PartyPlannerHandle.planPoints);
    }


    public static void main(String[] args) {
        tictactoe.launch();
    }
}
