//: gui/BorderLayout1.java
// Demonstrates BorderLayout.
package gui;

import javax.swing.*;
import java.awt.*;
import net.mindview.util.SwingConsole;

public class BorderLayout1 extends JFrame {
    public BorderLayout1() {
        add(BorderLayout.CENTER, new JButton("Center"));
        add(BorderLayout.NORTH, new JButton("North"));
        add(BorderLayout.SOUTH, new JButton("South"));
        add(BorderLayout.EAST, new JButton("East"));
        add(BorderLayout.WEST, new JButton("West"));
    }

    public static void main(String[] args) {
        SwingConsole.run(new BorderLayout1(), 300, 250);
    }
} /// :~