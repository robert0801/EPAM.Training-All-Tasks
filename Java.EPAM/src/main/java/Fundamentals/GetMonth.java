package Fundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetMonth {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите номер месяца");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numMonth = Integer.parseInt(reader.readLine());
        if (numMonth >= 1 && numMonth <= 12) {
            switch (numMonth) {
                case 1:
                    System.out.println("January");
                    break;
                case 2:
                    System.out.println("February");
                    break;
                case 3:
                    System.out.println("March");
                    break;
                case 4:
                    System.out.println("April");
                    break;
                case 5:
                    System.out.println("May");
                    break;
                case 6:
                    System.out.println("June");
                    break;
                case 7:
                    System.out.println("July");
                    break;
                case 8:
                    System.out.println("August");
                    break;
                case 9:
                    System.out.println("September");
                    break;
                case 10:
                    System.out.println("October");
                    break;
                case 11:
                    System.out.println("November");
                    break;
                case 12:
                    System.out.println("December");
            }
        } else System.out.println("Такого месяца не существует");
    }
}
