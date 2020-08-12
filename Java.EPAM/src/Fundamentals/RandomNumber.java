package Fundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumber {
    public static void main(String[] args) throws IOException {

        Random random = new Random();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> number = new ArrayList<>();
        int countNumber = Integer.parseInt(reader.readLine());
        for (int i = 0; i < countNumber; i++) {
            number.add(random.nextInt());
        }

        for (Integer i : number){
            System.out.print(i);
        }

        System.out.println();

        for (Integer i : number){
            System.out.println(i);
        }

    }
}


