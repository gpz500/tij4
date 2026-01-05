//: gui/InterruptableLongRunningCallable.java
// Using Callables for long-running tasks.
package gui;

import net.mindview.util.SwingConsole;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Callable;

import javax.swing.JButton;
import javax.swing.JFrame;

import net.mindview.util.TaskItem;
import net.mindview.util.TaskManager;

class E33CallableTask extends Task
        implements Callable<String> {
    public String call() {
        run();
        return "Return value of " + this;
    }
}

public class Exercise33 extends JFrame {
    private JButton b1 = new JButton("Start Long Running Task"),
            b2 = new JButton("End Long Running Task"),
            b3 = new JButton("Get results");
    private TaskManager<String, E33CallableTask> manager = new TaskManager<String, E33CallableTask>(true);

    public Exercise33() {
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                E33CallableTask task = new E33CallableTask();
                manager.add(task);
                System.out.println(task + " added to the queue");
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (String result : manager.purge())
                    System.out.println(result);
            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Sample call to a Task method:
                for (TaskItem<String, E33CallableTask> tt : manager)
                    tt.task.id(); // No cast required
                for (String result : manager.getResults())
                    System.out.println(result);
            }
        });
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(b3);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Exercise33(), 200, 150);
    }
} /// :~
