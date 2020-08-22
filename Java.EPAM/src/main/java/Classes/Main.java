package Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main{

    public static void main(String[] args) throws IOException{
        ComparatorAbiturient comparatorAbiturient = new ComparatorAbiturient();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Abiturient> abiturientsList = new ArrayList<>();
        Abiturient Petrov = new Abiturient(1, "Petrov", "Petr", "Petrovovich",
                "Grodno", 12345, new int[]{10, 5, 6, 7});
        Abiturient Ivanov = new Abiturient(2, "Ivanov", "Ivan", "Ivanovich",
                "Minsk", 3123123, new int[]{4, 3, 9, 5});
        Abiturient Konon = new Abiturient(3, "Konon", "Aleksei", "Igorevich",
                "Gomel", 534121, new int[]{9, 8, 7, 6});
        Abiturient Cvetkov = new Abiturient(4, "Cvetkov", "Viktor", "Viktorovich",
                "SPB", 32131231, new int[]{4, 5, 7, 7});
        Abiturient Golub = new Abiturient(5, "Golub", "Artem", "Sergeevich",
                "Brest", 43534645, new int[]{1, 2, 10, 4});

        abiturientsList.add(Petrov);
        abiturientsList.add(Ivanov);
        abiturientsList.add(Konon);
        abiturientsList.add(Cvetkov);
        abiturientsList.add(Golub);

        System.out.println("Введите значение неудавлетворительной оценки");
        int minGrade = Integer.parseInt(reader.readLine());

        System.out.println("Список студентов, имеющих оценку ниже " + minGrade);
        for (Abiturient abiturient : abiturientsList){
            for (int i = 0; i < abiturient.getGradeStudent().length; i++) {
                if (abiturient.getGradeStudent()[i] < minGrade) {
                    System.out.println(abiturient.getFamily() + " " + abiturient.getName());
                    break;
                }
            }
        }

        System.out.println("Введите значение высокого среднего бала");
        double hightGrade = Double.parseDouble(reader.readLine());
        System.out.println("Список студентов, имеющих средний бал выше среднего ");
        for (Abiturient abiturient : abiturientsList){
            if (abiturient.ratingStudent(abiturient.getGradeStudent()) > hightGrade){
                System.out.println(abiturient);
            }
        }

        Collections.sort(abiturientsList, comparatorAbiturient);

        System.out.println("Укажите количество лучших абитуриентов, которых Вы хотите узнать");
        int bestAbiturient = Integer.parseInt(reader.readLine());
        for (int i = abiturientsList.size() - 1; i > abiturientsList.size() - 1 - bestAbiturient; i--){
            System.out.println(abiturientsList.get(i));
        }
    }
}
