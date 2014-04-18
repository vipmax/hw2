package Task3;

import javax.swing.*;
import java.util.List;

/**
 * Created by vipmax on 13.04.2014.
 */
public class Task3Form extends JFrame {

    private Task3 task3;
    private JPanel rootPanel;

    private JButton sortButton;
    private JTextArea textArea1;

    public Task3Form(Task3 task3) {
        this.task3 = task3;
        setContentPane(rootPanel);
        pack();
        setSize(600, 500);
        setVisible(true);
        sortButton.addActionListener(e -> {

            String text = textArea1.getText();
            List<String> stringList = task3.listFromString(text);
            task3.sortList(stringList);
            textArea1.setText("");
            stringList.forEach(str -> textArea1.append(str + " (" + str.length() + ")\n"));
        });
    }
}
