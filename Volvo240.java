import java.awt.*;
import java.math.*;

public class Volvo240 extends Vehicle {

    public final static double trimFactor = 1.25;

    
    public Volvo240(){
        super(4, 100, Color.BLACK, "Volvo240");
        stopEngine();
    }

    
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }




}
