package Collections.OptionalTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TaskNumber5 {
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите количество чисел, которое будет учавствовать в перестановке");
        int countNumber = Integer.parseInt(reader.readLine());
        List<Integer> listNoSort = new LinkedList<>();
        for (int i = 0; i < countNumber; i++){
            listNoSort.add(random.nextInt());
        }
        System.out.println("Исходный список чисел");
        for (Integer i : listNoSort){
            System.out.println(i);
        }

        int resFoSort = 0;
        for (int i = 0; i < listNoSort.size() - resFoSort; ){
            if (listNoSort.get(i) < 0){
                listNoSort.add(listNoSort.get(i));
                listNoSort.remove(listNoSort.get(i));
                resFoSort++;
            }
            else i++;
        }

        System.out.println("Сортированный список чисел");
        for (Integer i : listNoSort){
            System.out.println(i + " ");
        }
    }
}
