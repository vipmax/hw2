package Task13;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Created by vipmax on 21.04.2014.
 */
public class Task13Form extends JFrame {

    private Task13 task13;

    private JTextField inputListTextField;
    private JTextArea textArea;
    private JTextField inputKTextField;
    private JTextArea resultTextArea;
    private JPanel rootPanel;

    public Task13Form(Task13 task13) {
        this.task13 = task13;
        setContentPane(rootPanel);
        pack();
        setSize(600, 300);
        setVisible(true);

        inputListTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {

                        task13.addToList(Integer.valueOf(inputListTextField.getText()));
                        inputListTextField.setText("");
                        updateTextArea();
                    } catch (NumberFormatException e1) {
                        e1.printStackTrace();
                        return;
                    }
                }
            }
        });

        inputKTextField.addActionListener(e-> {
            List<Integer> list = task13.getList();
            Task13.bubbleSort(list);
            Integer k = Integer.valueOf(inputKTextField.getText());
            boolean isShownK = false;

            resultTextArea.setText("[");

            for(Integer item:list){

                if (item >= k && !isShownK) {
                    isShownK = true;
                    resultTextArea.append(" k = "+k+", "+ item+", ");
                    continue;
                }
                resultTextArea.append(item + ",");
            };
            resultTextArea.append("]");

        });
    }

    private void updateTextArea() {
        textArea.setText(task13.getList().toString());
    }


}
