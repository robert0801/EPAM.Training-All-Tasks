package Collections.MainTask;

public class Vegetable {
    private int calorieOfKilogram;
    private String color;
    private double weight;


    public double getWeight() {
        return weight;
    }

    public int getCalorieOfKilogram() {
        return calorieOfKilogram;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vegetable(double weight) {
        this.weight = weight;
    }

    public Vegetable(int calorieOfKilogram, String color) {
        this.calorieOfKilogram = calorieOfKilogram;
        this.color = color;
    }
}
