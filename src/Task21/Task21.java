package Task21;

/**
 * 21.	Реализовать структуру "черный ящик", хранящую множество чисел и имеющую внутреннее число K.
 * Структура должна поддерживать операции добавления числа в множество и возвращение K-го по минимальности числа из множества.
 * Created by vipmax on 16.04.2014.
 */
public class Task21 {
    BlackBox<Integer> blackBox;

    public Task21() {
        blackBox = new BlackBox<Integer>();
        new Task21Form(this);
    }

    /**
     * добавление числа в множество
     * @param number число
     */
    public void add(Integer number) {
        blackBox.add(number);
    }

    public String getBlackboxString() {
        return blackBox.toString();
    }

    /**
     * возвращение K-го по минимальности числа из множества.
     * @param k число
     * @return число
     * @throws IndexOutOfBoundsException
     */
    public Integer find(Integer k) throws IndexOutOfBoundsException {

        return blackBox.findMinK(k);
    }
}
