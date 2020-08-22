package planes;

import models.ClassificationLevel;
import models.ExperimentalTypes;

import java.util.Objects;

public class ExperimentalPlane extends Plane{

    private ExperimentalTypes experimentalTypePlane;
    private ClassificationLevel planeClassificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity,
                             ExperimentalTypes experimentalType, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalTypePlane = experimentalType;
        this.planeClassificationLevel = classificationLevel;
    }

    public ClassificationLevel getPlaneClassificationLevel(){
        return planeClassificationLevel;
    }

    public void setPlaneClassificationLevel(ClassificationLevel planeClassificationLevel){
        this.planeClassificationLevel = planeClassificationLevel;
    }

    public ExperimentalTypes getExperimentalTypePlane() {
        return experimentalTypePlane;
    }

    public void setExperimentalTypePlane(ExperimentalTypes experimentalTypePlane) {
        this.experimentalTypePlane = experimentalTypePlane;
    }

    @Override
    public boolean equals(Object comparedPlane) {
        if (!super.equals(comparedPlane)) return false;
        ExperimentalPlane experimentalPlane = (ExperimentalPlane) comparedPlane;
        return experimentalTypePlane == experimentalPlane.getExperimentalTypePlane() &&
                planeClassificationLevel == experimentalPlane.getPlaneClassificationLevel();
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", type=" + experimentalTypePlane +
                        ", classification level=" + planeClassificationLevel +
                        '}');
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), experimentalTypePlane, planeClassificationLevel);
    }

}
