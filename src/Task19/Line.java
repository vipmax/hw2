package Task19;

import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Created by vipmax on 20.04.2014.
 */
public class Line {

    private Double x1;
    private Double y1;
    private Double x2;
    private Double y2;
    private double k;
    private double b;


    public Line(Double x1, Double y1, Double x2, Double y2) {

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;


    }

    public Line(Line line) {
        this.x1 = new Double(line.x1);
        this.y1 = new Double(line.y1);
        this.x2 = new Double(line.x2);
        this.y2 = new Double(line.y2);
    }

    public Double getX1() {
        return x1;
    }

    public void setX1(Double x1) {
        this.x1 = x1;
    }

    public Double getY1() {
        return y1;
    }

    public void setY1(Double y1) {
        this.y1 = y1;
    }

    public Double getX2() {
        return x2;
    }

    public void setX2(Double x2) {
        this.x2 = x2;
    }

    public Double getY2() {
        return y2;
    }

    public void setY2(Double y2) {
        this.y2 = y2;
    }

    public Point.Double intersection(Line line) {
        boolean intersect = Line2D.linesIntersect(x1, y1, x2, y2, line.x1, line.y1, line.x2, line.y2);

        if (!intersect) {
            System.out.print("Не пересекаются ");
            System.out.print("this = " + this);
            System.out.println(" line = " + line);
            return null;
        }
        System.out.println("Пересекаются");
        System.out.print("this = " + this);
        System.out.print(" line = " + line);

        Double x = ((x1 * y2 - x2 * y1) * (line.x2 - line.x1) - (line.x1 * line.y2 - line.x2 * line.y1) * (x2 - x1)) / ((y1 - y2) * (line.x2 - line.x1) - (line.y1 - line.y2) * (x2 - x1));
        Double y = ((line.y1 - line.y2) * x - (line.x1 * line.y2 - line.y2 * line.y1)) / (line.x2 - line.x1);
        System.out.println(" в х= " + x);
        return new Point.Double(x, y);

    }


    @Override
    public String toString() {
        return "линия от (" + String.format("%.2f", x1) + " " + String.format("%.2f", y1) + ") до (" + String.format("%.2f", x2) + " " + String.format("%.2f", y2) + ")";
    }


}
