import java.awt.*;
import java.math.*;

class Volvo240 extends Car{

    private final static double trimFactor = 1.25;


    protected Volvo240(){
        super(4, Color.black, 100, "Volvo240");

        stopEngine();
    }
    @Override
    protected double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }
}