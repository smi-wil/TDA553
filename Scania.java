import java.awt.*;

public class Scania extends Truck implements HasTruckBed {

    protected TruckBed truckBed = new TruckBed();

    protected Scania(Color color, String modelName) {
        super(color, 1000, modelName);
        // this.truckBed = new TruckBed();
        stopEngine();
    }

    @Override
    protected double speedFactor() {
        return enginePower * 0.01;
    }
    @Override
    public void increaseBedAngle(){
        //change tilt angle
        int currentAngle = truckBed.getTruckBedAngle();
        if (currentAngle <= 65 && currentSpeed == 0) {
            truckBed.setTruckBedAngle(currentAngle+5);
        }
    }
    @Override
    public void decreaseBedAngle() {
        //change tilt angle
        int currentAngle = truckBed.getTruckBedAngle();
        if (currentAngle >= 5 && currentSpeed == 0) {
            truckBed.setTruckBedAngle(currentAngle-5);
        }
    }

    @Override
    public void move() {
        try{
            if (truckBed.getTruckBedAngle() != 0) {
                throw new IllegalArgumentException("Truck bed angle must be 0");
             }
            super.move();
        }
        catch (IllegalArgumentException e){
            System.out.print(e.getMessage());
        }
    }
}


