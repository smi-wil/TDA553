import java.awt.*;

abstract class Truck extends Vehicle {
    protected TruckBed truckBed;

    protected Truck(Color color, double enginePower, String modelName, TruckBed truckBed) {
        super(2, color, enginePower, modelName);
        this.truckBed = truckBed;
    }

    @Override
    public void gas(double amount) {
        if (truckBed.getTruckBedAngle() == 0) {
            super.gas(amount);
        }
    }

    public void increaseBedAngle() {
        if (currentSpeed == 0) {
            truckBed.increaseBedAngle(); // Increase angle only if the truck is stationary
        }
    }

    public void decreaseBedAngle() {
        if (currentSpeed == 0) {
            truckBed.decreaseBedAngle(); // Decrease angle only if the truck is stationary
        }
    }
    @Override
    protected double speedFactor() {
        return enginePower * 0.01;
    }
}

