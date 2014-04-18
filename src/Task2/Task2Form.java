package Task2;

import javax.swing.*;
import java.io.File;
import java.util.List;

/**
 * Created by vipmax on 13.04.2014.
 */
public class Task2Form extends JFrame {
    private DefaultListModel<String> dirListModel;
    private JButton chooseDirButton;
    private JList<String> dirList;
    private JPanel rootPanel;
    private Task2 task2;

    public Task2Form(Task2 task2) {
        this.task2 = task2;
        setContentPane(rootPanel);
        pack();
        setSize(600, 500);
        setVisible(true);
        dirListModel = new DefaultListModel<>();
        this.dirList.setModel(dirListModel);


        chooseDirButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int openDialog = fileChooser.showOpenDialog(null);
            if (openDialog == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                List<String> dirList = task2.dirListFromFilePath(selectedFile.getPath());

                dirList.forEach(dirListModel::addElement);
            }
        });
    }
}
