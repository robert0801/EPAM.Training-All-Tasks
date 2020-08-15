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
        if (this == comparedPlane) return true;
        if (comparedPlane instanceof MilitaryPlane) return true;
        if (super.equals(comparedPlane)) return true;
        MilitaryPlane militaryPlane = (MilitaryPlane) comparedPlane;
        return militaryTypePlane == militaryPlane.militaryTypePlane;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), militaryTypePlane);
    }
}
