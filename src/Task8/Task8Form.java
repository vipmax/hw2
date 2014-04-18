package Task8;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vipmax on 14.04.2014.
 */
public class Task8Form extends JFrame {

    private Task8 task8;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton multButton;
    private JTextArea resultTextArea3;
    private JPanel rootPanel;

    public Task8Form(Task8 task8) {
        this.task8 = task8;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(rootPanel);
        pack();
        setSize(700, 300);
        setVisible(true);

        multButton.addActionListener(e -> {
            String values1 = textArea1.getText();
            String values2 = textArea2.getText();

            List<Double> list1 = toList(values1);
            List<Double> list2 = toList(values2);

            List<Double> multList = task8.mult(list1, list2);

            updateTextArea(list1, textArea1);
            updateTextArea(list2, textArea2);
            updateTextArea(multList, resultTextArea3);
        });


    }

    public List<Double> toList(String values) {
        String valuesStringArr[] = values.split(" ");
        List<Double> valuesList = new ArrayList<>();

        for (String value : valuesStringArr) {
            if (value.isEmpty()) continue;
            try {
                valuesList.add(Double.valueOf(value));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        List<Double> list = new ArrayList<>();
        for (int i = 0; i < valuesList.size(); i++) {
            list.add(i, valuesList.get(i));
        }

        return list;
    }

    private void updateTextArea(List<Double> list, JTextArea textArea) {

        textArea.setText("");
        for (int i = 0; i < list.size(); i++) {


            if (i == list.size() - 1) {
                textArea.append("( " + list.get(i) + " ) x^" + i + " =0");
                return;
            }
            textArea.append("( " + list.get(i) + " ) x^" + i + " + ");
        }
    }
}
