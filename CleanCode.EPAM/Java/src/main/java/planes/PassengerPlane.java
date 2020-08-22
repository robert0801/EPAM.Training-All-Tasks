package planes;

import java.util.Objects;

public class PassengerPlane extends Plane{

    //=================FIELDS=================
    private int passengersCapacity;

    //=================CONSTRUCTORS=================
    public PassengerPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, int passengersCapacity) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.passengersCapacity = passengersCapacity;
    }


    //=================METHODS=================
    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", passengersCapacity=" + passengersCapacity +
                '}');
    }

    @Override
    public boolean equals(Object comparedPlane) {
        if (!super.equals(comparedPlane)) return false;
        PassengerPlane passengerPlane = (PassengerPlane) comparedPlane;
        return passengersCapacity == passengerPlane.getPassengersCapacity();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengersCapacity);
    }
}
