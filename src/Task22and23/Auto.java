package Task22and23;

import java.util.Random;

/**
 * Авто
 * @author vipmax
 */
public class Auto {
    private String name;
    private Double speed;
    private Double position;

    public Auto(Double speed, Double position) {
        this.name = AutoName.getRandomName();
        this.speed = speed;
        this.position = position;
    }

    public Auto(String name, Double speed, Double position) {
        this.name = name;
        this.speed = speed;
        this.position = position;
    }

    /**
     * создает рандомное авто
     * @return рандомное авто
     */
    public static Auto getRandomAuto() {
        return new Auto(AutoName.getRandomName(), new Random().nextDouble() * 200, new Random().nextDouble() * 100);
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getPosition() {
        return position;
    }

    public void setPosition(Double position) {
        this.position = position;
    }

    public Auto copy() {
        return new Auto(new String(this.name), new Double(this.speed), new Double(this.position));
    }


    @Override
    public String toString() {
        return name + " Скорость " + String.format("%.2f", speed) + " км/ч Положение=" + String.format("%.2f", position) + " м";
    }
}
