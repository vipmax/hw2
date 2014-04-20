package Task21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by vipmax on 16.04.2014.
 */
public class BlackBox<T extends Number & Comparable<T>> {
    List<T> list;
    T K;

    public BlackBox() {
        list = new ArrayList<>();
    }

    public T getK() {
        return K;
    }

    public void setK(T k) {
        K = k;
    }

    public void add(T value) {
        list.add(value);
    }

    public T findMinK(T k) throws IndexOutOfBoundsException {
        Collections.sort(list);
        return list.get(k.intValue());
    }

    @Override
    public String toString() {
        Collections.sort(list);
        return list.toString();
    }
}
