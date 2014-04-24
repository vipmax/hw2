package Task18;

import com.sun.jnlp.FileOpenServiceImpl;

import javax.jnlp.FileOpenService;
import javax.jnlp.FileSaveService;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by vipmax on 24.04.2014.
 */
public class Task18Form extends JFrame {
    private JPanel rootPanel;
    private JTextField radiusTextField;
    private JTextArea resultTextArea;
    private JButton analizeButton;
    private JButton saveToFileButton;
    private JTextField centerXTextField;
    private JTextField centerYTextField;
    private Task18 task18;

    public Task18Form(Task18 task18) {
        this.task18 = task18;
        setContentPane(rootPanel);
        pack();
        setSize(900, 500);
        setVisible(true);
        saveToFileButton.setEnabled(false);

        analizeButton.addActionListener(e-> {
            Double radius;
            Point2D.Double center;

            try {

                radius = Double.valueOf(radiusTextField.getText());
                if(radius<=0 ){resultTextArea.setText("Радиус не может быть меньше нуля");return;}
                Double x = Double.valueOf(centerXTextField.getText());
                Double y = Double.valueOf(centerYTextField.getText());
                center = new Point.Double(x, y);




//                queueWithCell.forEach(ceil -> resultTextArea.append(ceil.toString() + " distance to center " + ceil.getDistanceTo(center.x, center.y) + "\n"));
            } catch (NumberFormatException e1) {
                resultTextArea.setText("Что то введено не верно");
                return;
            }

            Collection<Ceil> queueWithCell = task18.getQueueWithCell(center, radius);
            resultTextArea.setText("");
            Iterator<Ceil> iterator = queueWithCell.iterator();
            while (iterator.hasNext()) {
                Ceil ceil = iterator.next();
                resultTextArea.append(ceil.toString() + " distance to center " + ceil.getDistanceTo(center.x, center.y) + "\n");
            }
            saveToFileButton.setEnabled(true);

        });

        saveToFileButton.addActionListener(e->{
            writeTextToFile(resultTextArea.getText());
        });

    }
    public void writeTextToFile(String text) {
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
        int saveDialog = fileChooser.showSaveDialog(null);
        if (saveDialog == JFileChooser.APPROVE_OPTION) {
           File file = fileChooser.getSelectedFile();
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

            try {
                java.io.FileWriter fw = new java.io.FileWriter(file);
                fw.write(text);
                fw.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }
}
