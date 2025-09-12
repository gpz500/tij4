//: gui/SubmitSwingProgram.java
package gui;

import javax.swing.*;
import java.util.concurrent.*;
import net.mindview.util.SwingConsole;

public class Exercise3 extends JFrame {
    JLabel label;

    public Exercise3() {
        label = new JLabel("A Label");
        add(label);
    }

    static Exercise3 ssp;

    public static void main(String[] args) throws Exception {
        ssp = new Exercise3();
        SwingConsole.run(ssp, 300, 100);

        TimeUnit.SECONDS.sleep(1);
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ssp.label.setText("Hey! This is Different!");
            }
        });
    }
} /// :~
