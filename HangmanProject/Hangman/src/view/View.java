package view;

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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error starting the game: " + e.getMessage());
            return;
        }

        while (!contr.gameLost() && !contr.gameWon()) {
            String gameStatus = buildGameStatus();
            String strGuess = JOptionPane.showInputDialog(null, gameStatus);
            if (strGuess == null) {
                System.exit(0);
            }

            if (strGuess == null || strGuess.isEmpty() || strGuess.length() != 1
                    || Character.isDigit(strGuess.charAt(0))) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a letter.");
                continue;
            }

            try {
                contr.enterGuess(strGuess.charAt(0));
            } catch (LetterAlreadyEnteredException e) {
                JOptionPane.showMessageDialog(null, "The letter '" + strGuess + "' is already entered.");
            }
        }

        String finalMessage = contr.gameWon() ? "You won!\nThe word was: " + contr.getWord()
                : "You lost!\nThe word was: " + contr.getWord();
        JOptionPane.showMessageDialog(null, finalMessage);
    }

    private String buildGameStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append(contr.getHangmanState());
        sb.append("\nThe word: ");
        sb.append(getDisplayWord());
        sb.append("\nWrong Guesses: ");
        sb.append(contr.getGuesses().toString());
        return sb.toString();
    }

    private String getDisplayWord() {

        return contr.getCurrentWordState();
    }
}
