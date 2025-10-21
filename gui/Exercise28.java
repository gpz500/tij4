package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import net.mindview.util.SwingConsole;

public class Exercise28 extends JFrame {

    private static class FunctionDraw extends JPanel {
        static final int XSTEP = 10;
        static final int YSTEP = 15;
        private List<Integer> list;

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            int maxHeight = getHeight();
            g.setColor(Color.RED);
            for (int i = 1; i < list.size(); i++) {
                int x1 = (i - 1) * XSTEP;
                int y1 = maxHeight - list.get(i - 1) * YSTEP;
                int x2 = i * XSTEP;
                int y2 = maxHeight - list.get(i) * YSTEP;
                g.drawLine(x1, y1, x2, y2);
            }
        }

        public void setList(List<Integer> newList) {
            list = newList;
            repaint();
        }
    }

    private static class Dice {

        private Random random = new Random();

        public int getNextValue() {
            return random.nextInt(6) + 1;
        }

    }

    private Dice[] dice = {
            new Dice(),
            new Dice(),
            new Dice(),
            new Dice(),
            new Dice()
    };

    private List<Integer> throwns = new LinkedList<>();
    private FunctionDraw functionDraw = new FunctionDraw();
    private JButton btn = new JButton("Thrown!");

    public Exercise28(int initialThrowns) {
        for (int i = 0; i < initialThrowns; i++) {
            int sum = 0;
            for (Dice d : dice) {
                sum += d.getNextValue();
            }
            throwns.add(sum);
        }
        functionDraw.setList(throwns);

        btn.addActionListener((evt) -> {
            int sum = 0;
            for (Dice d : dice) {
                sum += d.getNextValue();
            }
            throwns.add(sum);
            functionDraw.setList(throwns);
        });

        add(functionDraw);
        add(BorderLayout.SOUTH, btn);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Exercise28(10), 640, 480);
    }
}
