package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import net.mindview.util.SwingConsole;

public class Exercise20 extends JFrame {

    private List<String> names = new ArrayList<>();
    private JTextField t = new JTextField(30);
    private JMenuBar mbl = new JMenuBar();
    private JMenu[] menus = {
        new JMenu("First"),
        new JMenu("Second"),
        new JMenu("Third")
    };

    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem target = (JMenuItem) e.getSource();
            t.setText(target.getActionCommand());
        }
    };

    /**
     * Default constructor
     * 
     * @param args
     */
    public Exercise20() {
        super();

        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("/home/gpz500/src/tij4/gui/Exercise20.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    names.add(word);
                }
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Unable to find source: " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Unable to read from source: " + ex.getMessage());
        }

        System.out.println(names.toString());

        int n = 0;
        for (String name : names) {
            JMenuItem mitem = new JMenuItem(name);
            mitem.addActionListener(al);
            menus[n % menus.length].add(mitem);
            n++;
        }

        mbl.add(menus[0]);
        menus[0].add(menus[1]);
        menus[1].add(menus[2]);

        setJMenuBar(mbl);
        add(t);
    }

    /**
     * Entry point
     * 
     * @param args
     */
    public static void main(String[] args) {
        SwingConsole.run(new Exercise20(), 400, 300);
    }
}
