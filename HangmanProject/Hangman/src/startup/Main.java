package startup;

import controller.Controller;
import integration.WordDatabase;
import view.View;

public class Main {
    public static void main(String[] args) {

        WordDatabase wordDatabase = new WordDatabase();
        Controller contr = new Controller(wordDatabase);
        View view = new View(contr);
        // new Frame();
        view.run();
    }

}
