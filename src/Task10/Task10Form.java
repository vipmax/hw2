package Task10;

import Services.FileService;

import javax.swing.*;
import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * Created by vipmax on 15.04.2014.
 */
public class Task10Form extends JFrame {

    private Task10 task10;
    private JPanel rootPanel;
    private JButton chooseFileButton;
    private JTextArea inputTextArea;
    private JButton showDifferentWordsButton;
    private JTextArea resultTextArea;

    public Task10Form(Task10 task10) {
        setContentPane(rootPanel);
        pack();
        setSize(600, 500);
        setVisible(true);

        chooseFileButton.addActionListener(e -> {

                List<String> list = FileService.openFileWithFileChooser();
                task10.setList(list);
                inputTextArea.setText("");
                list.forEach(str -> inputTextArea.append(str + "\n"));

        });

        showDifferentWordsButton.addActionListener(e -> {
            Set<String> set = task10.toSet(task10.getList());
            resultTextArea.setText("");
            set.forEach(elem -> resultTextArea.append(elem + "\n"));
        });
    }
}
