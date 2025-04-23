package Planner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class passwordGame extends JFrame {
    private JPanel mainPanel;
    private JButton colorsBtn, animalsBtn, sportsBtn;
    private JTextField inputField;
    private JTextArea outputArea;
    private JButton submitBtn;
    static passwordGame newgame = new passwordGame();

    private String chosenCategory = "";
    private List<String> passwordList;
    private String password;
    private int attempts = 0;
    private Set<Integer> revealedHints = new HashSet<>();
    private boolean guessedCorrectly = false;

    private final Map<String, List<String>> categories = Map.of(
            "COLORS", List.of("WHITE", "BLACK", "GREEN"),
            "ANIMALS", List.of("PANDA", "CAMEL", "SLOTH", "ZEBRA", "TIGER"),
            "SPORTS", List.of("RUGBY", "DARTS", "BOCCE", "DOGE")
    );

    public void passwordGame() {
        setTitle("Password Cracker");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // buttons
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        JLabel messageLabel = new JLabel("Pick a category! You must try and crack the code.");
        messageLabel.setFont(new Font("Arial", Font.BOLD, 14));
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        topPanel.add(messageLabel);

        // catagory  buttons
        JPanel buttonPanel = new JPanel();
        colorsBtn = new JButton("Colors");
        animalsBtn = new JButton("Animals");
        sportsBtn = new JButton("Sports");

        buttonPanel.add(colorsBtn);
        buttonPanel.add(animalsBtn);
        buttonPanel.add(sportsBtn);
        topPanel.add(buttonPanel);

        mainPanel.add(topPanel, BorderLayout.NORTH);

        outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        inputField = new JTextField(10);
        submitBtn = new JButton("Submit Guess");
        submitBtn.setEnabled(false);

        bottomPanel.add(new JLabel("Enter guess:"));
        bottomPanel.add(inputField);
        bottomPanel.add(submitBtn);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);

        colorsBtn.addActionListener(e -> startGame("COLORS"));
        animalsBtn.addActionListener(e -> startGame("ANIMALS"));
        sportsBtn.addActionListener(e -> startGame("SPORTS"));

        submitBtn.addActionListener(e -> checkGuess());
    }

    private void startGame(String category) {
        outputArea.setText("You've selected: " + category + "\n");
        chosenCategory = category;
        passwordList = categories.get(chosenCategory);
        password = passwordList.get(new Random().nextInt(passwordList.size()));
        attempts = 0;
        revealedHints.clear();
        guessedCorrectly = false;
        submitBtn.setEnabled(true);
        outputArea.append("Guess the 5-letter password.\n");
    }

    private void checkGuess() {
        String guess = inputField.getText().trim().toUpperCase();
        inputField.setText("");

        if (guess.length() != 5) {
            outputArea.append("Guess must be 5 letters long.\n");
            return;
        }

        attempts++;

        if (guess.equals(password)) {
            outputArea.append("Congrats! You guessed the password in " + attempts + " attempts.\n");
            if (PartyPlannerHandle.Progress == 1) {
                PartyPlannerHandle.planPoints = 60;
                JOptionPane.showMessageDialog(null,"Game Over, Type 'Yes' into console");
                mainPanel.setVisible(false);}
            else if (PartyPlannerHandle.Progress == 2) {
                PartyPlannerHandle.planPoints = 120;
                JOptionPane.showMessageDialog(null," Game Over, Type 'Yes' into console");
                mainPanel.setVisible(false);;
            }
            submitBtn.setEnabled(false);
            return;
        }

        outputArea.append("Incorrect. Checking your guess...\n");
        boolean anyCorrect = false;

        for (int i = 0; i < 5; i++) {
            if (guess.charAt(i) == password.charAt(i)) {
                outputArea.append( guess.charAt(i) + "' is correct at position " + (i + 1) + "\n");
                anyCorrect = true;
            }
        }

        if (!anyCorrect) {
            outputArea.append("No letters are in the correct position.\n");
        }

        if (attempts % 3 == 0) {
            giveHint();
        }

        if (attempts == 10) {
            outputArea.append("Max attempts reached. A new password has been chosen!\n");
            password = passwordList.get(new Random().nextInt(passwordList.size()));
            attempts = 0;
            revealedHints.clear();
        }
    }

    private void giveHint() {
        for (int i = 0; i < 5; i++) {
            if (!revealedHints.contains(i)) {
                outputArea.append("Hint... Letter " + (i + 1) + " is '" + password.charAt(i) + "'\n");
                revealedHints.add(i);
                break;
            }
        }
    }
    
    public static void start () {
    	 newgame.passwordGame();
    }

    public static void main(String[] args) {
       start();
    }
}
