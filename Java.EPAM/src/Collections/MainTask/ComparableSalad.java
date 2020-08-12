package Collections.MainTask;

import java.util.Comparator;

public class ComparableSalad implements Comparator<Vegetable>{

    @Override
    public int compare(Vegetable o1, Vegetable o2) {
        return o1.getCalorieOfKilogram() - o2.getCalorieOfKilogram();
    }
}
