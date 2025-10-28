package gui;

import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;

import net.mindview.util.SwingConsole;

public class Exercise30 extends JFrame {

    JTabbedPane tp = new JTabbedPane();
    JLabel label = new JLabel("Just a text");
    JMenuBar mbar = new JMenuBar();
    JMenu menu = new JMenu("Pippo");
    JMenuItem mitem = new JMenuItem("<html><i>Dici?");
    JRadioButton rb = new JRadioButton("<html><b>Cazzo!");
    JCheckBox cb = new JCheckBox("<html><i><b>E allora...");

    /**
     * Constructor
     * @param args
     */
    public Exercise30() {
        super();

        label.setToolTipText("<html>Questo è un testo<br>su <i>due</i> linee!");

        tp.add("<html><b>Palle!", label);
        mbar.add(menu);
        menu.add(mitem);
        tp.add("Ciao", mbar);
        tp.add("Radio", rb);
        tp.add("Check box", cb);

        setLayout(new FlowLayout());
        add(tp);
        
    }

    /**
     * Application entry point
     */
    public static void main(String[] args) {
        SwingConsole.run(new Exercise30(), 800, 600);
    }
}
