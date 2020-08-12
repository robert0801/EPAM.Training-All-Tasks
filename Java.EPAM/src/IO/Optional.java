package IO;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Optional {
    public static void main(String[] args) {
        questions1(30);
        questions2("C:/learn/Java_EPAM/JAVA.-FUNDAMENTALS-MAIN-TASK/src/OptionalTask1.java", "C:/learn/Java_EPAM/JAVA.-FUNDAMENTALS-MAIN-TASK/src/reverse.java");
        questions3("C:/learn/Java_EPAM/JAVA.-FUNDAMENTALS-MAIN-TASK/src/GetMonth.java", "C:/learn/Java_EPAM/JAVA.-FUNDAMENTALS-MAIN-TASK/src/reverse2.java");

    }

    public static void questions1(int countRandomNumbers){
        Random random = new Random();
        int[] randomArray = new int[countRandomNumbers];
        for (int i = 0; i < countRandomNumbers; i++){
            randomArray[i] = random.nextInt();
        }
        Arrays.sort(randomArray);
        try (FileWriter writer = new FileWriter("out/out.txt")){
            for (int i = 0; i < randomArray.length; i++){
                String s = Integer.toString(randomArray[i]);
                writer.write(s + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void questions2(String file, String fileOut){
        String s;
        ArrayList<String> mass = new ArrayList<>();
        String[] massString;
        try(BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut))){

            while ((s = reader.readLine()) != null){
                String line = "";
                mass = new ArrayList<>();
                massString = s.split(" ");

                for (int i = 0; i < massString.length; i++){
                    if (massString[i].equals("public")) massString[i] = "private";
                    line += (massString[i] + " ");
                }
                mass.add(line);

                for (String line1 : mass){
                    writer.write(line1 + "\n");

                }
            }



        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void questions3(String file, String fileOut){
        String s;
        try(BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut))){

            while ((s = reader.readLine()) != null){
                for( int i = s.length() - 1; i >= 0;i--)
                    writer.write(s.charAt(i));
                    writer.write("\n");
            }

            } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
