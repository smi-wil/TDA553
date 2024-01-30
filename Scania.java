import java.awt.*;

public class Scania extends Truck implements HasBed{

    protected TruckBed truckBed;

    protected Scania(Color color, String modelName) {
        super(color, 1000, modelName);
        TruckBed truckBed = new TruckBed();
        stopEngine();
    }

    @Override
    protected double speedFactor() {
        return enginePower * 0.01;
    }
    public void increaseBedAngle(){
        truckBed.increaseBedAngle(currentSpeed);
    }
    public void decreaseBedAngle() {
        truckBed.decreaseBedAngle(currentSpeed);
    }

    @Override
    public void move() {
        try{
            if (truckBed.truckBedAngle != 0) {
                throw new IllegalArgumentException("Truck bed angle must be 0");
             }
            super.move();
        }
        catch (IllegalArgumentException e){
            System.out.print(e.getMessage());
        }
    }
}


