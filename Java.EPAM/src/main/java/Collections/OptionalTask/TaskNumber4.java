/*Занести стихотворение в список. Провести сортировку по возрастанию длин строк.*/

package Collections.OptionalTask;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TaskNumber4 {
    static String poem = "У лукоморья дуб зелёный;\n" +
    "Златая цепь на дубе том:\n" +
    "И днём и ночью кот учёный\n " +
    "Всё ходит по цепи кругом;\n" +
    "Идёт направо - песнь заводит,\n" +
    "Налево - сказку говорит.\n" +
    "Там чудеса: там леший бродит,\n" +
    "Русалка на ветвях сидит";

    static Comparator<String> comparatorPoem = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    };

    public static void main(String[] args) {
        List<String> listPoem = Arrays.asList(poem.split("\n"));
        Collections.sort(listPoem, comparatorPoem);

        for (String linePoem : listPoem){
            System.out.println(linePoem);
        }

    }
}

