package controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import integration.LetterAlreadyEnteredException;
import integration.WordDatabase;
import model.Game;

public class Controller {

    private WordDatabase wordDatabase;

    public Controller(WordDatabase wordDatabase) {
        this.wordDatabase = wordDatabase;
    }

    private Game game;

    /**
     * Starts the game.
     * 
     * @throws FileNotFoundException
     */
    public void startNewGame() throws FileNotFoundException {
        game = new Game();
    }

    public char[] enterGuess(char letter) throws LetterAlreadyEnteredException {
        return game.enterGuess(letter);
    }

    public boolean gameLost() {
        return game.gameLost();
    }

    public boolean gameWon() {
        return game.gameWon();
    }

    public ArrayList<Character> getGuesses() {
        return game.getWrongGuessedLetters();
    }

    public String getWord() {
        return game.getWord();
    }

}
