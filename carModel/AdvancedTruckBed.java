package carModel;

public class AdvancedTruckBed extends TruckBed {
    @Override
    public void increaseBedAngle() {
        if (truckBedAngle <= 65) {
            setTruckBedAngle(truckBedAngle + 5);
        }
    }

    @Override
    public void decreaseBedAngle() {
        if (truckBedAngle >= 5) {
            setTruckBedAngle(truckBedAngle - 5);
        }
    }
}
