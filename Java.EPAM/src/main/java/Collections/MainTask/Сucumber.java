package Collections.MainTask;

public class Сucumber extends Vegetable {
    private final int calorieCucumber = 150;
    private final String colorCucumber = "Green";

    @Override
    public int getCalorieOfKilogram() {
        return calorieCucumber;
    }

    public String getColorCucumber() {
        return colorCucumber;
    }

    public Сucumber(double weight){
        super(weight);
    }
}
