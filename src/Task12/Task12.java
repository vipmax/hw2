package Task12;

import java.util.Iterator;
import java.util.List;

/**
 * Created by vipmax on 15.04.2014.
 */
public class Task12 {
    public Task12() {
        new Task12Form(this);
    }

    public void handleListPeople(List<People> list) {

//        while (list.size() > 1){
//
//            for (int i = 0; i<list.size(); i++){
//                if (i % 2 == 0){
//                   list.remove(i);
//                }
//            }
//        }

        while (list.size() > 1){
            Iterator iterator =  list.iterator();
            for (int i = 0; iterator.hasNext(); i++,iterator.next()){
                if (i % 2 == 1){
                    i=0;
                    iterator.remove();
                }
            }
        }
    }
}
