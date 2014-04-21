package Task20;

import javax.swing.*;
import java.awt.*;

/**
 * Created by vipmax on 21.04.2014.
 */
public class Task20Form extends JFrame {
    private Task20 task20;
    private JTextField rowTextField;
    private JTextField colTextField;
    private JButton buildMatrixButton;
    private JTextArea matrixTextArea;
    private JTextArea infoTextArea;
    private JTextArea resultTextArea;
    private JPanel rootPanel;

    public Task20Form(Task20 task20)  {
        this.task20 = task20;
        setContentPane(rootPanel);
        pack();
        setSize(900, 500);
        setVisible(true);

        buildMatrixButton.addActionListener(e-> {
            try {
                Integer row = Integer.valueOf(rowTextField.getText());
                Integer col = Integer.valueOf(colTextField.getText());
                task20.build(row, col);
                matrixTextArea.setText(task20.getMatrix().toString());
                resultTextArea.setText(task20.getResultMatrix().toString());
                infoTextArea.setText("");
                task20.getBuildInfo().forEach(line -> {
                    infoTextArea.append(line + "\n");
                });

            } catch (NumberFormatException e1) {
                return;
            }
        });
    }
}
