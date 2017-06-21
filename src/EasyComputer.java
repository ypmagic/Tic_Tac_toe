import javax.swing.*;
import java.util.Random;

/**
 * Created by young on 6/21/17.
 */
public class EasyComputer extends Computer {

    private String computerChoice;
    private JButton[] buttons;

    public EasyComputer() {
        this.computerChoice = this.getComputerChoice();
        this.buttons = this.getButtons();
    }

    public void makeMove() {
        Random randomizer = new Random();
        int random = randomizer.nextInt(9);
        boolean keepGoing = true;
        while (keepGoing) {
            if (!this.buttons[random].getText().equals("")) {
                random = randomizer.nextInt(9);
            } else {
                keepGoing = false;
            }
        }
        this.buttons[random].setText(computerChoice);
    }

}
