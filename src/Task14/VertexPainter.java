package Task14;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

/**
 * 14. Реализовать класс Graph, представляющий собой неориентированный граф.
 * В конструкторе класса передается количество вершин в графе.
 * Методы должны поддерживать быстрое добавление и удаление ребер.
 * Created by vipmax on 20.04.2014.
 * @see VertexPainter
 */
public class VertexPainter extends JComponent {

    private static final Color SHAPE_COLOR = Color.RED;
    private static final Color SELECTED_SHAPE_COLOR = Color.YELLOW;
    private static final Color SELECTION_BORDER_COLOR = new Color(10, 10, 10);
    private final static int VERTEX_SIZE = 50;

    private MouseHandler mouseHandler;
    private Collection<Vertex> vertexes;

    private Point draggingDelta;
    private Vertex draggingVertex;

    /**
     * конструктор
     * @param count количество ребер
     */
    public VertexPainter(Integer count) {
        setOpaque(true);
        mouseHandler = new MouseHandler();
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);
        vertexes = new ArrayList<>();
        for (int i = 0; i < count; i++)
            vertexes.add(new Vertex(new Random().nextInt(700), new Random().nextInt(600), VERTEX_SIZE, VERTEX_SIZE));

    }

    /**
     * создает окно с заданным количеством вершин
     * @param countOfVertex количество вершин
     */
    public static void start(Integer countOfVertex) {
        JFrame frame = new JFrame();
        VertexPainter painter = new VertexPainter(countOfVertex);

        frame.setBackground(Color.WHITE);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    painter.deleteSelectedVertex();
                }
            }
        });

        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setContentPane(painter);
        frame.setVisible(true);
    }

    /**
     * удаляет выделенную вершину
     */
    private void deleteSelectedVertex() {
        Iterator<Vertex> iterator = vertexes.iterator();
        while (iterator.hasNext()) {
            Vertex vertex = iterator.next();
            if (vertex.isSelected()) {
                vertex.removeConjVertex();
                iterator.remove();
                repaint();
                return;
            }
        }

    }

    /**
     * прорисовка всех компонентов-
     *
     */
    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D graphics2d = (Graphics2D) graphics;
        graphics2d.setColor(getBackground());
        graphics2d.fillRect(0, 0, getWidth(), getHeight());

        for (Vertex vertex : vertexes) {
            if (vertex.isConjugateVertex()) {
                (vertex).getConjugateVertex().forEach(conjVertex -> {
                    graphics2d.drawLine((int) vertex.getCenterX(), (int) vertex.getCenterY(), (int) conjVertex.getCenterX(), (int) conjVertex.getCenterY());

                });
            }
            if (vertex.isSelected()) {
                graphics2d.setColor(SELECTED_SHAPE_COLOR);
                graphics2d.fill(vertex);
                graphics2d.setColor(SELECTION_BORDER_COLOR);
                graphics2d.draw(vertex);
            } else {
                graphics2d.setColor(SHAPE_COLOR);
                graphics2d.fill(vertex);
            }
        }


    }


    /**
     * обработчик нажатий мыши
     */
    private class MouseHandler extends MouseInputAdapter {

        /**
         * перемещение мыши
         * @param e инфа о положении мыши
         */
        public void mouseDragged(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e)) {
                vertexes.stream().filter(vertex -> vertex.contains(e.getPoint())).forEach(vertex -> {
                    draggingVertex = vertex;
                });


                if (draggingVertex != null) {
                    if (draggingDelta == null) {
                        for (Vertex vertex : vertexes) {
                            vertex.setSelected(vertex == draggingVertex);
                        }

                        Point vertexLocation = draggingVertex.getLocation();
                        Point dragToLocation = e.getPoint();

                        draggingDelta = new Point(
                                dragToLocation.x - vertexLocation.x,
                                dragToLocation.y - vertexLocation.y
                        );
                    } else {
                        Point vertexLocation = draggingVertex.getLocation();
                        Point dragToLocation = e.getPoint();

                        vertexLocation.x = dragToLocation.x - draggingDelta.x;
                        vertexLocation.y = dragToLocation.y - draggingDelta.y;

                        draggingVertex.setLocation(vertexLocation);
                    }

                    repaint();
                    return;
                }
            }


            repaint();
        }

        /**
         * обработка события "кнопка отпущена"
         * @param e инфа о положении мыши
         */
        public void mouseReleased(MouseEvent e) {
            draggingDelta = null;
            draggingVertex = null;
            repaint();
        }

        /**
         *  обработка нажатия мыши
         * @param e инфа о положении мыши
         */
        public void mouseClicked(MouseEvent e) {


            if (SwingUtilities.isLeftMouseButton(e)) {
                boolean isSelected = false;
                for (Vertex vertex : vertexes) {
                    vertex.setSelected(vertex.contains(e.getPoint()));
                    if (vertex.isSelected()) {
                        isSelected = true;
                    }
                }
                if (e.getClickCount() == 2 && !isSelected) {

                    vertexes.add(new Vertex((int)e.getPoint().getX() -VERTEX_SIZE/2 ,(int) e.getPoint().getY()-VERTEX_SIZE/2, VERTEX_SIZE, VERTEX_SIZE));

                }
            }
            if (SwingUtilities.isRightMouseButton(e)) {
                boolean isSelected = false;
                Vertex selectedVertex = null;
                for (Vertex vertex : vertexes) {
                    if (vertex.isSelected()) {
                        isSelected = true;
                        selectedVertex = vertex;
                    }
                }
                if (isSelected) {
                    for (Vertex vertex : vertexes) {

                        if (vertex.contains(e.getPoint())) {

                            vertex.addConjugateVertex(selectedVertex);
                            selectedVertex.addConjugateVertex(vertex);

                        }
                    }
                }


            }


            repaint();
        }

    }


}