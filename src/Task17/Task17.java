package Task17;


import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vipmax on 21.04.2014.
 */
public class Task17 {

    Map<Line2D, Integer> thisLineMap;
    private List<Point> points;

    public Task17() {
        this.points = new ArrayList<>();
        new Task17Form(this);

    }

    public Map<Line2D, Integer> getThisLineMap() {
        return thisLineMap;
    }

    public void setThisLineMap(Map<Line2D, Integer> thisLineMap) {
        this.thisLineMap = thisLineMap;
    }

    public List<Point> getPoints() {
        return points;
    }

    public Map<Line2D, Integer> getThisLineMap(List<Point> pointList) {
        Map<Line2D, Integer> map = new HashMap<>();
        for (int i = 0; i < pointList.size(); i++) {
            for (int j = i; j < pointList.size(); j++) {

                Point p1 = pointList.get(i);
                Point p2 = pointList.get(j);
                if (p1.equals(p2)) {
                    continue;
                }
                Line2D.Double line = new Line2D.Double(p1, p2);

                map.put(line, 2);
            }
        }


        Map<Line2D, Integer> resultMap = new HashMap<>();

        map.forEach((line, value) -> {
            pointList.forEach(point -> {
                if (!line.getP1().equals(point) && !line.getP2().equals(point)) {
                    if (intersects(line, point)) {
                        System.out.println(line.getP1() + " " + line.getP2() + " пересекается с " + point.toString());
                        if (!resultMap.containsKey(line))
                            resultMap.put(line, value + 1);
                        else resultMap.replace(line, resultMap.get(line) + 1);
                    }
                }
            });
        });


        return resultMap;

    }

    public boolean intersects(Line2D line2D, Point p) {
        return line2D.ptLineDist(p) <= 0.01;
    }

}
