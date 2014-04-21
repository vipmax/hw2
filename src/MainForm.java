import Task1.Task1;
import Task10.Task10;
import Task11.Task11;
import Task12.Task12;
import Task13.Task13;
import Task14.Task14Form;
import Task15.Task15;
import Task16.Task16;
import Task19.Task19;
import Task2.Task2;
import Task20.Task20;
import Task21.Task21;
import Task22and23.Task22;
import Task3.Task3;
import Task4.Task4;
import Task5.Task5;
import Task6.Task6;
import Task7.Task7;
import Task8.Task8;
import Task9.Task9;

import javax.swing.*;
import java.awt.*;

/**
 * Created by vipmax on 13.04.2014.
 */
public class MainForm extends JFrame {
    private JButton task1Button;
    private JButton task2Button;
    private JButton task3Button;
    private JButton task4Button;
    private JButton task5Button;
    private JButton task6Button;
    private JButton task7Button;
    private JButton task8Button;
    private JButton task9Button;
    private JButton task10Button;
    private JButton task11Button;
    private JButton task12Button;
    private JButton task13Button;
    private JPanel rootPanel;
    private JButton task14Button;
    private JButton task15Button;
    private JButton task16Button;
    private JButton a17Button;
    private JButton a18Button;
    private JButton task19Button;
    private JButton task20Button;
    private JButton task21Button;
    private JButton task22Button;
    private JButton task23Button;

    public MainForm() throws HeadlessException {
        setContentPane(rootPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        task1Button.addActionListener(e -> new Task1());
        task2Button.addActionListener(e -> new Task2());
        task3Button.addActionListener(e -> new Task3());
        task4Button.addActionListener(e -> new Task4());
        task5Button.addActionListener(e -> new Task5());
        task6Button.addActionListener(e -> new Task6());
        task7Button.addActionListener(e -> new Task7());
        task8Button.addActionListener(e -> new Task8());
        task9Button.addActionListener(e -> new Task9());
        task10Button.addActionListener(e -> new Task10());
        task11Button.addActionListener(e -> new Task11());
        task12Button.addActionListener(e -> new Task12());
        task13Button.addActionListener(e -> new Task13());
        task14Button.addActionListener(e -> new Task14Form());
        task15Button.addActionListener(e -> new Task15());
        task16Button.addActionListener(e -> new Task16());


        task19Button.addActionListener(e -> new Task19());
        task20Button.addActionListener(e -> new Task20());
        task21Button.addActionListener(e -> new Task21());
        task22Button.addActionListener(e -> new Task22());
        task23Button.addActionListener(e -> new Task22());
    }
}
