package Task19;

import javax.swing.*;
import java.util.Random;

/**
 * Created by vipmax on 20.04.2014.
 */
public class Task19Form extends JFrame {

    private Task19 task19;
    private JPanel rootPanel;
    private JTextField x1TextField;
    private JTextField y1TextField;
    private JTextField x2TextField;
    private JTextField y2TextField;
    private JTextArea textArea;
    private JButton addButton;
    private JButton defineButton;
    private JTextArea resultTextArea;
    private JButton randomButton;

    public Task19Form(Task19 task19) {
        this.task19 = task19;
        setContentPane(rootPanel);
        pack();
        setSize(900, 500);
        setVisible(true);
        y2TextField.addActionListener(e -> {
            addLine();
        });
        addButton.addActionListener(e -> {
            addLine();
        });
        defineButton.addActionListener(e -> {
            Intersection intersection = task19.getInterSectionInfo(task19.getLineList());
            if (intersection==null) {
                resultTextArea.setText("Нет точек пересечения");
                return;
            }
            resultTextArea.setText(intersection.toString());

        });
        randomButton.addActionListener(e -> {


            Random random = new Random();



            for (int i = 0; i < 5; i++) {
                task19.addLine(new Line(random.nextDouble()*10,random.nextDouble()*10,random.nextDouble()*10,random.nextDouble()*10));
            }
            updateTextArea();
        });
    }

    private void addLine() {
        Double x1, y1, x2, y2;

        try {
            x1 = Double.valueOf(x1TextField.getText());
            y1 = Double.valueOf(y1TextField.getText());
            x2 = Double.valueOf(x2TextField.getText());
            y2 = Double.valueOf(y2TextField.getText());
            Line line = new Line(x1, y1, x2, y2);
            task19.addLine(line);
            updateTextArea();
        } catch (NumberFormatException e1) {

        }
    }

    private void updateTextArea() {
        textArea.setText("");
        task19.getLineList().forEach(line -> textArea.append(line + "\n"));
    }
}
