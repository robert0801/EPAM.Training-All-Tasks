package airport;

import planes.ExperimentalPlane;
import models.MilitaryType;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.*;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    private List<? extends Plane> planes;



    public List<PassengerPlane> getPassengerPlanes() {
        List<? extends Plane> allPlanesOnAirport = this.planes;
        List<PassengerPlane> passengerPlanesOnAirport = new ArrayList<>();
        for (Plane plane : allPlanesOnAirport) {
            if (plane instanceof PassengerPlane) {
                passengerPlanesOnAirport.add((PassengerPlane) plane);
            }
        }
        return passengerPlanesOnAirport;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanesOnAirport = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanesOnAirport.add((MilitaryPlane) plane);
            }
        }
        return militaryPlanesOnAirport;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanesOnAirport = getPassengerPlanes();
        PassengerPlane passengerPlaneWithMaxCapacity = passengerPlanesOnAirport.get(0);
        for (int i = 0; i < passengerPlanesOnAirport.size(); i++) {
            if (passengerPlanesOnAirport.get(i).getPassengersCapacity() > passengerPlaneWithMaxCapacity.getPassengersCapacity()) {
                passengerPlaneWithMaxCapacity = passengerPlanesOnAirport.get(i);
            }
        }

        return passengerPlaneWithMaxCapacity;
    }


    public List<MilitaryPlane> getTransportMilitaryPlanes() {
    List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
    List<MilitaryPlane> militaryPlanesOnAirport = getMilitaryPlanes();
    for (int i = 0; i < militaryPlanesOnAirport.size(); i++) {
    MilitaryPlane plane = militaryPlanesOnAirport.get(i);
    if (plane.getMilitaryTypePlane() == MilitaryType.TRANSPORT) {
    transportMilitaryPlanes.add(plane);
    }
    }
    return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanesOnAirport = getMilitaryPlanes();
        for (int i = 0; i < militaryPlanesOnAirport.size(); i++) {
            MilitaryPlane plane = militaryPlanesOnAirport.get(i);
            if (plane.getMilitaryTypePlane() == MilitaryType.BOMBER) {
                bomberMilitaryPlanes.add(plane);
            }
        }
        return bomberMilitaryPlanes;

    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanesOnAirport = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlanesOnAirport.add((ExperimentalPlane) plane);
            }
        }
        return experimentalPlanesOnAirport;
    }

    public Airport sortByMaxDistance() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane firstComparePlane, Plane secondComparePlane) {
                return firstComparePlane.getMaxFlightDistance() - secondComparePlane.getMaxFlightDistance();
            }
        });
        return this;
    }

    public Airport sortByMaxSpeed() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane firstComparePlane, Plane secondComparePlane) {
                return firstComparePlane.getMaxSpeed() - secondComparePlane.getMaxSpeed();
            }
        });
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane firstComparePlane, Plane secondComparePlane) {
                return firstComparePlane.getMaxLoadCapacity() - secondComparePlane.getMaxLoadCapacity();
            }
        });
        return this;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
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
                "Planes=" + planes.toString() +
                '}';
    }

    //Constructor
    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

}
