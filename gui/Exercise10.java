package gui;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import net.mindview.util.SwingConsole;

public class Exercise10 extends JFrame {
    private JButton button = new JButton("Click me!");
    private JTextField text = new JTextField(40);

    /**
     * Default constuctor
     */
    public Exercise10() {
        super();

        button.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (c != KeyEvent.CHAR_UNDEFINED) {
                    text.setText(text.getText() + c);
                }
            }

        });

        text.setEditable(false);

        add(text);
        add(button, BorderLayout.SOUTH);
    }

    /**
     * Application entry point
     */
    public static void main(String[] args) {
        SwingConsole.run(new Exercise10(), 400, 300);
    }
}
