package Task14;

/**
 * Created by vipmax on 20.04.2014.
 */

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


public class VertexPainter extends JComponent {

    private static final Color SHAPE_COLOR = Color.RED;
    private static final Color SELECTED_SHAPE_COLOR = Color.YELLOW;
    private static final Color SELECTION_COLOR = new Color(150, 150, 250, 50);
    private static final Color SELECTION_BORDER_COLOR = new Color(10, 10, 10);
    private final static int VERTEX_SIZE = 50;


    private MouseHandler mouseHandler;
    private Collection<Vertex> vertexes;
    private Point selectionOrigin;
    private Point draggingDelta;
    private Vertex draggingVertex;

    public VertexPainter() {

        setOpaque(true);
        mouseHandler = new MouseHandler();
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);

        vertexes = new ArrayList<>();
    }

    public static void start(Integer countOfVertex) {
        JFrame frame = new JFrame();
        VertexPainter painter = new VertexPainter();
        painter.createVertex(countOfVertex);
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

    private void createVertex(Integer count) {
        for (int i = 0; i < count; i++) {

            vertexes.add(new Vertex(new Random().nextInt(700), new Random().nextInt(600), VERTEX_SIZE, VERTEX_SIZE));
        }
    }

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

    private class MouseHandler extends MouseInputAdapter {

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

        public void mouseReleased(MouseEvent e) {
            draggingDelta = null;
            draggingVertex = null;
            repaint();
        }

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