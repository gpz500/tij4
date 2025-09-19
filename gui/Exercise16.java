//: gui/List.java
package gui;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.*;
import static net.mindview.util.SwingConsole.*;

public class Exercise16 extends JFrame {
    private String[] flavors = {
            "Chocolate", "Strawberry", "Vanilla Fudge Swirl",
            "Mint Chip", "Mocha Almond Fudge", "Rum Raisin",
            "Praline Cream", "Mud Pie"
    };
    private JList lst = new JList(flavors);
    private JTextArea t = new JTextArea(flavors.length, 20);
    private ListSelectionListener ll = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) {
                return;
            }

            t.setText("");
            for (Object item : lst.getSelectedValuesList()) {
                t.append(item + "\n");
            }
        }
    };

    public Exercise16() {
        t.setEditable(false);
        setLayout(new FlowLayout());
        lst.setVisibleRowCount(4);
        // Create Borders for components:
        Border brd = BorderFactory.createMatteBorder(
                1, 1, 2, 2, Color.BLACK);
        t.setBorder(brd);
        add(t);
        add(new JScrollPane(lst));
        // Register event listeners
        lst.addListSelectionListener(ll);
    }

    public static void main(String[] args) {
        run(new Exercise16(), 250, 375);
    }
} /// :~
