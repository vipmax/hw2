package Task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 2.Создает список из элементов каталога и его подкаталогов.
 * Created by vipmax on 13.04.2014.
 */
public class Task2 {
    private List<File> dir = new ArrayList<File>();


    public Task2() {
        Task2Form task2Form = new Task2Form(this);
    }

    /**
     * возвращает список подпапок папки
     * @param path путь папки
     * @return Список подпапок папки
     */
    public List<String> dirListFromFilePath(String path) {

        File myDir = new File(path);
        dir = list(myDir);
        List<String> stringList = new ArrayList<>();
        dir.forEach(file -> {
            stringList.add(file.getPath());
        });
        return stringList;
    }

    private List<File> list(File file) {
        File[] currentDir = file.listFiles();
        for (int i = 0; i < currentDir.length; i++) {
            if (currentDir[i].isDirectory()) {
                dir.add(currentDir[i]);
                list(currentDir[i]);
            }
        }
        return dir;
    }
}
