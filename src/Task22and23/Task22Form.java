package Task22and23;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;

/**
 * Created by vipmax on 17.04.2014.
 */
public class Task22Form extends JFrame {
    Task22 task22;
    private JTextField textField;
    private JTextArea textArea;
    private JButton defineButton;
    private JLabel resultLabel;
    private JPanel rootPanel;
    private JTextArea overtakeInfoTextArea;
    private JTextField firstKovertakeTextField;
    private JTextArea firstKovertakeTextArea;
    private JButton addAutoButton;
    private JLabel kLabel;

    public Task22Form(Task22 task22) {
        this.task22 = task22;
        setContentPane(rootPanel);
        pack();
        setSize(900,500);
        setVisible(true);


        textField.addActionListener(e -> {

            Integer countOfAuto;
            Pattern numberPattern = Pattern.compile("[1-9]([0-9])*");

            if (!numberPattern.matcher(textField.getText()).find()) {
                return;
            }

            countOfAuto = Integer.valueOf(textField.getText());
            task22.setAutoList(task22.createAutoList(countOfAuto));
            updateTextArea();

        });

        defineButton.addActionListener(e-> {
            Integer integer = task22.countOfOvertake(task22.getAutoList());
            resultLabel.setText(integer.toString());
            updateOvertakeInfoTextArea();
        });

        addAutoButton.addActionListener(e-> {
            new AddAutoDialog(this);
        });
        firstKovertakeTextField.addActionListener(e->{
            Integer k;
            Pattern numberPattern = Pattern.compile("[1-9]([0-9])*");

            if (!numberPattern.matcher(firstKovertakeTextField.getText()).find()) {
                return;
            }

            k = Integer.valueOf(firstKovertakeTextField.getText());
            if (k > task22.getOvertakeList().size()) {
                firstKovertakeTextArea.setText("Всего " + task22.getOvertakeList().size() + " обгонов. Введите другое число");
                return;
            }
            firstKovertakeTextArea.setText("");
            task22.getKOvertake(k).forEach(overtake -> firstKovertakeTextArea.append(overtake + "\n"));
        });

    }

    public void updateTextArea() {
        textArea.setText("");
        task22.getAutoList().forEach(auto -> textArea.append(auto + "\n"));
    }

    private void updateOvertakeInfoTextArea() {
        overtakeInfoTextArea.setText("");
        task22.getOvertakeList().forEach(overtake -> overtakeInfoTextArea.append(overtake + "\n"));
    }
    
    
}
