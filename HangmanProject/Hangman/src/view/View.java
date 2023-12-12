package view;

import java.io.FileNotFoundException;
import java.util.Arrays;

import javax.swing.JOptionPane;

import controller.Controller;
import integration.LetterAlreadyEnteredException;

public class View {

    private Controller contr;

    public View(Controller contr) {
        this.contr = contr;
    }

    public void run() {
        try {
            contr.startNewGame();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null,
                "A new game has started and a new word has been generated");

        while (!contr.gameLost()) {
            String strGuess = JOptionPane.showInputDialog(null, "Enter the letter");

            while (strGuess.length() != 1 || Character.isDigit(strGuess.charAt(0))) {
                strGuess = JOptionPane.showInputDialog(null, "Error try again");
            }

            char guess = strGuess.charAt(0);
            try {
                // JOptionPane.showMessageDialog(null,
                // Arrays.toString(contr.enterGuess(guess)));
                System.out.println(Arrays.toString(contr.enterGuess(guess)));
                System.out.println();
            } catch (LetterAlreadyEnteredException e) {
                System.out.println();
                System.out.println("The letter is already entered");
            }

            if (contr.gameLost()) {
                System.out.println("You lost bitch!");
                System.out.println("The word was " + contr.getWord());
            }

            if (contr.gameWon()) {
                System.out.println("You won");
                break;
            }

            System.out.println("Your wrong guesses: " + contr.getGuesses());

        }
    }
}
