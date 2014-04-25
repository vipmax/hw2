package Task5;

import java.util.ArrayList;
import java.util.List;

/**
 * 5.Списки I(1..n) и U(1..n) содержат результаты n-измерений тока и напряжения на неизвестном сопротивлении R.
 * Найти приближенное число R методом наименьших квадратов.
 * Created by vipmax on 13.04.2014.
 */
public class Task5 {
    List<Double> listI, listU;

    public Task5() {
        listI = new ArrayList<>();
        listU = new ArrayList<>();

        new Task5Form(this);
    }

    /**
     * парсит текст в список чисел
     * @param text текст
     * @return список чисел
     */

    public List<Double> listDoubleFromString(String text) {

        String lines[] = text.split(" ");
        List<Double> list = new ArrayList<>();
        for (String line : lines) {
            if (line.isEmpty()) continue;
            try {
                list.add(Double.valueOf(line));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     *
     * @param listI список с значениями тока
     * @param listU список с значениями напряжений
     * @return  сопротивление R
     */
    public Double calculateR(List<Double> listI, List<Double> listU) {
        if (listI.size() != listU.size()) return null;

        int n = listI.size();
        Double summI = Double.valueOf(0), summU = Double.valueOf(0);
        for (int i = 0; i < n; i++) {
            summI += listI.get(i);
            summU += listU.get(i);
        }

        Double avgI = summI / n, avgU = summU / n;

        Double up = Double.valueOf(0), down = Double.valueOf(0);
        for (int i = 0; i < n; i++) {
            up += (listI.get(i) - avgI) * (listU.get(i) - avgU);
            down += ((listI.get(i) - avgI)) * ((listI.get(i) - avgI));
        }


        return up / down;
    }
}
