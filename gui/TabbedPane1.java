//: gui/TabbedPane1.java
// Demonstrates the Tabbed Pane.
package gui;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import static net.mindview.util.SwingConsole.run;

public class TabbedPane1 extends JFrame {
    private String[] flavors = {
            "Chocolate", "Strawberry", "Vanilla Fudge Swirl",
            "Mint Chip", "Mocha Almond Fudge", "Rum Raisin",
            "Praline Cream", "Mud Pie"
    };
    private JTabbedPane tabs = new JTabbedPane();
    private JTextField txt = new JTextField(20);

    public TabbedPane1() {
        for (int i = 0; i < flavors.length; i++) {
            tabs.addTab(flavors[i], new JButton("Tabbed pane " + i));
        }
        tabs.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                txt.setText("Tab selected: " + tabs.getSelectedIndex());
            }
        });
        add(BorderLayout.SOUTH, txt);
        add(tabs);
    }

    public static void main(String[] args) {
        run(new TabbedPane1(), 400, 250);
    }
} /// :~
