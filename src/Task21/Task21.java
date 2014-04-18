package Task21;

/**
 * Created by vipmax on 16.04.2014.
 */
public class Task21 {
    BlackBox<Integer> blackBox;
    public Task21() {
        blackBox = new BlackBox<Integer>();
        new Task21Form(this);
    }

    public void add(Integer number) {
        blackBox.add(number);
    }
    public String getBlackboxString() {
        return blackBox.toString();
    }

    public Integer find(Integer k)throws IndexOutOfBoundsException{

        return blackBox.findMinK(k);
    }
}
