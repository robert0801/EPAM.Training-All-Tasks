package Collections.MainTask;

public class Onion extends Vegetable {
    private final int calorieOnion = 400;
    private final String colorOnion = "White";

    @Override
    public int getCalorieOfKilogram() {
        return calorieOnion;
    }

    public String getColorOnion() {
        return colorOnion;
    }
    public Onion(double weight){
        super(weight);
    }
}
