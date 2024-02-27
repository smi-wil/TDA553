package carModel;

import java.awt.*;

public abstract class Truck extends Vehicle {
    public TruckBed truckBed;

    protected Truck(Color color, double enginePower, String modelName, TruckBed truckBed, String imagePath) {
        super(2, color, enginePower, modelName, imagePath);
        this.truckBed = truckBed;
    }

    @Override
    public void gas(double amount) {
        if (truckBed.getTruckBedAngle() == 0) {
            super.gas(amount);
        }
    }
    @Override
    public void startEngine() {
        if (truckBed.getTruckBedAngle() == 0) {
            super.startEngine();
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

