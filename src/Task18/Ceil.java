package Task18;

import java.awt.geom.Point2D;

/**
 * Клетка
 * Created by vipmax on 24.04.2014.
 */
public class Ceil {

    private Double xPosCenter;
    private Double yPosCenter;

    public Ceil(Double xPos, Double yPos) {
        this.xPosCenter = xPos;
        this.yPosCenter = yPos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ceil)) return false;

        Ceil ceil = (Ceil) o;

        if (xPosCenter != null ? !xPosCenter.equals(ceil.xPosCenter) : ceil.xPosCenter != null) return false;
        if (yPosCenter != null ? !yPosCenter.equals(ceil.yPosCenter) : ceil.yPosCenter != null) return false;

        return true;
    }

    /**
     * рассчитавает расстоянито до некоторой точки
     * @param x абсцисса точки
     * @param y ордината
     * @return расстояние до точки
     */
    public Double getDistanceTo(Double x, Double y) {
        return Math.pow(x - xPosCenter, 2) + Math.pow(y - yPosCenter, 2);
    }

    @Override
    public int hashCode() {
        int result = xPosCenter != null ? xPosCenter.hashCode() : 0;
        result = 31 * result + (yPosCenter != null ? yPosCenter.hashCode() : 0);
        return result;
    }

    public Double getyPosCenter() {
        return yPosCenter;
    }

    public void setyPosCenter(Double yPosCenter) {
        this.yPosCenter = yPosCenter;
    }

    public Double getxPosCenter() {
        return xPosCenter;
    }

    public void setxPosCenter(Double xPosCenter) {
        this.xPosCenter = xPosCenter;
    }

    @Override
    public String toString() {
        return "[" + xPosCenter + " " + yPosCenter + "]";
    }

    /**
     * проверяет внутри  ли круга  текущая точка
     * @param center центр круга
     * @param radius радиус круга
     * @return  внутри  ли круга  текущая точка
     */
    public boolean isInsideCircle(Point2D.Double center, Double radius) {
        boolean isInside;

        boolean isUpRigth = Math.pow(center.getX() - xPosCenter - 0.5, 2) + Math.pow(center.getY() - xPosCenter - 0.5, 2) < Math.pow(radius, 2);
        boolean isUpLeft = Math.pow(center.getX() - xPosCenter + 0.5, 2) + Math.pow(center.getY() - xPosCenter - 0.5, 2) < Math.pow(radius, 2);
        boolean isDownRigth = Math.pow(center.getX() - xPosCenter + 0.5, 2) + Math.pow(center.getY() - xPosCenter + 0.5, 2) < Math.pow(radius, 2);
        boolean isDownleft = Math.pow(center.getX() - xPosCenter - 0.5, 2) + Math.pow(center.getY() - xPosCenter + 0.5, 2) < Math.pow(radius, 2);

        isInside = isUpRigth && isUpLeft && isDownRigth && isDownleft;
        return isInside;
    }
}
