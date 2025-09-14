package gui;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import net.mindview.util.SwingConsole;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * A local class to change colour when the button is clicked
 */
class ColorButton extends JButton {

    private Random random = new Random();

    /**
     * Create a button with a text and an icon
     */
    public ColorButton(String text, Icon icon) {

        super(text, icon);

        setOpaque(true);
        setBorderPainted(false);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBackground(new Color(
                        random.nextInt(256),
                        random.nextInt(256),
                        random.nextInt(256)));
            }
        });

    }

    /**
     * Create a button with a text
     */
    public ColorButton(String text) {
        this(text, null);
    }

    /**
     * Create a button with a icon
     */
    public ColorButton(Icon icon) {
        this(null, icon);
    }

    /**
     * Create a button without text and icon
     */
    public ColorButton() {
        this(null, null);
    }

}

public class Exercise11 extends JFrame {

    private JButton button = new ColorButton("Click me!");
    private JTextField text = new JTextField(10);
    private Random rng = new Random();

    public Exercise11() {

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText(Integer.toString(rng.nextInt()));
            }
        });

        add(text, BorderLayout.CENTER);
        add(button, BorderLayout.EAST);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Exercise11(), 300, 100);
    }
}
