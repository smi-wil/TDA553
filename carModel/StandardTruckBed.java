package carModel;

public class StandardTruckBed extends TruckBed {
    @Override
    public void increaseBedAngle() {
        if (truckBedAngle < 70) {
            setTruckBedAngle(70);
        }
    }

    @Override
    public void decreaseBedAngle() {
        if (truckBedAngle > 0) {
            setTruckBedAngle(0);
        }
    }
}
