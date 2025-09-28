//: gui/MessageBoxes.java
// Demonstrates JOptionPane.
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static net.mindview.util.SwingConsole.run;

public class Exercise18 extends JFrame {
    private JButton[] b = {
            new JButton("Alert"), new JButton("Yes/No"),
            new JButton("Color"), new JButton("Input"),
            new JButton("3 Vals")
    };
    private JTextField txt = new JTextField(15);

    public Exercise18() {
        setLayout(new FlowLayout());

        b[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "There’s a bug on you!", "Hey!",
                        JOptionPane.ERROR_MESSAGE);

            }
        });

        b[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sel = JOptionPane.showConfirmDialog(null,
                        "or no", "choose yes",
                        JOptionPane.YES_NO_OPTION);
                txt.setText(Integer.toString(sel));
            }
        });

        b[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = { "Red", "Green" };
                int sel = JOptionPane.showOptionDialog(
                        null, "Choose a Color!", "Warning",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.WARNING_MESSAGE, null,
                        options, options[0]);
                if (sel != JOptionPane.CLOSED_OPTION)
                    txt.setText("Color Selected: " + options[sel]);
            }
        });

        b[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String val = JOptionPane.showInputDialog(
                        "How many fingers do you see?");
                txt.setText(val);
            }
        });

        b[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] selections = { "First", "Second", "Third" };
                Object val = JOptionPane.showInputDialog(
                        null, "Choose one", "Input",
                        JOptionPane.INFORMATION_MESSAGE,
                        null, selections, selections[0]);
                if (val != null)
                    txt.setText(val.toString());
            }
        });

        for (JButton btn: b) {
            add(btn);
        }
        add(txt);
    }

    public static void main(String[] args) {
        run(new Exercise18(), 200, 200);
    }
}
