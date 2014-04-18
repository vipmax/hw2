package Task11;

import java.io.*;
import java.util.*;

/**
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



    public Map<String, Integer> toMap(List<String> list) {
        Map<String, Integer> map = new HashMap<>();

        list.forEach(line -> {
            String words[] = line.split(" ");

            for (String word : words) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word)+1);
                    continue;
                }
                map.put(word, 1);
            }

        });

        return  map;
    }
}

