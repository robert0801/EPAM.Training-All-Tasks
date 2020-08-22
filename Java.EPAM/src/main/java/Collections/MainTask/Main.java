package Collections.MainTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main extends ComparableSalad {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String nameSomeVegetable = null;
    private static Double weightSomeVegetable = 0.0;
    private static Boolean weight = false;

    private static String addVegetablesToSalad() throws IOException {
        System.out.println("Введите название овоща (Tomato, Onion, Beet или Cucumber). Для прекращения ввода нажмите ENTER");
        nameSomeVegetable = reader.readLine().toUpperCase();
        if (!(nameSomeVegetable.toUpperCase().equals("TOMATO") ||
                nameSomeVegetable.toUpperCase().equals("BEET") ||
                nameSomeVegetable.toUpperCase().equals("ONION") ||
                nameSomeVegetable.toUpperCase().equals("CUCUMBER")) &&
                !nameSomeVegetable.equals("")) {
            System.out.println("Указанный овощ " + nameSomeVegetable + " отсутствует. " +
                    "Введите другое название или нажмите ENTER для остановки ввода.");
            addVegetablesToSalad();

        }
        return nameSomeVegetable;
    }

    private static void addWeightOfVegetables() {
        System.out.println("Введите вес овоща");
        weight = isDigit();
        if (weight == false) {
            System.out.println("Введено некорректное значение. Введите заново.");
            addWeightOfVegetables();
        }
    }

    private static boolean isDigit() {
        try {
            weightSomeVegetable = Double.parseDouble(reader.readLine());
            return true;
        } catch (NumberFormatException | IOException e) {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        int maxCalorie = 0;
        int minCalorie = 0;
        boolean flagOfCorrectCalorie = false;
        double calorieSalad = 0;
        ComparableSalad comparableSalad = new ComparableSalad();
        List<Vegetable> salad = new ArrayList<>();

        while (true) {
            if ((addVegetablesToSalad()).equals("")) break;
            else {
                addWeightOfVegetables();
            }
            if (nameSomeVegetable.toUpperCase().equals("TOMATO")) salad.add(new Tomato(weightSomeVegetable));
            else if (nameSomeVegetable.toUpperCase().equals("BEET")) salad.add(new Beet(weightSomeVegetable));
            else if (nameSomeVegetable.toUpperCase().equals("ONION")) salad.add(new Onion(weightSomeVegetable));
            else if (nameSomeVegetable.toUpperCase().equals("CUCUMBER")) salad.add(new Сucumber(weightSomeVegetable));
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
                System.out.println("Введите минимальную каллорийность");
                minCalorie = Integer.parseInt(reader.readLine());
                System.out.println("Введите максимальную каллорийность");
                maxCalorie = Integer.parseInt(reader.readLine());
            }
        } catch (NumberFormatException e) {
            System.out.println("Введено некорректное число");
        }

        for (Vegetable vegetable : salad){
            if (vegetable.getCalorieOfKilogram() >= minCalorie && vegetable.getCalorieOfKilogram() <= maxCalorie){
                flagOfCorrectCalorie = true;
                System.out.println(vegetable.getClass().getSimpleName());

            }
        }
        if (flagOfCorrectCalorie == false) {
            System.out.println("В указанном диапозоне каллорийности овощи отсутствуют.");
        }

    }
}


