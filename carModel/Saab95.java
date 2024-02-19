package carModel;

import java.awt.*;

public class Saab95 extends Car{

    protected boolean turboOn;

    public Saab95(){
        super(2, Color.red, 125, "carModel.Saab95", "pics/Saab95.jpg");
	    turboOn = false;
        stopEngine();
    }

    @Override
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) {
            turbo = 1.3;
        }
        return enginePower * 0.01 * turbo;
    }

     public void activateTurbo(){
        turboOn = true;
    }
     public void deactivateTurbo(){
        turboOn = false;
    }
}
