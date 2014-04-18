package Task15;

import java.util.Iterator;

/**
 * Created by vipmax on 15.04.2014.
 */
public class Task15 {
    private MyList myList;


    public Task15() {
        myList = new MyList();
        new Task15Form(this);
    }

    public void add(Double number) {
        myList.add(number);
    }
    public void delete(Double number) {
        myList.remove(number);
    }

    public Double find(Double number) {
        Iterator iterator = myList.iterator();
        Double min = (Double) iterator.next();

        while (iterator.hasNext()) {
            Double elem = (Double) iterator.next();
            if (Math.abs(elem - number) < Math.abs(min - number)) {
                min = elem;
            }
        }
        return min;
    }

    public String getListString() {
        return myList.toString();
    }


}
