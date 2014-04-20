package Task4;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by vipmax on 13.04.2014.
 */
public class IntegerSet {
    Set<Integer> set;

    public IntegerSet() {
        set = new TreeSet<>();
    }

    public IntegerSet(Integer... integers) {
        super();
        for (Integer integer : integers) {
            add(integer);
        }
    }

    public IntegerSet(IntegerSet set) {
        this.set = new TreeSet<>(set.set);
    }

    public void add(Integer integer) {
        set.add(integer);
    }

    public void remove(Integer integer) {
        set.remove(integer);
    }

    public IntegerSet intersection(IntegerSet set) {
        IntegerSet intersection = new IntegerSet(this);
        intersection.set.retainAll(set.set);
        return intersection;

    }

    public IntegerSet union(IntegerSet set) {
        IntegerSet union = new IntegerSet(this);
        union.set.addAll(set.set);
        return union;
    }

    @Override
    public String toString() {
        return set.toString();
    }
}
