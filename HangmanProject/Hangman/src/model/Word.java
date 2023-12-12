package model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import integration.WordDatabase;

public class Word {

    private WordDatabase wordDatabase;

    private String word;

    char[] hiddenWord;

    ArrayList<Character> userGuess = new ArrayList<>();

    private ArrayList<Character> guessedLetters = new ArrayList<>();

    private ArrayList<Character> wrongGuessedLetters = new ArrayList<>();

    public Word() throws FileNotFoundException {
        wordDatabase = new WordDatabase();
        generateWord();
    }

    public void foundLetters(char letter) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                hiddenWord[i] = word.charAt(i);
            }
        }
    }

    public String getWord() {
        return word;
    }

    public ArrayList<Character> getGuessedLetters() {
        return guessedLetters;
    }

    public ArrayList<Character> getWrongGuessedLetters() {
        return wrongGuessedLetters;
    }

    public char[] getHiddenWord() {
        return hiddenWord;
    }

    public boolean equals(Object obj) {
        Word word = (Word) obj;

        if (this.word.equals(word.getWord()))
            return true;
        return false;
    }

    public String toString() {
        return word.toString();
    }

    private void generateWord() throws FileNotFoundException {
        word = wordDatabase.getWord();
        hiddenWord = new char[word.length()];

        for (int i = 0; i < hiddenWord.length; i++) {
            hiddenWord[i] = '_';
        }
    }
}
