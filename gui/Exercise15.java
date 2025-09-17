package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import net.mindview.util.SwingConsole;

public class Exercise15 extends JFrame {

    private JButton b1 = new JButton("Tizio"),
            b2 = new JButton("Caio"),
            b3 = new JButton("Sempronio");
    private JCheckBox cb = new JCheckBox("Topolino");
    private JTextField txt = new JTextField(30);

    /**
     * Create a listener for my buttons
     */
    private ActionListener myListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton src = (JButton) e.getSource();
            txt.setText("Hai premuto " + src.getText());
        }
    };

    /**
     * Constructor
     */
    public Exercise15() {
        b1.addActionListener(myListener);
        b2.addActionListener(myListener);
        b3.addActionListener(myListener);
        cb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                txt.setText("Topolino è " + (cb.isSelected() ? "attivo" : "disattivo"));
            }
            
        });

        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(b3);
        add(cb);
        add(txt);
    }

    /**
     * Application entry point
     */
    public static void main(String[] args) {
        SwingConsole.run(new Exercise15(), 400, 300);
    }
}
