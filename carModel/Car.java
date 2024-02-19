package carModel;

import java.awt.*;

 public abstract class Car extends Vehicle {
     protected Car(int nrDoors, Color color,double enginePower, String modelName, String image) {
        super(nrDoors, color, enginePower, modelName, image);

    }
}
