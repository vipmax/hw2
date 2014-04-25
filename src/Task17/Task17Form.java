package Task17;

import Services.FileService;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * Created by vipmax on 21.04.2014.
 */
public class Task17Form extends JFrame{

    private Task17 task17;
    private JTextField xTextField;
    private JTextField yTextField;
    private JTextArea pointsTextArea;
    private JTextArea resultTextArea;
    private JButton saveToFileButton;
    private JPanel rootPanel;
    private JButton findLineButton;

    public Task17Form(Task17 task17) {
        this.task17 = task17;
        setContentPane(rootPanel);
        pack();
        setSize(900, 500);
        setVisible(true);
        saveToFileButton.setVisible(false);

        xTextField.addActionListener(e->{
            yTextField.requestFocus();
        });
        yTextField.addActionListener(e-> {
            try {
                Double x = Double.valueOf(xTextField.getText());
                Double y = Double.valueOf(yTextField.getText());
                Point point = new Point();
                point.setLocation(x,y);
                task17.getPoints().add(point);
                xTextField.setText("");
                yTextField.setText("");
                xTextField.requestFocus();
                updateTextArea();

            } catch (NumberFormatException e1) {
                return;
            }
        });
        saveToFileButton.addActionListener(e-> {
            FileService.saveDataWithFileChooser(resultTextArea.getText());
        });
        findLineButton.addActionListener(e -> {
            saveToFileButton.setVisible(true);
            Map<Line2D, Integer> thisLineMap = task17.getThisLineMap(task17.getPoints());
            task17.setThisLineMap(thisLineMap);
            resultTextArea.setText("");
            thisLineMap.forEach((line, val) -> {
                resultTextArea.append("(" + line.getX1() + ", " + line.getY1() + ") -> " + "(" + line.getX2() + ", " + line.getY2() + ")" + " имеет пересечение с " + val + " точками\n");
            });
        });

    }

    private void updateTextArea() {
        List<Point> points = task17.getPoints();
        pointsTextArea.setText("");
        points.forEach(point -> pointsTextArea.append("("+point.getX() + ", " + point.getY() +")\n"));
    }
}
