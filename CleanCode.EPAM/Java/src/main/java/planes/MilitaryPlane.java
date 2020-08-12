package planes;

import models.MilitaryType;

import java.util.Objects;

public class MilitaryPlane extends Plane{

    private MilitaryType militaryTypePlane;

    public MilitaryPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryType militaryTypePlane) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.militaryTypePlane = militaryTypePlane;
    }

    public MilitaryType getMilitaryTypePlane() {
        return militaryTypePlane;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", type=" + militaryTypePlane +
                '}');
    }

    @Override
    public boolean equals(Object planeForComparison) {
        if (this == planeForComparison) return true;
        if (!(planeForComparison instanceof MilitaryPlane)) return false;
        if (!super.equals(planeForComparison)) return false;
        MilitaryPlane that = (MilitaryPlane) planeForComparison;
        return militaryTypePlane == that.militaryTypePlane;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), militaryTypePlane);
    }
}
