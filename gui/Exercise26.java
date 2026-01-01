//: gui/SineWave.java
// Drawing with Swing, using a JSlider.
package gui;

import static net.mindview.util.SwingConsole.run;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Exercise26 extends JFrame {

    static class SineDraw extends JPanel {
        private static final int SCALEFACTOR = 200;
        private static final int FPS = 25;
        private static final int MAX_POINTS = SCALEFACTOR * 10;
        private int points;
        private double[] sines;
        private int[] pts;
        private Timer timer = new Timer();
        private int speed = 5;

        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                points += speed;
                points = points % MAX_POINTS;
                sines = new double[points];
                for (int i = 0; i < points; i++) {
                    double radians = (Math.PI / SCALEFACTOR) * i;
                    sines[i] = Math.sin(radians);
                }

                repaint();
            };
        };

        public SineDraw() {
            timer.schedule(tt, (int) (1000.0 / FPS), (int) (1000.0 / FPS));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int maxWidth = getWidth();
            double hstep = (double) maxWidth / (double) MAX_POINTS;
            int maxHeight = getHeight();
            pts = new int[points];
            for (int i = 0; i < points; i++) {
                pts[i] = (int) (sines[i] * maxHeight / 2 * .95 + maxHeight / 2);
            }
            g.setColor(Color.RED);
            for (int i = 1; i < points; i++) {
                int x1 = (int) ((i - 1) * hstep);
                int x2 = (int) (i * hstep);
                int y1 = pts[i - 1];
                int y2 = pts[i];
                g.drawLine(x1, y1, x2, y2);
            }
        }

        public void setSpeed(int newSpeed) {
            speed = newSpeed;
        }
    }

    private JSlider adjustSpeed = new JSlider(0, 30, 5);

    public Exercise26(int num) {
        setLayout(new FlowLayout());
        SineDraw[] sines = new SineDraw[num];
        for (int i = 0; i < num; i++) {
            sines[i] = new SineDraw();
            sines[i].setPreferredSize(new Dimension(400, 300));
            add(sines[i]);
        }
        adjustSpeed.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int speed = ((JSlider) e.getSource()).getValue();
                for (SineDraw sineDraw : sines) {
                    sineDraw.setSpeed(speed);
                }
            }
        });
        add(adjustSpeed);
    }

    public static void main(String[] args) {
        int n;
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException ex) {
            n = 1;
        } catch (ArrayIndexOutOfBoundsException ex) {
            n = 1;
        }

        run(new Exercise26(n), 800, 600);
    }
} /// :~
