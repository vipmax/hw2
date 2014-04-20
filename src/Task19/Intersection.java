package Task19;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Created by vipmax on 20.04.2014.
 */
public class Intersection {
    private Line line1;
    private Line line2;
    private Point.Double intersectionPoint;

    public Intersection(Line line1, Line line2) {

        this.line1 = line1;
        this.line2 = line2;
        this.intersectionPoint = line1.intersection(line2);
    }

    public Intersection(Intersection intersection) {

        if (intersection == null) {
            return;
        }
        this.line1 = intersection.line1;
        this.line2 = intersection.line2;
        this.intersectionPoint = line1.intersection(line2);
    }
    public Boolean isIntersection() {
        return intersectionPoint!=null;
    }

    public Line getLine1() {
        return line1;
    }

    public void setLine1(Line line1) {
        this.line1 = line1;
    }

    public Line getLine2() {
        return line2;
    }

    public void setLine2(Line line2) {
        this.line2 = line2;
    }

    public Double getX() {
        if (intersectionPoint == null) {
            return null;
        }
        return intersectionPoint.getX();
    }

    @Override
    public String toString() {
        return line1.toString() + " и " + line2.toString() +  " пересекаются в точке x=  " + String.format("%.2f", intersectionPoint.x);
    }

    public Intersection copy() {
        return new Intersection(new Line(this.line1), new Line(this.line2));
    }
}
