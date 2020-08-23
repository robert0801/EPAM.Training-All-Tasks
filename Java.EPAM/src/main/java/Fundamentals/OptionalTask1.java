/*1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
  2. Вывести числа в порядке возрастания (убывания) значений их длины.4
 */

package Fundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class OptionalTask1 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите количество чисел для выполнения задачи");

        int countNumber = Integer.parseInt(reader.readLine());
        int arrayNumber[] = new int[countNumber];
        String[] arrayString = new String[countNumber];
        for (int i = 0; i < arrayNumber.length; i++) {
            System.out.println("Введите число №" + (i + 1));
            arrayNumber[i] = Integer.parseInt(reader.readLine());
        }
        for (int i = 0; i < countNumber; i++){
            arrayString[i] = String.valueOf(arrayNumber[i]);
        }

        for (int i = 0; i < arrayString.length; i++){
            System.out.println(arrayString[i]);
        }

        for (int i = arrayString.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arrayString[j].length() > arrayString[j + 1].length()) {
                    String temp = arrayString[j + 1];
                    arrayString[j + 1] = arrayString[j];
                    arrayString[j] = temp;
                }
            }
        }

        System.out.println("Самое короткое число " + Integer.parseInt(arrayString[0]) + ", его длина " + arrayString[0].length());
        System.out.println("Самое длинное число " + Integer.parseInt(arrayString[arrayString.length - 1]) + ", его длина " + arrayString[arrayString.length - 1].length());

        System.out.println("Числа в порядке убывания значений их длины.");
        for (int i = arrayString.length - 1; i >= 0; i--){
            System.out.print(arrayString[i] + " ");
        }
        System.out.println();

        System.out.println("Числа в порядке возрастания значений их длины.");
        for (int i = 0; i < arrayString.length; i++){
            System.out.print(arrayString[i] + " ");
        }
    }
}

