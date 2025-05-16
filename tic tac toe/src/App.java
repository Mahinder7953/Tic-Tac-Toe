import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class tictac extends JFrame implements ActionListener {
    Font font = new Font("Arial", Font.ITALIC, 62);
    int xo = 1;
    Container c;
    JButton[] buttons = new JButton[9];
    JPanel panel;
    JLabel label;

    tictac() {
        c = getContentPane();
        panel = new JPanel();
        label = new JLabel();
        label.setText("TIC TAC TOE");
        label.setFont(font);
        panel.setBounds(0, 0, 900, 100);
        label.setForeground(Color.GREEN);
        panel.add(label);
        panel.setBackground(Color.BLACK);
        c.add(panel);

        int x = 100;
        int y = 100;
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            c.add(buttons[i]);
            buttons[i].setBounds(x, y, 200, 200);
            buttons[i].addActionListener(this);
            y += 200;
            if (i == 2 || i == 5 || i == 8) {
                x = x + 200;
                y = 100;
            }
        }
        setTitle("TIC TAC TOE");
        c.setLayout(null);
        setSize(900, 800);
        c.setBackground(Color.DARK_GRAY);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < buttons.length; i++) {

            if (e.getSource() == buttons[i]) {
                if (xo % 2 == 1) {

                    buttons[i].setText("X");
                    buttons[i].setFont(font);
                    buttons[i].setBackground(Color.RED);
                    buttons[i].setEnabled(false);
                    xo++;
                    check();

                } else {
                    buttons[i].setText("O");
                    buttons[i].setFont(font);
                    buttons[i].setBackground(Color.BLUE);
                    buttons[i].setEnabled(false);
                    xo++;
                    check();

                }
            }
        }

        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    void check() {
        if (xo == 9) {
            label.setText("DRAW");
        }
        // X
        if ((buttons[0].getText() == "X") && (buttons[1].getText() == "X") && (buttons[2].getText() == "X")) {
            xwins(0, 1, 2);
        }
        if ((buttons[3].getText() == "X") && (buttons[4].getText() == "X") && (buttons[5].getText() == "X")) {
            xwins(3, 4, 5);
        }
        if ((buttons[6].getText() == "X") && (buttons[7].getText() == "X") && (buttons[8].getText() == "X")) {
            xwins(6, 7, 8);
        }
        if ((buttons[0].getText() == "X") && (buttons[3].getText() == "X") && (buttons[6].getText() == "X")) {
            xwins(0, 3, 6);
        }
        if ((buttons[1].getText() == "X") && (buttons[4].getText() == "X") && (buttons[7].getText() == "X")) {
            xwins(1, 4, 7);
        }
        if ((buttons[2].getText() == "X") && (buttons[5].getText() == "X") && (buttons[8].getText() == "X")) {
            xwins(2, 5, 8);
        }
        if ((buttons[0].getText() == "X") && (buttons[4].getText() == "X") && (buttons[8].getText() == "X")) {
            xwins(0, 4, 8);
        }
        if ((buttons[2].getText() == "X") && (buttons[4].getText() == "X") && (buttons[6].getText() == "X")) {
            xwins(2, 4, 6);
        }

        // O
        if ((buttons[0].getText() == "O") && (buttons[1].getText() == "O") && (buttons[2].getText() == "O")) {
            owins(0, 1, 2);
        }
        if ((buttons[3].getText() == "O") && (buttons[4].getText() == "O") && (buttons[5].getText() == "O")) {
            owins(3, 4, 5);
        }
        if ((buttons[6].getText() == "O") && (buttons[7].getText() == "O") && (buttons[8].getText() == "O")) {
            owins(6, 7, 8);
        }
        if ((buttons[0].getText() == "O") && (buttons[3].getText() == "O") && (buttons[6].getText() == "O")) {
            owins(0, 3, 6);
        }
        if ((buttons[1].getText() == "O") && (buttons[4].getText() == "O") && (buttons[7].getText() == "O")) {
            owins(1, 4, 7);
        }
        if ((buttons[2].getText() == "O") && (buttons[5].getText() == "O") && (buttons[8].getText() == "O")) {
            owins(2, 5, 8);
        }
        if ((buttons[0].getText() == "O") && (buttons[4].getText() == "O") && (buttons[8].getText() == "O")) {
            owins(0, 4, 8);
        }
        if ((buttons[2].getText() == "O") && (buttons[4].getText() == "O") && (buttons[6].getText() == "O")) {
            owins(2, 4, 6);
        }
    }

    void xwins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        label.setText("X WINS");
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setEnabled(false);
        }

    }

    void owins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        label.setText("O WINS");
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setEnabled(false);
        }
    }

}

public class App {
    public static void main(String[] args) throws Exception {
        tictac xo = new tictac();
    }
}