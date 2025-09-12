package gui;

import java.awt.Cursor;
import javax.swing.JFrame;
import net.mindview.util.SwingConsole;

public class Exercise8 extends JFrame {

    /**
     * Default constructor
     * @param args
     */
    public Exercise8() {
        super();
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    /**
     * Application entry point
     */
    public static void main(String[] args) {
        SwingConsole.run(new Exercise8(), 400, 300);
    }
}
