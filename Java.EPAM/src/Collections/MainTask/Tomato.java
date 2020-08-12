package Collections.MainTask;

public class Tomato extends Vegetable {
    private final int calorieTomato = 200;
    private final String colorTomato = "Red";

    @Override
    public int getCalorieOfKilogram() {
        return calorieTomato;
    }

    public String getColorTomato() {
        return colorTomato;
    }

    public Tomato(double weight){
        super(weight);
    }
}
