package Task8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vipmax on 14.04.2014.
 */
public class Task8 {

    public Task8() {
        new Task8Form(this);
    }

    public List<Double> mult(List<Double> list1, List<Double> list2) {

        List<Double> resultList = new ArrayList<>();
        int n = list1.size();
        int m = list2.size();


        for (int i = 0; i < n+m-1; i++) {
            resultList.add(i, 0.0);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <m; j++) {
                resultList.set(i + j, resultList.get(i + j) + list1.get(i) * list2.get(j));
            }
        }

        return resultList;
    }

}
