package Task1;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
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

        chooseFileButton.addActionListener(e -> {
            if(!textArea1.getText().isEmpty())
                textArea1.setText("");
            JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
            int openDialog = fileChooser.showOpenDialog(this);
            if (openDialog == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                List<String> strings = task1.listFromFile(selectedFile);
                task1.setStringList(strings);
                strings.forEach(str -> {
                    textArea1.append(str + "\n");

                });

                flipButton.setEnabled(true);
                saveInFileButton.setEnabled(true);
            }

        });

        saveInFileButton.addActionListener(e -> {
            String text = textArea1.getText();
            System.out.println(text);

            JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
            int saveDialog = fileChooser.showSaveDialog(this);
            if (saveDialog == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }

                task1.saveIntoFile(textArea1.getText(), file.getPath());
            }

        });
        flipButton.addActionListener(e -> {
            textArea1.setText("");
            List<String> strings = task1.flip(task1.getStringList());
            task1.setStringList(strings);
            strings.forEach(str -> textArea1.append(str + "\n"));
        });
    }
}
