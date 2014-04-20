package Task14;

import javax.swing.*;

/**
 * Created by vipmax on 20.04.2014.
 */
public class Task14Form extends JFrame {
    private JTextField textField1;
    private JButton beginButton;
    private JTextArea textArea1;
    private JPanel rootPanel;

    public Task14Form() {
        setContentPane(rootPanel);
        pack();
        setSize(700, 200);
        setVisible(true);
        textArea1.setText("Для добавления вершин - двойной щелчек\n" +
                "Для выделения вершины щелчек лкм по вершине\n" +
                "Для удаления вершины - Del(вершина должна быть выделена)\n" +
                "Для добавления ребер необходимо выделить вершину и нажать пкм на другую вершину");

        beginButton.addActionListener(e -> {
            Integer countOfVertex = null;
            try {
                countOfVertex = Integer.valueOf(textField1.getText());
                new VertexPainter().start(countOfVertex);
            } catch (NumberFormatException e1) {
                e1.printStackTrace();
            }
        });
    }
}
