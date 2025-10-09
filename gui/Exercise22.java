package gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.mindview.util.SwingConsole;

public class Exercise22 extends JFrame {

    JPanel panel = new JPanel();
    JTextField txt = new JTextField(30);
    JSlider rSlider = new JSlider(0, 255);
    JSlider gSlider = new JSlider(0, 255);
    JSlider bSlider = new JSlider(0, 255);

    /**
     * My Change Listener
     */
    ChangeListener cl = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            updateColors();
        }
    };

    /**
     * Default contructor
     */
    public Exercise22() {
        add(panel);
        add(BorderLayout.NORTH, txt);
        add(BorderLayout.WEST, rSlider);
        add(BorderLayout.SOUTH, gSlider);
        add(BorderLayout.EAST, bSlider);
        

        rSlider.addChangeListener(cl);
        gSlider.addChangeListener(cl);
        bSlider.addChangeListener(cl);

        rSlider.setValue(panel.getBackground().getRed());
        gSlider.setValue(panel.getBackground().getGreen());
        bSlider.setValue(panel.getBackground().getBlue());

        updateColors();
    }

    /**
     * Set message
     * @param args
     */
    void updateColors() {
        int r = rSlider.getValue();
        int g = gSlider.getValue();
        int b = bSlider.getValue();
        txt.setText(String.format("(%d, %d, %d)", r, g, b));
        panel.setBackground(new Color(r, g, b));
    }

    /**
     * App entry point
     */
    public static void main(String[] args) {
        SwingConsole.run(new Exercise22(), 800, 300);
    }
}
