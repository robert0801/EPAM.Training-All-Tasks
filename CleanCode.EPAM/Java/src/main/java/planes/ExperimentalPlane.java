package planes;

import models.ClassificationLevel;
import models.ExperimentalTypes;

public class ExperimentalPlane extends Plane{

    private ExperimentalTypes experimentalTypePlanes;
    private ClassificationLevel planeClassificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalTypes experimentalTypePlanes, ClassificationLevel planeClassificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalTypePlanes = experimentalTypePlanes;
        this.planeClassificationLevel = planeClassificationLevel;
    }

    public ClassificationLevel getPlaneClassificationLevel(){
        return planeClassificationLevel;
    }

    public void setPlaneClassificationLevel(ClassificationLevel planeClassificationLevel){
        this.planeClassificationLevel = planeClassificationLevel;
    }

    @Override
    public boolean equals(Object planeForComparison) {
        return super.equals(planeForComparison);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "experimentalPlane{" +
                "model='" + model + '\'' +
                '}';
    }
}
