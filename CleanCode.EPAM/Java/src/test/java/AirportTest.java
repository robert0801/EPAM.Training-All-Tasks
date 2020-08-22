import airport.Airport;
import planes.ExperimentalPlane;
import models.ClassificationLevel;
import models.ExperimentalTypes;
import models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.Arrays;
import java.util.List;

public class AirportTest {
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private static PassengerPlane planeWithMaxPassengerCapacity =
            new PassengerPlane("Boeing-747", 980, 16100,
                    70500, 242);

    @Test
    public void checkThatListTransportMilitaryPlanesContainsCorrectPlanes() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> listWithTransportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        boolean isTransportMilitaryFlagPlane = false;
        for (MilitaryPlane militaryPlane : listWithTransportMilitaryPlanes) {
            if ((militaryPlane.getMilitaryTypePlane() == MilitaryType.TRANSPORT)) {
                isTransportMilitaryFlagPlane = true;
                break;
            }
        }
        Assert.assertTrue(isTransportMilitaryFlagPlane,
                "There are no correct planes in the list Transport Military planes.");
    }

    @Test
    public void checkThatSpecifiedPlaneMatchesPassengerPlaneWithMaxCapacity() {
        Airport airport = new Airport(planes);
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(expectedPlaneWithMaxPassengersCapacity, planeWithMaxPassengerCapacity,
                "Specified plane don't matches Passenger plane with max capacity.");
    }

    @Test
    public void checkThatNextPlaneMaxLoadCapacityIsHigherThanMaxCurrentLoadCapacity() {
        int numberOfPlaneMaxLoadCapacityIsLesserThanPreviouslyMaxLoadCapacity = 1;
        Airport airport = new Airport(planes);
        airport.sortByMaxLoadCapacity();
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.getListWithAllPlanes();

        boolean nextPlaneMaxLoadCapacityIsHigherThanCurrent = true;
        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            Plane currentPlane = planesSortedByMaxLoadCapacity.get(i);
            Plane nextPlane = planesSortedByMaxLoadCapacity.get(i + 1);
            if (currentPlane.getMaxLoadCapacity() > nextPlane.getMaxLoadCapacity()) {
                nextPlaneMaxLoadCapacityIsHigherThanCurrent = false;
                numberOfPlaneMaxLoadCapacityIsLesserThanPreviouslyMaxLoadCapacity = i;
                break;
            }
        }
        Assert.assertTrue(nextPlaneMaxLoadCapacityIsHigherThanCurrent,
                "Planes are not arranged in ascending order of maximum load capacity. " +
                        "Plane " + planes.get(numberOfPlaneMaxLoadCapacityIsLesserThanPreviouslyMaxLoadCapacity).getModel() +
                        " has max load capacity " +
                        planes.get(numberOfPlaneMaxLoadCapacityIsLesserThanPreviouslyMaxLoadCapacity).getMaxLoadCapacity() +
                        " that lesser than plane " +
                        planes.get(numberOfPlaneMaxLoadCapacityIsLesserThanPreviouslyMaxLoadCapacity - 1).getModel() +
                        " with max load capacity " +
                        planes.get(numberOfPlaneMaxLoadCapacityIsLesserThanPreviouslyMaxLoadCapacity - 1).getMaxLoadCapacity() +
                        "."
                );
    }

    @Test
    public void checkThatThereIsAtLeastOneMilitaryBomberPlaneAtTheAirport() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> listWithBomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        if (listWithBomberMilitaryPlanes.size() == 0) Assert.fail("There is not Military Bomber plane on airport");
        else {
            for (MilitaryPlane militaryPlane : listWithBomberMilitaryPlanes) {
                if (!(militaryPlane.getMilitaryTypePlane() == MilitaryType.BOMBER)) {
                    Assert.fail("There is not Military Bomber plane on airport");
                }
            }
        }
    }

    @Test
    public void checkThatInListWithExperimentalPlanesThereIsNotUnclassifiedPlane(){
        Airport airport = new Airport(planes);
        List<ExperimentalPlane> listWithExperimentalPlanes = airport.getExperimentalPlanes();
        boolean hasUnclassifiedPlanes = false;
        for(ExperimentalPlane experimentalPlane : listWithExperimentalPlanes){
            if(experimentalPlane.getPlaneClassificationLevel() == ClassificationLevel.UNCLASSIFIED){
                hasUnclassifiedPlanes = true;
                break;
            }
        }
        Assert.assertFalse(hasUnclassifiedPlanes, "There is Unclassified Experimental plane at the airport.");
    }
}
