package Task5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vipmax on 13.04.2014.
 */
public class Task5 {
    List<Double> listI, listU;

    public Task5() {
        listI = new ArrayList<>();
        listU = new ArrayList<>();

        new Task5Form(this);
    }

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
