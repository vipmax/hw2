package Task6;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 6.С использованием множества выполнить попарное суммирование произвольного конечного ряда чисел по следующим правилам:
 * на первом этапе суммируются попарно рядом стоящие числа,
 * на втором этапе суммируются результаты первого этапа и т.д.
 * до тех пор, пока не останется одно число.
 * Created by vipmax on 13.04.2014.
 */
public class Task6 {
    Set<Double> doubleSet;

    public Task6() {
        doubleSet = new TreeSet<>();
        new Task6Form(this);
    }

    /**
     * парсит текст в множество чисел
     * @param text текст
     * @return множество чисел
     */
    public Set<Double> setDoubleFromString(String text) {

        String lines[] = text.split(" ");
        Set<Double> set = new TreeSet<>();
        for (String line : lines) {
            if (line.isEmpty()) continue;
            try {
                set.add(Double.valueOf(line));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return set;
    }

    /**
     * высчитывает такое число. смотри назначение класса
     * @param set множество
     * @return такое число
     */
    public Double calc(Set<Double> set) {
        Set<Double> tempSet = new TreeSet<>();
        while (set.size() > 1) {

            for (Iterator<Double> doubleIterator = set.iterator(); doubleIterator.hasNext(); ) {
                Double next = doubleIterator.next();
                doubleIterator.remove();
                Double nextnext = null;
                try {
                    nextnext = doubleIterator.next();
                    doubleIterator.remove();
                } catch (Exception e) {
                    nextnext = 0.0;
                }
                tempSet.add(next + nextnext);
            }
            for (Iterator<Double> doubleIterator = tempSet.iterator(); doubleIterator.hasNext(); ) {
                Double next = doubleIterator.next();
                doubleIterator.remove();

                Double nextnext = null;
                try {
                    nextnext = doubleIterator.next();
                    doubleIterator.remove();
                } catch (Exception e) {
                    nextnext = 0.0;
                }

                set.add(next + nextnext);
            }

        }

        Double d = set.iterator().next();
        return d;

    }


}
