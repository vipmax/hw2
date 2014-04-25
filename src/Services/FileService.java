package Services;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vipmax on 25.04.2014.
 */
public class FileService {
    public static void saveDataWithFileChooser(String data) {
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
        int saveDialog = fileChooser.showSaveDialog(null);
        if (saveDialog == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

            try {
                java.io.FileWriter fw = new java.io.FileWriter(file);
                fw.write(data);
                fw.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static List<String> openFileWithFileChooser() {
        List<String> list=null;

        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
        int openDialog = fileChooser.showOpenDialog(null);
        if (openDialog == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();


            list = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    list.add(line);
                }

            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
        return list;
    }


}
