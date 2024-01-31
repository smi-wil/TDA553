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
}

