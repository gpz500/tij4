package gui;

import static net.mindview.util.SwingConsole.run;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Exercise29 extends JFrame {
    JButton color = new JButton("Choose color");

    /**
     * Constructor
     */
    public Exercise29() {
        super();

        JPanel p = new JPanel(new GridLayout(2, 1));
        color.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color cc = JColorChooser.showDialog(Exercise29.this, "Choose a color", p.getBackground());
                p.setBackground(cc);
            }
        });

        p.add(color);
        add(p);
    }

    /**
     * App entry point
     */
    public static void main(String[] args) {
        run(new Exercise29(), 400, 300);
    }
}
