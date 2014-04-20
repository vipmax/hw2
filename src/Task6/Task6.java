package Task6;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by vipmax on 13.04.2014.
 */
public class Task6 {
    Set<Double> doubleSet;

    public Task6() {
        doubleSet = new TreeSet<>();
        new Task6Form(this);
    }

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
            System.out.println("tempSet = " + tempSet);
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
            System.out.println("set = " + set);
        }

        Double d = set.iterator().next();
        return d;

    }


}
