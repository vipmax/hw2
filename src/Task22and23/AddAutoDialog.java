package Task22and23;

import javax.swing.*;
import java.awt.event.*;

public class AddAutoDialog extends JFrame {
    private final Task22Form task22Form;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField nameTextField;
    private JTextField speedTextField;
    private JTextField positionTextField;

    public AddAutoDialog(Task22Form task22Form) {
        this.task22Form = task22Form;
        setContentPane(contentPane);
        pack();
        setVisible(true);

        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> {
            onOK();
        });

        buttonCancel.addActionListener(e -> {
            onCancel();
        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(e -> {
            onCancel();
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        try {
            task22Form.task22.getAutoList().add(new Auto(nameTextField.getText(), Double.valueOf(speedTextField.getText()), Double.valueOf(positionTextField.getText())));
        } catch (NumberFormatException e) {
            onOK();
        }
        task22Form.updateTextArea();
        dispose();

    }

    private void onCancel() {
        dispose();
    }


}
