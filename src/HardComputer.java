import javax.swing.*;

/**
 * Created by young on 6/21/17.
 */
public class HardComputer extends Computer {

    private String computerChoice;
    private JButton[] buttons;

    public HardComputer() {
        this.computerChoice = this.getComputerChoice();
        this.buttons = this.getButtons();
    }

    public void makeMove() {

    }
}
