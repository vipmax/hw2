package Task6;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

/**
 * Created by vipmax on 13.04.2014.
 */
public class Task6Form extends JFrame {
    private Task6 task6;
    private JLabel taskLabel;
    private JPanel rootPanel;
    private JTextArea textArea;
    private JButton calcButton;
    private JTextArea resultArea2;

    public Task6Form(Task6 task6) {
        this.task6 = task6;
        setContentPane(rootPanel);
        pack();
        setSize(800, 300);
        setVisible(true);

       calcButton.addActionListener(e-> {
           Set<Double> doubles = task6.setDoubleFromString(textArea.getText());
           textArea.setText("");
           doubles.forEach(elem -> textArea.append(elem.toString() + " "));
           System.out.println(doubles);
           Double value = task6.calc(doubles);
           resultArea2.setText(value.toString());
       });
    }
}
