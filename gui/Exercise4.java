package gui;

import javax.swing.*;
import net.mindview.util.SwingConsole;

public class Exercise4 extends JFrame {
    private JButton b1 = new JButton("Button 1"),
            b2 = new JButton("Button 2");

    public Exercise4() {
        //setLayout(new FlowLayout());
        add(b1);
        add(b2);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Exercise4(), 200, 100);
    }
} /// :~
