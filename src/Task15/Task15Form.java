package Task15;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by vipmax on 15.04.2014.
 */
public class Task15Form extends JFrame{
    private Task15 task15;
    private JTextField addTextField;
    private JTextField deleteTextField;
    private JTextArea textArea;
    private JTextField findTextField;
    private JLabel resultFindLabel;
    private JPanel rootPanel;

    public Task15Form(Task15 task15) {
        this.task15 = task15;
        setContentPane(rootPanel);
        pack();
        setSize(800, 300);
        setVisible(true);

        addTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    Double v;
                    try {
                        v = Double.parseDouble(addTextField.getText());
                    } catch (NumberFormatException e1) {
                        e1.printStackTrace();
                        return;
                    }
                    task15.add(v);
                    addTextField.setText("");
                    updateTextArea();

                }
            }
        });

        deleteTextField.addKeyListener( new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    Double v;
                    try {
                        v = Double.parseDouble(deleteTextField.getText());
                    } catch (NumberFormatException e1) {
                        e1.printStackTrace();
                        return;
                    }
                    task15.delete(v);
                    deleteTextField.setText("");
                    updateTextArea();

                }
            }
        });

        findTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    Double v;
                    try {
                        v = Double.parseDouble(findTextField.getText());
                    } catch (NumberFormatException e1) {
                        e1.printStackTrace();
                        return;
                    }
                    Double aDouble = task15.find(v);
                    resultFindLabel.setText(aDouble.toString());
                }
            }
        });
    }

    private void updateTextArea() {
        textArea.setText(task15.getListString());
    }
}
