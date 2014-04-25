package Task18;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.*;
import java.util.List;

/**
 * 18.	На клетчатой бумаге нарисован круг.
 * Вывести в файл описания всех клеток, целиком лежащих внутри круга, в порядке возрастания расстояния от клетки до центра круга.
 * Использовать класс PriorityQueue.
 * Created by vipmax on 24.04.2014.
 */
public class Task18 {


    public Task18() {
        new Task18Form(this);

    }

    /**
     * упорядоченная коллекция таких(смотри условие) точек
     * @see Ceil
     * @param center центр круга
     * @param radius радиус
     * @return
     */
    public Queue<Ceil> getQueueWithCell(Point2D.Double center, Double radius) {

        Queue<Ceil> ceilQueue = new PriorityQueue<>((ceil1, ceil2) ->  (int)(ceil1.getDistanceTo(center.x, center.y) - ceil2.getDistanceTo(center.x, center.y)));

        for (int dx = (int)(center.getX() - radius); dx < (int)(center.getX() + radius); dx++)
            for ( int dy = (int)(center.getY() - radius); dy < (int) (center.getY() + radius); dy++) {
                Ceil ceil = new Ceil(dx + 0.5, dy + 0.5);
                if (ceil.isInsideCircle(center, radius)) {
                    ceilQueue.add(ceil);
                }
            }



        return ceilQueue;
    }
}
