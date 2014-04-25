package Task10;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 10. Задан файл с текстом на английском языке.
 * Выделить все различные слова.
 * Слова, отличающиеся  только регистром букв, считать одинаковыми.
 * Использовать класс HashSet.
 *
 * Created by vipmax on 15.04.2014.
 */
public class Task10 {
    private List<String> list;

    public Task10() {
        list = new ArrayList<>();
        new Task10Form(this);
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

        System.out.println(list);
        return list;

    }


    /**
     *  возвращает все различные слова из списка строк с текстом.
     * @param list список строк с текстом
     * @return  множество слов
     */
    public Set<String> toSet(List<String> list) {
        Set<String> set = new HashSet<>();

        list.forEach(line -> {
            String words[] = line.split(" ");

            for (String word : words) {
                set.add(word.toLowerCase());
            }

        });

        return set;
    }
}
