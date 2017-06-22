import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by young on 6/21/17.
 */
public class Interface {

    private JFrame frame;
    private JPanel grid;
    private JPanel north;
    private JLabel status;
    // the buttons for grid
    private JButton[] buttons;
    private ArrayList<Integer> usedNums;
    // player's choice O or X... O = true, X = false
    private String playerChoice;
    private String computerChoice;
    // the computer
    private Computer c;

    public Interface() {
        this.grid = new JPanel(new GridLayout(3, 3));
        this.grid.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        this.usedNums = new ArrayList<Integer>();
        this.buttons = new JButton[9];
        for (int i = 0; i < this.buttons.length; i++) {
            this.buttons[i] = new JButton("");
            this.buttons[i].setPreferredSize(new Dimension(100, 100));
            this.buttons[i].setEnabled(false);
            final int temp = i;
            this.buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    checkWin();
                    // check before player move
                    if (!buttons[temp].getText().equals("") || buttons[temp].getText().equals(computerChoice)) {
                        status.setText("You selected an already selected button!");
                    } else {
                        buttons[temp].setText(playerChoice);
                        usedNums.add(temp);
                    }
                    // check after player move
                    checkWin();
                    c.makeMove();

                }
            });
            this.grid.add(this.buttons[i]);
        }

        this.status = new JLabel("Welcome to Tic Tac Toe! Choose O or X", SwingConstants.CENTER);

        JButton easy = new JButton("Easy");
        easy.setVisible(false);
        JButton hard = new JButton("Hard");
        hard.setVisible(false);
        hard.setEnabled(false);
        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c = new EasyComputer(computerChoice, buttons);
                easy.setVisible(false);
                hard.setVisible(false);
                for (int j = 0; j < buttons.length; j++) {
                    buttons[j].setEnabled(true);
                }
            }
        });
        hard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c = new HardComputer(computerChoice, buttons);
                easy.setVisible(false);
                hard.setVisible(false);
                for (int j = 0; j < buttons.length; j++) {
                    buttons[j].setEnabled(true);
                }
            }
        });

        JButton o = new JButton("O");
        o.setFont(new Font("Sans Serif", Font.BOLD, 16));
        JButton x = new JButton("X");
        x.setFont(new Font("Sans Serif", Font.BOLD, 16));
        o.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerChoice = "O";
                computerChoice = "X";
                o.setVisible(false);
                x.setVisible(false);
                status.setText("Pick your computer difficulty");
                easy.setVisible(true);
                hard.setVisible(true);
            }
        });
        x.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerChoice = "X";
                computerChoice = "O";
                o.setVisible(false);
                x.setVisible(false);
                status.setText("Pick your computer difficulty");
                easy.setVisible(true);
                hard.setVisible(true);
            }
        });

        JPanel temp = new JPanel();
        temp.add(o);
        temp.add(x);
        temp.add(easy);
        temp.add(hard);

        this.north = new JPanel(new BorderLayout());
        this.north.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.north.add(this.status, BorderLayout.NORTH);
        this.north.add(temp, BorderLayout.SOUTH);

        this.frame = new JFrame("Tic Tac Toe");
        this.frame.setLayout(new BorderLayout(0, 5));
        this.frame.add(this.grid, BorderLayout.SOUTH);
        this.frame.add(this.north, BorderLayout.NORTH);
        this.frame.pack();
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

    private void checkWin() {
        // player win check
        if (this.buttons[0].getText().equals(this.buttons[3].getText().equals(this.buttons[6].getText().equals(playerChoice)))) {
            status.setText("PLAYER WINS!");
        } else if (this.buttons[1].getText().equals(this.buttons[4].getText().equals(this.buttons[7].getText().equals(playerChoice)))) {
            status.setText("PLAYER WINS!");
        } else if (this.buttons[2].getText().equals(this.buttons[5].getText().equals(this.buttons[8].getText().equals(playerChoice)))) {
            status.setText("PLAYER WINS!");
        } else if (this.buttons[0].getText().equals(this.buttons[1].getText().equals(this.buttons[2].getText().equals(playerChoice)))) {
            status.setText("PLAYER WINS!");
        } else if (this.buttons[3].getText().equals(this.buttons[4].getText().equals(this.buttons[5].getText().equals(playerChoice)))) {
            status.setText("PLAYER WINS!");
        } else if (this.buttons[6].getText().equals(this.buttons[7].getText().equals(this.buttons[8].getText().equals(playerChoice)))) {
            status.setText("PLAYER WINS!");
        } else if (this.buttons[2].getText().equals(this.buttons[4].getText().equals(this.buttons[6].getText().equals(playerChoice)))) {
            status.setText("PLAYER WINS!");
        } else if (this.buttons[0].getText().equals(this.buttons[4].getText().equals(this.buttons[8].getText().equals(playerChoice)))) {
            status.setText("PLAYER WINS!"); // computer win check
        } else if (this.buttons[0].getText().equals(this.buttons[3].getText().equals(this.buttons[6].getText().equals(computerChoice)))) {
            status.setText("COMPUTER WINS!");
        } else if (this.buttons[1].getText().equals(this.buttons[4].getText().equals(this.buttons[7].getText().equals(computerChoice)))) {
            status.setText("COMPUTER WINS!");
        } else if (this.buttons[2].getText().equals(this.buttons[5].getText().equals(this.buttons[8].getText().equals(computerChoice)))) {
            status.setText("COMPUTER WINS!");
        } else if (this.buttons[0].getText().equals(this.buttons[1].getText().equals(this.buttons[2].getText().equals(computerChoice)))) {
            status.setText("COMPUTER WINS!");
        } else if (this.buttons[3].getText().equals(this.buttons[4].getText().equals(this.buttons[5].getText().equals(computerChoice)))) {
            status.setText("COMPUTER WINS!");
        } else if (this.buttons[6].getText().equals(this.buttons[7].getText().equals(this.buttons[8].getText().equals(computerChoice)))) {
            status.setText("COMPUTER WINS!");
        } else if (this.buttons[2].getText().equals(this.buttons[4].getText().equals(this.buttons[6].getText().equals(computerChoice)))) {
            status.setText("COMPUTER WINS!");
        } else if (this.buttons[0].getText().equals(this.buttons[4].getText().equals(this.buttons[8].getText().equals(computerChoice)))) {
            status.setText("COMPUTER WINS!");
        } else if (this.usedNums.size() == 9){
            status.setText("NO ONE WINS!");
        }
    }

    public String getComputerChoice() {
        return this.computerChoice;
    }

    public JButton[] getButtons() {
        return this.buttons;
    }

    public JFrame getFrame() {
        return this.frame;
    }
}
