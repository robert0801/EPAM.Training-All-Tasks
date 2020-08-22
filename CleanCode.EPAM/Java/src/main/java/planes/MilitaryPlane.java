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
    public boolean equals(Object comparedPlane) {
        if (!super.equals(comparedPlane)) return false;
        MilitaryPlane militaryPlane = (MilitaryPlane) comparedPlane;
        return militaryTypePlane == militaryPlane.getMilitaryTypePlane();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), militaryTypePlane);
    }
}
