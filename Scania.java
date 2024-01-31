import java.awt.*;

public class Scania extends Truck {
    protected Scania(Color color, String modelName) {
        super(color, 1000, modelName, new AdvancedTruckBed());
        stopEngine();
    }

    @Override
    protected double speedFactor() {
        return enginePower * 0.01;
    }


}





