package Task18;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.*;
import java.util.List;

/**
 * Created by vipmax on 24.04.2014.
 */
public class Task18 {


    public Task18() {
        new Task18Form(this);

    }





    public Collection<Ceil> getQueueWithCell(Point2D.Double center, Double radius) {
//        Queue<Ceil> ceilQueue = new PriorityQueue<>((ceil1, ceil2) ->  (int)(ceil1.getDistanceTo(center.x, center.y) - ceil2.getDistanceTo(center.x, center.y)));

        List<Ceil> ceils = new ArrayList<>();

        for (int dx = (int)(center.getX() - radius); dx < (int)(center.getX() + radius); dx++)
            for ( int dy = (int)(center.getY() - radius); dy < (int) (center.getY() + radius); dy++) {
                Ceil ceil = new Ceil(dx + 0.5, dy + 0.5);
                if (ceil.isInsideCircle(center, radius)) {
                    ceils.add(ceil);
                }
            }


        Collections.sort(ceils,(ceil1, ceil2) ->(int)(ceil1.getDistanceTo(center.x, center.y) - ceil2.getDistanceTo(center.x, center.y)));

        return ceils;
    }
}
