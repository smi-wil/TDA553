import java.awt.*;

public class Scania extends Vehicle {

    protected double truckBedAngle;

    protected Scania() {
        super(2, Color.pink, 1000, "Scania");
        truckBedAngle = 0;
        stopEngine();
    }

    @Override
    protected double speedFactor() {
        return enginePower * 0.01;
    }

    protected void increaseAngle() {
        //change tilt angle
        if (truckBedAngle <= 65 && currentSpeed == 0) {
            truckBedAngle += 5;
        }


    }

    protected void decreaseAngle() {
        //change tilt angle
        if (truckBedAngle >= 5 && currentSpeed == 0) {
            truckBedAngle -= 5;
        }
    }

    @Override
    public void move() {
        if (truckBedAngle == 0) {
            super.move();
        }
    }
}


