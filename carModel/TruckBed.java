package carModel;

public abstract class TruckBed {
    protected int truckBedAngle;

    public TruckBed() {
        this.truckBedAngle = 0;
    }

    public int getTruckBedAngle() {
        return truckBedAngle;
    }

    public void setTruckBedAngle(int angle) {
        truckBedAngle = angle;
    }

    // Abstract methods to be implemented by subclasses
    abstract void increaseBedAngle();

    abstract void decreaseBedAngle();
}