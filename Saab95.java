import java.awt.*;

class Saab95 extends Vehicle{

    protected boolean turboOn;

    protected Saab95(){
        super(2, Color.red, 125, "Saab95");
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

    protected void activateTurbo(){
        turboOn = true;
    }
    protected void deactivateTurbo(){
        turboOn = false;
    }
}
