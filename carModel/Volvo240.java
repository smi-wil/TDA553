package carModel;

import javax.imageio.ImageIO;
import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;


    public Volvo240(){
        super(4, Color.black, 100, "Volvo240", "pics/Volvo240.jpg" );

        stopEngine();
    }
    @Override
    protected double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }
}