import java.awt.*;

public class Scania extends Truck {

    protected Scania(Color color, String modelName) {
        super(color, 300, modelName, new AdvancedTruckBed());
        stopEngine();
    }
}




