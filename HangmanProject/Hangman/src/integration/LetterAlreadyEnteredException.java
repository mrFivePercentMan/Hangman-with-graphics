package integration;

public class LetterAlreadyEnteredException extends Exception {

    public LetterAlreadyEnteredException(char letter) {
        super("The letter " + letter + " is already entered");
    }

}
