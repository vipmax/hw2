package Task12;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by vipmax on 15.04.2014.
 */
public class Task12Form extends JFrame {
    private Task12 task12;
    private JTextField numberTextField;
    private JButton modelButton;
    private JLabel time1Label;
    private JLabel time2Label;
    private JPanel rootPanel;

    public Task12Form(Task12 task12) {
        this.task12 = task12;
        setContentPane(rootPanel);
        pack();
        setSize(800, 300);
        setVisible(true);

        modelButton.addActionListener(e -> {


            double parseDouble;
            try {
                parseDouble = Double.parseDouble(numberTextField.getText());
            } catch (NumberFormatException e1) {
                e1.printStackTrace();
                return;
            }

            List<People> peopleArrayList = new ArrayList<>();
            List<People> peopleLinkedList = new LinkedList<>();

            for (int i = 0; i < parseDouble; i++) {
                peopleArrayList.add(new People());
                peopleLinkedList.add(new People());
            }

            Long startTime = System.nanoTime();
            task12.handleListPeople(peopleArrayList);
            Long endArrayList = System.nanoTime();
            time1Label.setText(String.format("%,d ns", endArrayList - startTime));


            startTime = System.nanoTime();

            task12.handleListPeople(peopleLinkedList);
            Long endLinkedList = System.nanoTime();
            time2Label.setText(String.format("%,d ns", endLinkedList - startTime));


        });
    }
}
