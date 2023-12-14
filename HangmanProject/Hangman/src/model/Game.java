package model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import controller.Controller;
import integration.LetterAlreadyEnteredException;

public class Game {

    private Controller contr;

    private Word word;

    private Hangman hangman;

    private int wrongGuesses = 1;

    public Game() throws FileNotFoundException {
        hangman = new Hangman();
        word = new Word();
        hangman.printHangman();
    }

    public String getWord() {
        return word.getWord();
    }

    public char[] enterGuess(char letter) throws LetterAlreadyEnteredException {

        if (word.getGuessedLetters().contains(letter)) {
            word.getGuessedLetters().add(letter);
            hangman.printHangman();
            throw new LetterAlreadyEnteredException(letter);
        }

        else if (wordContains(letter)) {
            word.getGuessedLetters().add(letter);
            word.foundLetters(letter);
            hangman.printHangman();
            return word.getHiddenWord();
        }

        else if (gameWon()) {
            System.out.println("WON");
            return word.getWord().toCharArray();
        }

        else {
            word.getGuessedLetters().add(letter);
            word.getWrongGuessedLetters().add(letter);
            hangman.strike(wrongGuesses);
            hangman.printHangman();
            wrongGuesses++;
            return word.getHiddenWord();
        }

    }

    public boolean gameLost() {
        if (wrongGuesses == 8)
            return true;
        return false;
    }

    public boolean gameWon() {

        if (Arrays.toString(word.hiddenWord).equals(Arrays.toString(word.getWord().toCharArray())))
            return true;
        return false;
    }

    public ArrayList<Character> getWrongGuessedLetters() {
        return word.getWrongGuessedLetters();
    }

    private boolean wordContains(char letter) {
        for (int i = 0; i < word.getWord().length(); i++) {
            if (word.getWord().charAt(i) == letter) {
                return true;
            }
        }
        return false;
    }

    public String getCurrentWordState() {
        StringBuilder displayedWord = new StringBuilder();
        for (char letter : word.getWord().toCharArray()) {
            if (word.getGuessedLetters().contains(letter)) {
                displayedWord.append(letter);
            } else {
                displayedWord.append('-');
            }
        }
        return displayedWord.toString();
    }

    public String getHangmanState() {
        return hangman.getHangman();
    }
}
