package Task9;

import javax.swing.*;
import java.awt.*;

/**
 * Created by vipmax on 15.04.2014.
 */
public class Task9Form extends JFrame {
    private Task9 task9;
    private JTextArea textArea1;
    private JButton checkButton;
    private JTextField textField1;
    private JPanel rootPanel;

    public Task9Form(Task9 task9) {
        this.task9 = task9;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(rootPanel);
        pack();
        setSize(700, 300);
        setVisible(true);

        checkButton.addActionListener(e-> {
            String text = textArea1.getText();
            Boolean isValid = task9.validate(text);

            textField1.setText(isValid.toString());

        });
    }
}
