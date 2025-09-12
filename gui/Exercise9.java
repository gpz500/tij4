//: gui/ShowAddListeners.java
// Display the "addXXXListener" methods of any Swing class.
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
import java.util.regex.*;
import static net.mindview.util.SwingConsole.*;

public class Exercise9 extends JFrame {
    private JTextField name = new JTextField(25);
    private JTextArea results = new JTextArea(40, 65);
    private static Pattern qualifier = Pattern.compile("\\w+\\.");

    class NameL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String[] nms = name.getText().trim().split("\\s+");
            if (nms.length == 0) {
                results.setText("No match");
                return;
            }
            Class<?> kind;
            try {
                kind = Class.forName(nms[0]);
            } catch (ClassNotFoundException ex) {
                results.setText("No match");
                return;
            }
            Method[] methods = kind.getMethods();
            Constructor[] ctors = kind.getConstructors();
            results.setText("");

            if (nms.length == 1) {
                for (Method m : methods) {
                    results.append(qualifier.matcher(m.toString()).replaceAll("") + "\n");
                }

                for (Constructor c : ctors) {
                    results.append(qualifier.matcher(c.toString()).replaceAll("") + "\n");
                }
            } else {
                for (Method m : methods) {
                    if (m.toString().indexOf(nms[1]) != -1) {
                        results.append(qualifier.matcher(m.toString()).replaceAll("") + "\n");
                    }
                }
                for (Constructor c : ctors) {
                    if (c.toString().indexOf(nms[1]) != -1) {
                        results.append(qualifier.matcher(c.toString()).replaceAll("") + "\n");
                    }
                }

            }
        }
    }

    public Exercise9() {
        setLayout(new BorderLayout());
        NameL nameListener = new NameL();
        name.addActionListener(nameListener);
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        top.add(BorderLayout.WEST, new JLabel("Swing class name (press Enter):"));
        top.add(BorderLayout.CENTER, name);
        add(BorderLayout.NORTH, top);
        add(BorderLayout.CENTER, new JScrollPane(results));
        // Initial data and test:
        name.setText("JTextArea");
        nameListener.actionPerformed(
                new ActionEvent("", 0, ""));
        pack();
    }

    public static void main(String[] args) {
        run(new Exercise9(), 500, 400);
    }
} /// :~
