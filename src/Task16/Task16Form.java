package Task16;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//12 1234 5 6322 2 1 3 gfdsfg 3 4 6 -3 5345g 445 g5 5  6 p 45t r 3 3 2 1

/**
 * Created by vipmax on 16.04.2014.
 */
public class Task16Form extends JFrame {
    private Task16 task16;
    private JButton chooseFileButton;
    private JTextArea inputTextArea;
    private JButton buildListButton;
    private JTextArea list1TextArea;
    private JTextArea list2TextArea;
    private JPanel rootPanel;

    public Task16Form(Task16 task16) {
        this.task16 = task16;
        setContentPane(rootPanel);
        pack();
        setSize(750, 400);
        setVisible(true);

        chooseFileButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int openDialog = fileChooser.showOpenDialog(null);
            if (openDialog == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                List<String> list = listLineFromFile(selectedFile);

                inputTextArea.setText("");
                list.forEach(str -> inputTextArea.append(str + "\n"));
            }

        });

        buildListButton.addActionListener(e -> {
            String s = inputTextArea.getText();

            if (inputTextArea.getSelectedText() != null) {
                s = inputTextArea.getSelectedText();
            }

            List<Double> first = new ArrayList<Double>();
            List<Double> second = new ArrayList<Double>();

            Boolean ok = parseString(s, first, second);

            if (ok) {
                Collections.sort(first, (o1, o2) -> new Double(o1 - o2).intValue());
                Collections.sort(second, (o1, o2) -> new Double(o2 - o1).intValue());
                list1TextArea.setText(first.toString());
                list2TextArea.setText(second.toString());
            } else {
                list1TextArea.setText("Не нашли отрицательный элемент");
                list2TextArea.setText("Не нашли отрицательный элемент");
            }
            inputTextArea.grabFocus();

        });
    }

    public Boolean parseString(String str, List<Double> first, List<Double> second) {
        boolean find = false;

        String[] lines = str.split(" ");

        for (String line : lines) {
            try {
                double parseDouble = Double.parseDouble(line);
                if (parseDouble < 0) {
                    find = true;
                    continue;
                }

                if (find) {
                    second.add(parseDouble);
                } else {
                    first.add(parseDouble);
                }


            } catch (NumberFormatException e) {
                e.printStackTrace();
                continue;
            }
        }

        if (!find) {
            first = null;
            second = null;
        }

        return find;
    }

    public List<String> listLineFromFile(File file) {

        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }


        return list;

    }
}
