package Task12;

import javax.swing.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 12. В кругу стоят N человек, пронумерованных от 1 до N.
 * При ведении счета по кругу вычеркивается  каждый второй человек, пока не останется один.
 * Составить две программы, моделирующие процесс.
 * Одна из программ должна использовать класс ArrayList, а вторая – LinkedList.
 * Какая из двух  программ работает быстрее? Почему?
 * Created by vipmax on 15.04.2014.
 */
public class Task12 {
    public Task12() {
        new Task12Form(this);
    }

    /**
     * моделирует процесс
     * @see People
     * @param list список человек
     *
     */
    public void handleListPeople(List<People> list) {

//        while (list.size() > 1){
//
//            for (int i = 0; i<list.size(); i++){
//                if (i % 2 == 0){
//                   list.remove(i);
//                }
//            }
//        }

        while (list.size() > 1) {
            Iterator iterator = list.iterator();
            for (int i = 0; iterator.hasNext(); i++, iterator.next()) {
                if (i % 2 == 1) {
                    i = 0;
                    iterator.remove();
                }
            }
        }
    }
}
