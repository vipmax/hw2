package Task18;

import Services.FileService;
import com.sun.jnlp.FileOpenServiceImpl;

import javax.jnlp.FileOpenService;
import javax.jnlp.FileSaveService;
import javax.swing.*;
import javax.xml.ws.Service;
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
            } catch (NumberFormatException e1) {
                resultTextArea.setText("Что то введено не верно");
                return;
            }

            Queue<Ceil> queueWithCell = task18.getQueueWithCell(center, radius);
            resultTextArea.setText("");
            while (!queueWithCell.isEmpty()) {
                Ceil ceil = queueWithCell.remove();
                resultTextArea.append(ceil.toString() + " distance to center " + ceil.getDistanceTo(center.x, center.y) + "\n");
            }
            saveToFileButton.setEnabled(true);

        });

        saveToFileButton.addActionListener(e->{
            FileService.saveDataWithFileChooser(resultTextArea.getText());
        });

    }
}
