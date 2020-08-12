package Collections.MainTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Salad extends ComparableSalad {
    public static void main(String[] args) throws IOException {
        int maxCalorie = 0;
        int minCalorie = 0;
        double calorieSalad = 0;
        ComparableSalad comparableSalad = new ComparableSalad();
        double weightSomeVegetable = 0;
        String nameSomeVegetable = null;
        List<Vegetable> salad = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            try {
                System.out.println("Введите название овоща");
                nameSomeVegetable = reader.readLine().toUpperCase();
                System.out.println("Введите вес овоща");
                weightSomeVegetable = Double.parseDouble(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Введено некорректное число");
                break;
            }
            if (nameSomeVegetable.toUpperCase().equals("ПОМИДОР")) salad.add(new Tomato(weightSomeVegetable));
            else if (nameSomeVegetable.toUpperCase().equals("СВЕКЛА")) salad.add(new Beet(weightSomeVegetable));
            else if (nameSomeVegetable.toUpperCase().equals("ЛУК")) salad.add(new Onion(weightSomeVegetable));
            else if (nameSomeVegetable.toUpperCase().equals("ОГУРЕЦ")) salad.add(new Сucumber(weightSomeVegetable));
            else break;

        }

        for (Vegetable veg : salad) {
            calorieSalad += veg.getCalorieOfKilogram() * veg.getWeight();
        }
        System.out.println("Каллорийность салата " + calorieSalad);

        Collections.sort(salad, comparableSalad);

        System.out.println("Список овощей по их каллорийности");
        for (int i = 0; i < salad.size(); i++) {
            System.out.println(salad.get(i).getClass().getSimpleName() + " - " + salad.get(i).getCalorieOfKilogram());
        }

        try {
            if (calorieSalad > 0) {
                System.out.println("Введите минимальную каллорийность ");
                minCalorie = Integer.parseInt(reader.readLine());
                System.out.println("Введите максимальную каллорийность");
                maxCalorie = Integer.parseInt(reader.readLine());
            }
        } catch (NumberFormatException e) {
            System.out.println("Введено некорректное число");
        }

        for (Vegetable vegetable : salad){
            if (vegetable.getCalorieOfKilogram() >= minCalorie && vegetable.getCalorieOfKilogram() <= maxCalorie){
                System.out.println(vegetable.getClass().getSimpleName());
            }
        }
    }
}

