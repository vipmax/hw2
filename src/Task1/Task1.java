package Task1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 1.Вводит строки из файла, записывает в список. Выводит строки в файл в обратном порядке.
 * Created by vipmax on 13.04.2014.
 */
public class Task1 {

    private List<String> stringList;

    public Task1() {
        stringList = new ArrayList<>();

        Task1Form form = new Task1Form(this);
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

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

    public List<String> flip(List<String> stringList) {
        List<String> newList = new ArrayList<>();

        for (int i = stringList.size() - 1; i >= 0; i--) {
            newList.add(stringList.get(i));
        }
        return newList;
    }


}
