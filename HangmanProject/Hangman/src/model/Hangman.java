package model;

public class Hangman {

    private String[][] hangman = new String[10][10];

    public Hangman() {
        baseCreator();
        frameCreator();
    }

    public void strike(int guess) {
        if (guess == 1)
            hangman[3][8] = "O";
        else if (guess == 2) {
            hangman[4][8] = "|";
            hangman[5][8] = "|";
        } else if (guess == 3)
            hangman[4][7] = "/";
        else if (guess == 4)
            hangman[4][9] = "\\";
        else if (guess == 5)
            hangman[6][7] = "/";
        else if (guess == 6)
            hangman[6][9] = "\\";
        else if (guess == 7)
            hangman[6][8] = "'";

    }

    public void printHangman() {
        for (int i = 0; i < hangman.length; i++) {
            System.out.println();
            for (int j = 0; j < hangman[0].length; j++) {
                System.out.print(hangman[i][j]);
            }
        }
        System.out.println();
        System.out.println();
    }

    private void baseCreator() {
        for (int i = 0; i < hangman.length; i++) {
            hangman[i][0] = " ";
            for (int j = 1; j < hangman[0].length; j++) {
                hangman[i][j] = " ";
            }
        }
    }

    private void frameCreator() {
        for (int i = 1; i < hangman.length; i++) {
            hangman[i][0] = "|";
            for (int j = 1; j < hangman[0].length; j++) {
                hangman[9][j] = "_ ";
            }
        }

        for (int i = 1; i < 5; i++) {
            hangman[0][i] = "_ ";
        }

        for (int i = 1; i < 3; i++) {
            hangman[i][8] = "|";
        }

    }

}
