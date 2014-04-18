package Task11;

import Task10.Task10;

import javax.swing.*;
import java.io.File;
import java.util.*;

/**
 * Created by vipmax on 15.04.2014.
 */
public class Task11Form extends JFrame {

    private Task11 task11;
    private JPanel rootPanel;
    private JButton chooseFileButton;
    private JTextArea inputTextArea;
    private JButton showDifferentWordsButton;
    private JTextArea resultTextArea;

    public Task11Form(Task11 task11) {
        this.task11 = task11;
        setContentPane(rootPanel);
        pack();
        setSize(900, 500);
        setVisible(true);

        chooseFileButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int openDialog = fileChooser.showOpenDialog(null);
            if (openDialog == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                List<String> list = task11.listFromFile(selectedFile);
                task11.setList(list);
                inputTextArea.setText("");
                list.forEach(str -> inputTextArea.append(str + "\n"));
            }
        });

        showDifferentWordsButton.addActionListener(e-> {
            Map<String, Integer> stringIntegerMap = task11.toMap(task11.getList());



            resultTextArea.setText("");
            stringIntegerMap.forEach((key,value) ->{
                resultTextArea.append(key + " ("+value+")" + "\n");
            });

        });


    }
}