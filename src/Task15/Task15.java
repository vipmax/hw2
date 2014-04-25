package Task15;

import java.util.Iterator;

/**
 *15.	На базе коллекций реализовать структуру хранения чисел с поддержкой следующих операций:
 *  •	добавление/удаление числа;
 *  •	поиск числа, наиболее близкого к заданному (т.е. модуль разницы минимален).
 * Created by vipmax on 15.04.2014.
 */
public class Task15 {
    private MyList myList;


    public Task15() {
        myList = new MyList();
        new Task15Form(this);
    }

    /**
     * добавление
     * @param number добавляемое число
     */
    public void add(Double number) {
        myList.add(number);
    }

    /**
     * удаление
     * @param number удаляемое число число
     */
    public void delete(Double number) {
        myList.remove(number);
    }

    /**
     * поиск числа, наиболее близкого к заданному  ( т.е. модуль разницы минимален)
     * @param number заданное число
     * @return  число, наиболее близкое к заданному
     */
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
