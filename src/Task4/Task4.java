package Task4;

/**
 * 4.Определяет 2 множества на основе множества целых чисел.
 * @see IntegerSet
 * Created by vipmax on 13.04.2014.
 */
public class Task4 {
    public IntegerSet set1;
    public IntegerSet set2;

    public Task4() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
        new Task4Form(this);
    }
}
