import java.awt.*;

abstract class Truck extends Vehicle {

        protected TruckBed truckBed = new TruckBed();
        protected Truck(Color color, double enginePower, String modelName) {
            super(2, color, enginePower, modelName);

        }
        abstract void increaseBedAngle();
        abstract void decreaseBedAngle();
        @Override
        public void gas(double amount) {
                if (truckBed.getTruckBedAngle() == 0){
                    super.gas(amount);
        }
    }
}

