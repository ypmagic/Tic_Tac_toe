import javax.swing.*;

/**
 * Created by young on 6/21/17.
 */
public class HardComputer extends Computer {

    private String computerChoice;
    private JButton[] buttons;

    public HardComputer(String computerChoice, JButton[] buttons) {
        this.computerChoice = computerChoice;
        this.buttons = buttons;
    }

    public void makeMove() {

    }
}
