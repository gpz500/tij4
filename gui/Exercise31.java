package gui;

import javax.swing.Timer;
import javax.swing.UIManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

import net.mindview.util.SwingConsole;

public class Exercise31 extends JFrame {
    JProgressBar pb = new JProgressBar();

    /**
     * Contructor
     * 
     * @param args
     */
    public Exercise31() {
        super();

        pb.setMinimum(0);
        pb.setMaximum(100);
        add(pb);

        new Timer(2000, new ActionListener() {
            int count = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if ((count % 3) == 1) {
                    int newValue = pb.getValue() + (pb.getMaximum() - pb.getValue()) / 3;
                    pb.setValue(newValue);
                }
                int newValue = pb.getValue() + (pb.getMaximum() - pb.getValue()) / 3;
                pb.setValue(newValue);
                count++;
            }
        }).start();
    }

    /**
     * App entry point
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        SwingConsole.run(new Exercise31(), 600, 200);
    }
}
