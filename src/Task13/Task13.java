package Task13;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vipmax on 21.04.2014.
 */
public class Task13 {
    List<Integer> list;

    public Task13() {
        list = new ArrayList<>();
        new Task13Form(this);
    }

    public static void bubbleSort(List<Integer> list) {

        for (int i = 0; i < list.size(); ++i)
            pullUp(list, i);
    }

    private static void pullUp(List<Integer> list, int index) {
        for (int j = list.size() - 1; j > index; --j) {
            if (list.get(j - 1) > list.get(j)) {
                swap(j, j - 1, list);
            }
        }
    }

    private static void swap(int index1, int index2, List<Integer> list) {
        list.set(index2, list.get(index2) + list.get(index1));
        list.set(index1, list.get(index2) - list.get(index1));
        list.set(index2, list.get(index2) - list.get(index1));
    }

    public List<Integer> getList() {
        return list;
    }

    public void addToList(Integer integer) {
        list.add(integer);
    }
}
