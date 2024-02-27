package carModel;

import java.awt.*;

public class Scania extends Truck {

    public Scania() {
        super(Color.pink, 1000, "Scania", new AdvancedTruckBed(), "pics/Scania.jpg");
        stopEngine();
    }
}



