package Task1;

import Services.FileService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by vipmax on 13.04.2014.
 */
public class Task1Form extends JFrame {
    Task1 task1;
    private JPanel rootPanel;
    private JTextArea textArea1;
    private JButton chooseFileButton;
    private JButton saveInFileButton;
    private JButton flipButton;

    public Task1Form(Task1 task1) {
        this.task1 = task1;
        setContentPane(rootPanel);
        pack();
        setSize(600, 500);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
            }
        });

        chooseFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                List<String> strings = FileService.openFileWithFileChooser();
                task1.setStringList(strings);
                if (!textArea1.getText().isEmpty())
                    textArea1.setText("");

                strings.forEach(str -> textArea1.append(str + "\n"));

                flipButton.setEnabled(true);
                saveInFileButton.setEnabled(true);


            }
        });

        saveInFileButton.addActionListener(e -> {
            FileService.saveDataWithFileChooser(textArea1.getText());
        });
        flipButton.addActionListener(e -> {
            textArea1.setText("");
            List<String> strings = task1.flip(task1.getStringList());
            task1.setStringList(strings);
            strings.forEach(str -> textArea1.append(str + "\n"));
        });
    }
}
