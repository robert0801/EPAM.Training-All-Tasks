/* Ввести строки из файла, записать в список ArrayList.
Выполнить сортировку строк, используя метод sort() из класса Collections.*/

package Collections.OptionalTask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskNumber6 {
    public static void main(String[] args) throws IOException {
        String pathFile = new File("").getAbsolutePath();
        int placeOfAppearanceInPath = pathFile.indexOf("Java.EPAM");
        pathFile = pathFile.substring(0, placeOfAppearanceInPath) + "Java.EPAM\\src\\main\\java\\" +
                "Collections\\OptionalTask\\output\\file.txt";
        BufferedReader reader = new BufferedReader(new FileReader(pathFile));

        String lineFromFile;

        List<String> textFromFile = new ArrayList<String>();
        while ((lineFromFile = reader.readLine()) != null){
            textFromFile.add(lineFromFile);
        }
        Collections.sort(textFromFile);

        for (String line : textFromFile){
            System.out.println(line);
        }
    }
}

