package Task19;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.*;
import java.util.List;

/**
 * Created by vipmax on 20.04.2014.
 */
public class Task19 {
    private List<Line> lineList;

    public Task19() {
        lineList = new ArrayList<>();
        new Task19Form(this);
    }

    public List<Line> getLineList() {
        return lineList;
    }

    public void addLine(Line line) {
        lineList.add(line);
    }

    public Intersection getInterSectionInfo(List<Line> lineList) {
        if (lineList.isEmpty()) {
            return null;
        }
        List<Line> temp = new ArrayList<>(lineList);
        Double minX = temp.get(0).getX1();
        if (temp.size() <= 1) {
            return null;
        }

        Line resultLine = temp.get(0), resultNextLine = temp.get(1);
        Intersection resultIntersection = new Intersection(resultLine, resultNextLine);

        for (int i = 0; i < temp.size(); i++) {
            Line line = lineList.get(i);
            for (int j = i + 1; j < temp.size(); j++) {
                try {

                    Line nextLine = lineList.get(j);
                    Intersection intersection = new Intersection(line, nextLine);

                    if (!intersection.isIntersection()) {
                        continue;
                    }
                    if (intersection.getX() < minX) {
                        minX = intersection.getX();
                        resultIntersection = intersection;
                    }


                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }

        }


        return resultIntersection;
    }
}
