package Collections.OptionalTask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskNumber6 {
    public static void main(String[] args) throws IOException {
        String lineFromFile;
        BufferedReader reader = new BufferedReader(new FileReader("../../src/main/java/Collections/OptionalTask/output/"));

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

