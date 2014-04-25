package Task7;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vipmax on 14.04.2014.
 */
public class Task7Form extends JFrame {
    private Task7 task7;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton summButton;
    private JTextArea resultTextArea3;
    private JPanel rootPanel;

    public Task7Form(Task7 task7) {
        this.task7 = task7;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(rootPanel);
        pack();
        setSize(700, 300);
        setVisible(true);
        summButton.addActionListener(e -> {
            String values1 = textArea1.getText();
            String values2 = textArea2.getText();

            Map<Integer, Double> map1 = toMap(values1);
            Map<Integer, Double> map2 = toMap(values2);

            Map<Integer, Double> summ = task7.summ(map1, map2);

            updateTextArea(map1, textArea1);
            updateTextArea(map2, textArea2);
            updateTextArea(summ, resultTextArea3);

        });
    }


    private void updateTextArea(Map<Integer, Double> summ, JTextArea textArea) {
        textArea.setText("");
        summ.forEach((key, val) -> {
            boolean tail = key == summ.size() - 1;
            if (tail) {
                textArea.append("( " + val + " ) x^" + key + " =0");
                return;
            }
            textArea.append("( " + val + " ) x^" + key + " + ");
        });

        return;

    }

    public Map<Integer, Double> toMap(String values1) {
        String values1StringArr[] = values1.split(" ");
        List<Double> values1List = new ArrayList<>();

        for (String value1 : values1StringArr) {
            if (value1.isEmpty()) continue;
            try {
                values1List.add(Double.valueOf(value1));
            } catch (NumberFormatException e) {
            }
        }

        Map<Integer, Double> map = new HashMap<>();
        for (int i = 0; i < values1List.size(); i++) {
            map.put(i, values1List.get(i));
        }

        return map;
    }
}
