import java.awt.*;

public class Scania extends Vehicle {

    protected double truckBedAngle;

    protected Scania(Color color, String modelName) {
        super(2, color, 1000, modelName);
        truckBedAngle = 0;

        stopEngine();
    }

    @Override
    protected double speedFactor() {
        return enginePower * 0.01;
    }

    protected void increaseBedAngle() {
        //change tilt angle
        if (truckBedAngle <= 65 && currentSpeed == 0) {
            truckBedAngle += 5;
        }
    }

    protected void decreaseBedAngle() {
        //change tilt angle
        if (truckBedAngle >= 5 && currentSpeed == 0) {
            truckBedAngle -= 5;
        }
    }
    protected double getBedTruckAngle(){
        return truckBedAngle;
    }

    @Override
    public void move() {
        try{
            if (truckBedAngle != 0) {
                throw new IllegalArgumentException("Truck bed angle must be 0");
             }
            super.move();
        }
        catch (IllegalArgumentException e){
            System.out.print(e.getMessage());
        }
    }
}


