//: gui/SubmitSwingProgram.java
package gui;

import javax.swing.*;
import java.util.concurrent.*;
import net.mindview.util.SwingConsole;

public class SubmitSwingProgram extends JFrame {
    JLabel label;

    public SubmitSwingProgram() {
        label = new JLabel("A Label");
        add(label);
    }

    static SubmitSwingProgram ssp;

    public static void main(String[] args) throws Exception {
        ssp = new SubmitSwingProgram();
        SwingConsole.run(ssp, 300, 100);

        TimeUnit.SECONDS.sleep(1);
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ssp.label.setText("Hey! This is Different!");
            }
        });
    }
} /// :~
