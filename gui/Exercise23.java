package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;

import net.mindview.util.SwingConsole;

class RotatingBox extends JPanel {
    private static final int FPS = 25;
    private Timer tmr = new Timer((int) (1000.0 / FPS), evt -> {
        updateAngle();
    });
    private double angularSpeed;
    private int side;
    private int speed;
    private JTextField txt = new JTextField(20);

    private double angle = 45;
    private double[] x = new double[4];
    private double[] y = new double[4];

    public RotatingBox(int initialSide, int initialSpeed) {
        setSide(initialSide);
        setSpeed(initialSpeed);
        txt.setEditable(false);
        add(BorderLayout.NORTH, txt);
        tmr.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        double cx = getWidth() / 2.0;
        double cy = getHeight() / 2.0;
        double[] px = new double[4];
        double[] py = new double[4];

        for (int i = 0; i < 4; i++) {
            px[i] = cx + x[i];
            py[i] = cy + y[i];
        }
        g.setColor(Color.RED);
        for (int i = 0; i < 4; i++) {
            g.drawLine((int) px[i], (int) py[i], (int) px[(i + 1) % 4], (int) py[(i + 1) % 4]);
        }

        txt.setText("Side: " + side + "; speed: " + speed + "; time: " + System.currentTimeMillis() % 10000);
    }

    private void calcVertex() {
        double[] tmpx = new double[4];
        double[] tmpy = new double[4];

        tmpx[0] = (double) side / 2.0;
        tmpy[0] = (double) side / 2.0;
        tmpx[1] = -tmpx[0];
        tmpy[1] = tmpy[0];
        tmpx[2] = -tmpx[0];
        tmpy[2] = -tmpy[0];
        tmpx[3] = tmpx[0];
        tmpy[3] = -tmpy[0];

        for (int i = 0; i < 4; i++) {
            x[i] = tmpx[i] * Math.cos(angle) - tmpy[i] * Math.sin(angle);
            y[i] = tmpx[i] * Math.sin(angle) + tmpy[i] * Math.cos(angle);
        }
    }

    public void setSide(int newSide) {
        side = newSide;
        calcVertex();
        repaint();
    }

    public void setSpeed(int newSpeed) {
        speed = newSpeed;
        double nsRadPerSec = (double) speed * Math.PI / 180.0;
        angularSpeed = nsRadPerSec / FPS;
    }

    public void updateAngle() {
        angle += angularSpeed;
        calcVertex();
        repaint();
    }
}

public class Exercise23 extends JFrame {

    JSlider side = new JSlider(JSlider.VERTICAL, 10, 600, 150);
    JSlider speed = new JSlider(JSlider.VERTICAL, 0, 360, 20);
    RotatingBox myBox = new RotatingBox(side.getValue(), speed.getValue());

    public Exercise23() {
        add(BorderLayout.WEST, side);
        add(BorderLayout.CENTER, myBox);
        add(BorderLayout.EAST, speed);

        side.addChangeListener((ChangeEvent e) -> {
            myBox.setSide(side.getValue());
        });

        speed.addChangeListener((ChangeEvent e) -> {
            myBox.setSpeed(speed.getValue());
        });
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        SwingConsole.run(new Exercise23(), 400, 400);
    }
}
