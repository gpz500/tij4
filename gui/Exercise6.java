package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.mindview.util.SwingConsole;

public class Exercise6 extends JFrame {
    private JTextArea inputText = new JTextArea(20, 40);
    private JTextField regularExpression = new JTextField(20);
    private JButton checkMatchBtn = new JButton("Check");
    private JTextArea outputText = new JTextArea(20, 40);

    /**
     * Default constructor
     */
    public Exercise6() {
        checkMatchBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Pattern p = Pattern.compile(regularExpression.getText());
                Matcher m = p.matcher(inputText.getText());
                while (m.find()) {
                    outputText.append("Match \"" + m.group() + "\" at positions " +
                            m.start() + "-" + (m.end() - 1) + "\n");
                }

            }

        });

        setLayout(new FlowLayout());
        add(new JScrollPane(inputText));
        add(regularExpression);
        add(checkMatchBtn);
        add(new JScrollPane(outputText));
    }

    /**
     * Application entry point
     */
    public static void main(String[] args) {
        SwingConsole.run(new Exercise6(), 800, 800);
    }
}
