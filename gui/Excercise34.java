//: gui/ColorBoxes.java
// A visual demonstration of threading.
package gui;

import static net.mindview.util.SwingConsole.run;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Ex34CBox extends JPanel implements Runnable {
    private int pause;
    private static Random rand = new Random();
    private Color color = new Color(0);

    @Override
    public void paintComponent(Graphics g) {
        Dimension s = getSize();
        int x = rand.nextInt(s.width);
        int y = rand.nextInt(s.height);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, s.width, s.height);
        g.setColor(color);
        g.fillOval(x, y, 1, 1);
    }

    public Ex34CBox(int pause) {
        this.pause = pause;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                color = new Color(rand.nextInt(0xFFFFFF));
                repaint(); // Asynchronously request a paint()
                TimeUnit.MILLISECONDS.sleep(pause);
            }
        } catch (InterruptedException e) {
            // Acceptable way to exit
        }
    }
}

public class Excercise34 extends JFrame {
    private int grid = 12;
    private int pause = 50;
    private static ExecutorService exec = Executors.newCachedThreadPool();

    public void setUp() {
        setLayout(new GridLayout(grid, grid));
        for (int i = 0; i < grid * grid; i++) {
            Ex34CBox cb = new Ex34CBox(pause);
            add(cb);
            exec.execute(cb);
        }
    }

    public static void main(String[] args) {
        Excercise34 boxes = new Excercise34();
        if (args.length > 0)
            boxes.grid = Integer.parseInt(args[0]);
        if (args.length > 1)
            boxes.pause = Integer.parseInt(args[1]);
        boxes.setUp();
        run(boxes, 500, 400);
    }
} /// :~
