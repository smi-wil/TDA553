import java.awt.*;

public class Scania extends Truck {


    protected Scania(Color color, String modelName) {
        super(color, 1000, modelName);
        stopEngine();
    }

    @Override
    protected double speedFactor() {
        return enginePower * 0.01;
    }

    @Override
    public void increaseBedAngle() {
        //change tilt angle
        int currentAngle = truckBed.getTruckBedAngle();
        if (currentAngle <= 65 && currentSpeed == 0) {
            truckBed.setTruckBedAngle(currentAngle + 5);
        }
    }

    @Override
    public void decreaseBedAngle() {
        //change tilt angle
        int currentAngle = truckBed.getTruckBedAngle();
        if (currentAngle >= 5 && currentSpeed == 0) {
            truckBed.setTruckBedAngle(currentAngle - 5);
        }
    }
}





