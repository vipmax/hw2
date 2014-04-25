package Task14;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Вершина
 * Created by vipmax on 20.04.2014.
 */
public class Vertex extends Ellipse2D.Float {

    java.util.List<Vertex> conjugateVertex;  //список сопряженныхвершин
    private boolean selected = false;

    public Vertex(int x, int y, int w, int h) {
        super(x, y, w, h);
        this.conjugateVertex = new ArrayList<>();

    }

    /**
     * удаляет связи
     */
    public void removeConjVertex() {
        for (int i = 0; i < conjugateVertex.size(); i++) {
            Vertex vertex = conjugateVertex.get(i);
            for (int i1 = 0; i1 < vertex.conjugateVertex.size(); i1++) {
                vertex.conjugateVertex.remove(this);
            }
        }

    }

    public List<Vertex> getConjugateVertex() {
        return conjugateVertex;
    }

    public boolean isConjugateVertex() {

        return !conjugateVertex.isEmpty();
    }

    public void addConjugateVertex(Vertex conjugateVertex) {

        this.conjugateVertex.add(conjugateVertex);

    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Point getLocation() {
        return new Point(
                (int) super.getMinX(), (int) super.getMinY()
        );
    }

    public void setLocation(Point location) {
        super.setFrame(
                location.getX(), location.getY(), getWidth(), getHeight()
        );
    }

}
