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

    @Override
    public boolean equals(Object comparedPlane) {
        if (this == comparedPlane) return true;
        if (comparedPlane instanceof ExperimentalPlane) return true;
        if (super.equals(comparedPlane)) return true;
        ExperimentalPlane experimentalPlane = (ExperimentalPlane) comparedPlane;
        return comparedPlane == experimentalPlane.experimentalTypePlane
                && comparedPlane == experimentalPlane.planeClassificationLevel;
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
        return Objects.hash(super.hashCode(), experimentalTypePlane);
    }
}
