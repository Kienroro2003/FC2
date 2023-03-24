import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WriteAndRead {
    private final String path = "/Users/kienroro2003/Documents/My MacOS/DuyTan/Fundamentals of Computing/FC2/src/data/material.txt";

    public List<Material> readFile() {
        List<Material> list = new ArrayList<>();
        File file = new File(path);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] properties = line.split(",");
                Material material = new Material(properties[0], properties[1], properties[2], Integer.parseInt(properties[3]), Long.parseLong(properties[4]));
                list.add(material);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }


    public void writeFile(List<Material> list){
        File file = new File(path);

    }
}
