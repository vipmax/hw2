package Task11;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 11.Задан файл с текстом на английском языке.
 * Выделить все различные слова.
 * Для каждого слова подсчитать частоту его встречаемости.
 * Слова, отличающиеся регистром букв, считать различными.
 * Использовать класс HashMap.
 *
 * Created by vipmax on 15.04.2014.
 */
public class Task11 {
    private List<String> list;

    public Task11() {
        list = new ArrayList<>();
        new Task11Form(this);
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    /**
     * текст из файла записывает в список
     * @param file файл
     * @return список строк
     */
    public List<String> listFromFile(File file) {

        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }


        return list;

    }

    /**
     * возвращяет все различные слова с учетом частоты встречаемости.
     * @param list список строк с ьекстом
     * @return
     */
    public Map<String, Integer> toMap(List<String> list) {
        Map<String, Integer> map = new HashMap<>();

        list.forEach(line -> {
            String words[] = line.split(" ");

            for (String word : words) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                    continue;
                }
                map.put(word, 1);
            }

        });

        return map;
    }
}

