package Task5;

import javax.swing.*;
import java.util.List;

/**
 * Created by vipmax on 13.04.2014.
 */
public class Task5Form extends JFrame {

    private Task5 task5;
    private JPanel rootPanel;

    private JTextArea ItextArea1;
    private JTextArea UtextArea2;
    private JTextArea RtextArea3;
    private JButton calcButton;

    public Task5Form(Task5 task5) {
        this.task5 = task5;
        setContentPane(rootPanel);
        pack();
        setSize(1100, 300);
        setVisible(true);

        calcButton.addActionListener(e -> {

            List<Double> listI = task5.listDoubleFromString(ItextArea1.getText());
            List<Double> listU = task5.listDoubleFromString(UtextArea2.getText());

            ItextArea1.setText("");
            UtextArea2.setText("");
            listI.forEach(elem -> ItextArea1.append(elem.toString() + " "));
            listU.forEach(elem -> UtextArea2.append(elem.toString() + " "));

            if (listI.size() != listU.size()) {
                RtextArea3.setText("Размеры списков не равны!");
                return;
            }

            Double R = task5.calculateR(listI, listU);
            RtextArea3.setText(R.toString());

            System.out.println(listI + "\n" + listU);
        });


    }


}
