package Task22and23;

import java.util.Random;

/**
 * имена машин
 * Created by vipmax on 17.04.2014.
 */

public enum AutoName {
    BMW, FERRARI, MAZDA, LADA, ZAPOROJEC;

    /**
     *
     * @return рандомное имя
     */
    static String getRandomName() {
        int nextInt = new Random().nextInt(count());
        return AutoName.values()[nextInt].toString();

    }

    static Integer count() {
        return AutoName.values().length;
    }
}
