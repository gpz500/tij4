package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.mindview.util.SwingConsole;

public class Exercise17 extends JFrame {

    private static final String PASSWORD = "secret123";
    private JTextField pf = new JPasswordField(30);

    public Exercise17() {
        super();
        
        pf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String password = pf.getText();
                if (password.equals(PASSWORD)) {
                    JOptionPane.showMessageDialog(Exercise17.this, "Access granted!", "Outcome", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(Exercise17.this, "Access denied!", "Outcome", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(pf);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Exercise17(), 300, 200);
    }
}
