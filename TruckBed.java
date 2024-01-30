public class TruckBed implements HasBed{

        int truckBedAngle;
        boolean truckBedUp;
        public TruckBed(){
            int truckBedAngle = 0;
            boolean truckBedUp = true;
        }


        public void increaseBedAngle(double currentSpeed) {
            //change tilt angle
            if (truckBedAngle <= 65 && currentSpeed == 0) {
                truckBedAngle += 5;
            }
        }

        public void decreaseBedAngle(double currentSpeed){
            //change tilt angle
            if (truckBedAngle >= 5 && currentSpeed == 0) {
                truckBedAngle -= 5;
            }
        }
    public void increaseBedAngle(boolean truckBedUp, double currentSpeed) {
        if (currentSpeed == 0) {
            this.truckBedUp = true;
        }
    }

    public void decreaseBedAngle(boolean truckBedUp, double currentSpeed){
        if (currentSpeed == 0) {
            this.truckBedUp = false;
        }
    }
    }

}
