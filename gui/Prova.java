package gui;

import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame extends JFrame {
    private JButton button1 = new JButton("Button 1"),
            button2 = new JButton("Button 2"),
            button3 = new JButton("Button 3");

    public MyFrame() {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();
        Insets myInsets = getInsets();

        setLayout(null);
        add(button1);
        add(button2);
        add(button3);

        button1.setBounds(0, 0, 400, 100);
        button2.setBounds(0, 100, 400, 100);
        button3.setBounds(0, 200, 400, 100);

        setSize(400 + myInsets.left + myInsets.right, 300 + myInsets.top + myInsets.bottom);
        setResizable(false);

        setVisible(true);
    }
}

public class Prova {
    public static void main(String[] args) {
        new MyFrame();
    }
}
