package Task22and23;

/**
 * Created by vipmax on 17.04.2014.
 */
public class Overtake {

    private Auto auto1;
    private Auto auto2;
    private Double overtakeTime;

    public Overtake(Auto auto1, Auto auto2) {
        this.auto1 = auto1;
        this.auto2 = auto2;
        overtakeTime = (auto2.getPosition() - auto1.getPosition()) * 3.6 / (auto1.getSpeed() - auto2.getSpeed());
    }

    public Double getOvertakeTime() {
        return overtakeTime;
    }

    @Override
    public String toString() {
        return auto1.toString() + " обгонит " + auto2.toString() + " через " + String.format("%.2f", overtakeTime) + " секунд";
    }

    public Auto getAuto2() {
        return auto2;
    }

    public Auto getAuto1() {
        return auto1;
    }
}
