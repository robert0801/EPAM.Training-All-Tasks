package Fundamentals;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class OptionalTask2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите размерность матрицы");
        int N = Integer.parseInt(reader.readLine());
        int [][] array = new int[N][N];
        System.out.println("Введите диапозон для Random");
        int sizeMatrix = Integer.parseInt(reader.readLine());
        System.out.println("Введите номер строки, по которой будет производится сортировка");
        int numLine = Integer.parseInt(reader.readLine());
        numLine--;
        Random random = new Random();
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                array[i][j] = - sizeMatrix + random.nextInt(2 * sizeMatrix + 1);
            }
        }
        System.out.println("Матрица до сортировки");
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        System.out.println("Матрица после сортировки");
        for (int j = 0; j < N; j++){
            for (int k = j + 1; k < N; k++) {
                if (array[numLine][j] > array[numLine][k]) {
                    for (int i = 0; i < N; i++) {
                        int temp = array[i][j];
                        array[i][j] = array[i][k];
                        array[i][k] = temp;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
