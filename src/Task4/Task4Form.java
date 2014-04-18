package Task4;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by vipmax on 13.04.2014.
 */
public class Task4Form extends  JFrame {

    private Task4 task4;
    private JTextField textField1;
    private JPanel rootPanel;
    private JTextArea textArea1;
    private JTextField textField2;
    private JTextArea textArea2;
    private JButton intersectionsButton;
    private JButton unionButton;
    private JTextArea resulTextArea;

    public Task4Form(Task4 task4) {
        this.task4 = task4;
        setContentPane(rootPanel);
        pack();
        setSize(800, 300);
        setVisible(true);

        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
               if(e.getKeyCode()== KeyEvent.VK_ENTER){
                   if(textField1.getText().matches("[0-9]+")){
                       Integer value =Integer.valueOf(textField1.getText());
                       task4.set1.add(value);
                       textArea1.setText(task4.set1.toString());
                       textField1.setText("");
                   }
               }
            }
        });
        textField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()== KeyEvent.VK_ENTER){
                    if(textField2.getText().matches("[0-9]+")){
                        Integer value =Integer.valueOf(textField2.getText());
                        task4.set2.add(value);
                        textArea2.setText(task4.set2.toString());
                        textField2.setText("");
                    }
                }
            }
        });

        intersectionsButton.addActionListener(e-> {
            resulTextArea.setText(task4.set1.intersection(task4.set2).toString());
        });
        unionButton.addActionListener(e->{
            resulTextArea.setText(task4.set1.union(task4.set2).toString());
        });
    }


}
