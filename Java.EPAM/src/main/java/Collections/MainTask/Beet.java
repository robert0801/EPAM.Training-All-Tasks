package Collections.MainTask;

public class Beet extends Vegetable {
    private final int calorieBeet = 430;
    private final String colorBeet = "Purple";

    @Override
    public int getCalorieOfKilogram() {
        return calorieBeet;
    }

    public String getColorBeet() {
        return colorBeet;
    }

    public Beet(double weight){
        super(weight);
    }
}
