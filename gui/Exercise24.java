//: gui/SineWave.java
// Drawing with Swing, using a JSlider.
package gui;

import static net.mindview.util.SwingConsole.run;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class Sketching extends JPanel {
    private List<Point> points = new LinkedList<Point>();

    /**
     * Plot a line from previous point to the new one
     */
    @Override
     public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (points.size() >= 2) {
            g.setColor(Color.RED);
            for (int i = 0; i < points.size() - 1; i++) {
                Point first = points.get(i);
                Point second = points.get(i + 1);
                g.drawLine(first.getX(), first.getY(), second.getX(), second.getY());
            }
        }
     }

     /**
      * Clean the whole panel
      */
      public void clean() {
        points.clear();
        repaint();
      }

      /**
       * Add a new piece of line
       */
      public void addStroke(Point newPoint) {
        points.add(newPoint);
        repaint();
      }
}

public class Exercise24 extends JFrame {
    private Sketching sketch = new Sketching();
    private JSlider xslider = new JSlider(0, 300, 10);
    private JSlider yslider = new JSlider(JSlider.VERTICAL, 0, 300, 10);
    private JButton clearBtn = new JButton("Clear"); 

    /**
     * My change listener
     */
    private ChangeListener cl = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            Point point = new Point(xslider.getValue(), yslider.getValue());
            sketch.addStroke(point);
        }
    };

    public Exercise24() {
        add(sketch);
        add(BorderLayout.SOUTH, xslider);
        add(BorderLayout.EAST, yslider);
        add(BorderLayout.WEST, clearBtn);

        clearBtn.addActionListener(e -> {
            sketch.clean();
        });

        xslider.addChangeListener(cl);
        yslider.addChangeListener(cl);
        yslider.setInverted(true);
    }

    public static void main(String[] args) {
        run(new Exercise24(), 700, 400);
    }
} /// :~
