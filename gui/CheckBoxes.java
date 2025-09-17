//: gui/CheckBoxes.java
// Using JCheckBoxes.
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static net.mindview.util.SwingConsole.*;

public class CheckBoxes extends JFrame {
    private JTextArea t = new JTextArea(6, 15);
    private JCheckBox cb1 = new JCheckBox("Check Box 1"),
            cb2 = new JCheckBox("Check Box 2"),
            cb3 = new JCheckBox("Check Box 3");
    private MyActionListener mal = new MyActionListener();

    /**
     * An ActionListener class to handle the checkbox activations
     */
    private class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String message = "x";
            if (e.getSource().equals(cb1)) {
                message = "1";
            } else if (e.getSource().equals(cb2)) {
                message = "2";
            } else if (e.getSource().equals(cb3)) {
                message = "3";
            }

            trace(message, (JCheckBox) e.getSource());
        }

    }

    public CheckBoxes() {
        cb1.addActionListener(mal);
        cb2.addActionListener(mal);
        cb3.addActionListener(mal);
        setLayout(new FlowLayout());
        add(new JScrollPane(t));
        add(cb1);
        add(cb2);
        add(cb3);
    }

    private void trace(String b, JCheckBox cb) {
        if (cb.isSelected())
            t.append("Box " + b + " Set\n");
        else
            t.append("Box " + b + " Cleared\n");
    }

    public static void main(String[] args) {
        run(new CheckBoxes(), 200, 300);
    }
} /// :~
