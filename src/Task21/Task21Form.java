package Task21;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by vipmax on 16.04.2014.
 */
public class Task21Form extends JFrame {
    private Task21 task21;
    private JTextField addTextField;
    private JTextArea textArea;
    private JTextField findTextField;
    private JLabel findResultLabel;
    private JPanel rootPanel;


    public Task21Form(Task21 task21) {
        this.task21 = task21;
        setContentPane(rootPanel);
        pack();
        setSize(900, 400);
        setVisible(true);
        addTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        task21.add(Integer.valueOf(addTextField.getText()));
                        addTextField.setText("");
                        textArea.setText(task21.getBlackboxString());
                    } catch (NumberFormatException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        findTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {


                    try {
                        Integer integer = task21.find(Integer.valueOf(findTextField.getText()));
                        findResultLabel.setText(integer.toString());

                    } catch (NumberFormatException e1) {
                        e1.printStackTrace();
                    } catch (IndexOutOfBoundsException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }
}
