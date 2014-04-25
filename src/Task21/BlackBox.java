package Task21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Черный ящик
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

    /**
     * Добавление числа
     * @param value число
     */
    public void add(T value) {
        list.add(value);
    }

    /**
     * возвращение K-го по минимальности числа из множества.
     * @param k число
     * @returnчисло
     * @throws IndexOutOfBoundsException
     */
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
