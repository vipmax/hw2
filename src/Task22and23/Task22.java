package Task22and23;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 22 и 23.
 * На прямой гоночной трассе стоит N автомобилей,
 * для каждого из которых известны начальное положение и скорость.
 * Определить, сколько произойдет обгонов.
 * Вывести первые K обгонов
 * Created by vipmax on 17.04.2014.
 */
public class Task22 {
    private List<Auto> autoList;
    private List<Overtake> overtakeList;

    public Task22() {
        autoList = new ArrayList<>();
        new Task22Form(this);
    }

    /**
     *
     * @return список обгонов
     */
    public List<Overtake> getOvertakeList() {
        return overtakeList;
    }


   /**
     * @return список авто
     */
    public List<Auto> getAutoList() {
        return autoList;
    }

    public void setAutoList(List<Auto> autoList) {
        this.autoList = autoList;
    }

    /**
     * Создает список с рандомными авто
     * @param countOfAuto количество авто
     * @return список с рандомными авто
     */
    public List<Auto> createAutoList(Integer countOfAuto) {
        List<Auto> resultAutoList = new ArrayList<>();
        for (int i = 0; i < countOfAuto; i++) {
            resultAutoList.add(Auto.getRandomAuto());
        }
        return resultAutoList;
    }

    /**
     * @param autoList список машин
     * @return количество обгонов
     */
    public Integer countOfOvertake(List<Auto> autoList) {
        Integer count = 0;
        List<Auto> temp = new LinkedList<>(autoList);

        overtakeList = new ArrayList<>();
        while (!temp.isEmpty()) {
            for (int i = 1; i < temp.size(); i++) {
                try {
                    if (isOvertake(temp.get(0).copy(), temp.get(i).copy())) {
                        count++;
                    }
                } catch (IndexOutOfBoundsException e) { }
            }
            temp.remove(0);
        }


        return count;
    }

    private boolean isOvertake(Auto auto1, Auto auto2) {

        boolean auto1IsOvertake = auto1.getSpeed() > auto2.getSpeed() && auto1.getPosition() < auto2.getPosition();
        if (auto1IsOvertake) {
            overtakeList.add(new Overtake(auto1, auto2));
        }

        boolean auto2IsOvertake = auto2.getSpeed() > auto1.getSpeed() && auto2.getPosition() < auto1.getPosition();
        if (auto2IsOvertake) {
            overtakeList.add(new Overtake(auto2, auto1));
        }

        return auto1IsOvertake || auto2IsOvertake;
    }

    /**
     * возвращает список первых К обгонов
     * @param k число
     * @return список обгонов
     */
    public List<Overtake> getKOvertake(Integer k) {
        overtakeList.sort((o1, o2) -> (int) (o1.getOvertakeTime() - o2.getOvertakeTime()));
        List<Overtake> resultList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            resultList.add(overtakeList.get(i));
        }
        return resultList;
    }
}
