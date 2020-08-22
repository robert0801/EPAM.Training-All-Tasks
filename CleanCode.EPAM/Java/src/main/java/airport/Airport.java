package airport;

import planes.ExperimentalPlane;
import models.MilitaryType;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;
import java.util.*;


public class Airport {
    private List<? extends Plane> listWithAllPlanes;

    public Airport(List<? extends Plane> planes) {
        this.listWithAllPlanes = planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        List<PassengerPlane> listWithAllPassengerPlanes = new ArrayList<>();
        for (Plane plane : listWithAllPlanes) {
            if (plane instanceof PassengerPlane) {
                listWithAllPassengerPlanes.add((PassengerPlane) plane);
            }
        }
        return listWithAllPassengerPlanes;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> listWithAllMilitaryPlanes = new ArrayList<>();
        for (Plane plane : listWithAllPlanes) {
            if (plane instanceof MilitaryPlane) {
                listWithAllMilitaryPlanes.add((MilitaryPlane) plane);
            }
        }
        return listWithAllMilitaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> listOfPassengerPlanes = getPassengerPlanes();
        PassengerPlane passengerPlaneWithMaxCapacity = listOfPassengerPlanes.get(0);
        for (int i = 0; i < listOfPassengerPlanes.size(); i++) {
            if (listOfPassengerPlanes.get(i).getPassengersCapacity() > passengerPlaneWithMaxCapacity.getPassengersCapacity()) {
                passengerPlaneWithMaxCapacity = listOfPassengerPlanes.get(i);
            }
        }
        return passengerPlaneWithMaxCapacity;
    }


    public List<MilitaryPlane> getTransportMilitaryPlanes() {
    List<MilitaryPlane> listOfTransportMilitaryPlanes = new ArrayList<>();
    List<MilitaryPlane> listOfMilitaryPlanes = getMilitaryPlanes();
    for (int i = 0; i < listOfMilitaryPlanes.size(); i++) {
        MilitaryPlane plane = listOfMilitaryPlanes.get(i);
        if (plane.getMilitaryTypePlane() == MilitaryType.TRANSPORT) {
            listOfTransportMilitaryPlanes.add(plane);
            }
        }
        return listOfTransportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> listOfBomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> listOfMilitaryPlanes = getMilitaryPlanes();
        for (int i = 0; i < listOfMilitaryPlanes.size(); i++) {
            MilitaryPlane plane = listOfMilitaryPlanes.get(i);
            if (plane.getMilitaryTypePlane() == MilitaryType.BOMBER) {
                listOfBomberMilitaryPlanes.add(plane);
            }
        }
        return listOfBomberMilitaryPlanes;

    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> listWithAllExperimentalPlanes = new ArrayList<>();
        for (Plane plane : listWithAllPlanes) {
            if (plane instanceof ExperimentalPlane) {
                listWithAllExperimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return listWithAllExperimentalPlanes;
    }

    public Airport sortByMaxDistance() {
        Collections.sort(listWithAllPlanes, new Comparator<Plane>() {
            public int compare(Plane firstComparedPlane, Plane secondComparedPlane) {
                return firstComparedPlane.getMaxFlightDistance() - secondComparedPlane.getMaxFlightDistance();
            }
        });
        return this;
    }

    public Airport sortByMaxSpeed() {
        Collections.sort(listWithAllPlanes, new Comparator<Plane>() {
            public int compare(Plane firstComparedPlane, Plane secondComparedPlane) {
                return firstComparedPlane.getMaxSpeed() - secondComparedPlane.getMaxSpeed();
            }
        });
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(listWithAllPlanes, new Comparator<Plane>() {
            public int compare(Plane firstComparedPlane, Plane secondComparedPlane) {
                return firstComparedPlane.getMaxLoadCapacity() - secondComparedPlane.getMaxLoadCapacity();
            }
        });
        return this;
    }

    public List<? extends Plane> getListWithAllPlanes() {
        return listWithAllPlanes;
    }

    private void printPlaneOnAirport(Collection<? extends Plane> collection) {
        Iterator<? extends Plane> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Plane plane = iterator.next();
            System.out.println(plane);
        }
    }

    @Override
    public String toString() {
        return "airport.Airport{" +
                "Planes=" + listWithAllPlanes.toString() +
                '}';
    }

}
