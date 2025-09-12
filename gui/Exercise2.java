//: gui/HelloLabel.java
package gui;

import javax.swing.*;

import java.awt.FlowLayout;
import java.util.Random;
import java.util.concurrent.*;

public class Exercise2 {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Hello Swing");
        frame.setLayout(new FlowLayout());
        Random rg = new Random();
        int n = rg.nextInt(10) + 1;
        JLabel[] labels = new JLabel[n];
        for (int i = 0; i < n; i++) {
            JLabel label = new JLabel("Label " + i);
            frame.add(label);
            labels[i] = label;
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setVisible(true);
        TimeUnit.SECONDS.sleep(1);
        labels[rg.nextInt(labels.length)].setText("Hey! This is Different!");
    }
} /// :~