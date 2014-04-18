package Task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by vipmax on 13.04.2014.
 */
public class Task3 {
    private String text;

    public Task3() {
        new Task3Form(this);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> listFromString(String text) {

        String lines[] = text.split("\\r?\\n");
        List<String> list = new ArrayList<>();
        for (String line : lines) {
            list.add(line);
        }
        return list;
    }

    public void sortList(List<String> stringList) {
        Collections.sort(stringList, (a, b) -> b.length() - a.length());
    }
}
