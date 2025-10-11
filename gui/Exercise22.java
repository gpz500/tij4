package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.mindview.util.SwingConsole;

public class Exercise22 extends JFrame {

    JPanel colorsPanel = new JPanel();
    JPanel sliders = new JPanel();
    JTextField txt = new JTextField(15);
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
        txt.setEditable(false);

        sliders.setLayout(new FlowLayout());
        sliders.add(txt);
        sliders.add(rSlider);
        sliders.add(gSlider);
        sliders.add(bSlider);

        setLayout(new GridLayout(2, 1));
        add(colorsPanel);
        add(sliders);

        rSlider.addChangeListener(cl);
        gSlider.addChangeListener(cl);
        bSlider.addChangeListener(cl);

        rSlider.setValue(colorsPanel.getBackground().getRed());
        gSlider.setValue(colorsPanel.getBackground().getGreen());
        bSlider.setValue(colorsPanel.getBackground().getBlue());

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
        colorsPanel.setBackground(new Color(r, g, b));
    }

    /**
     * App entry point
     */
    public static void main(String[] args) {
        SwingConsole.run(new Exercise22(), 300, 300);
    }
}
