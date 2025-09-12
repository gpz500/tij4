package gui;

import javax.swing.Timer;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import net.mindview.util.SwingConsole;

public class Exercise7 extends JFrame {

    private class MyListener implements ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            outputTxt.setText(e.getSource().getClass().getSimpleName());
        }

    }

    private ActionListener listener = new MyListener();
    private JTextField outputTxt = new JTextField(40);

    private JButton button = new JButton("Click me");
    private JComboBox<String> comboBox = new JComboBox<String>(new String[] { "Primo", "Secondo", "Terzo" });
    private JFileChooser fileChooser = new JFileChooser(".");
    private JTextField textField = new JTextField(40);
    private Timer timer = new Timer(5_000, listener);

    /**
     * Default constructor
     */
    public Exercise7() {
        button.addActionListener(listener);
        comboBox.addActionListener(listener);
        fileChooser.addActionListener(listener);
        textField.addActionListener(listener);

        setLayout(new FlowLayout());
        add(outputTxt);
        add(button);
        add(comboBox);
        add(fileChooser);
        add(textField);

        timer.start();
    }

    /**
     * Application entry point
     */
    public static void main(String[] args) {
        SwingConsole.run(new Exercise7(), 800, 600);
    }
}
