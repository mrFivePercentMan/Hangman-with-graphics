package integration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordDatabase {

    private String wordToGuess;

    private File words = new File("ordlista.txt");

    private ArrayList<String> wordList = new ArrayList<>();

    public String getWord() throws FileNotFoundException {
        readWords();
        try (Scanner scan = new Scanner(words)) {
            wordToGuess = wordList.get((int) (Math.random() * wordList.size()));
        }

        return wordToGuess;
    }

    private void readWords() {
        Scanner scan;
        try {
            scan = new Scanner(words);
            while (scan.hasNextLine()) {
                wordList.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
